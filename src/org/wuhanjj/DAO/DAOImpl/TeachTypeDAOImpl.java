package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wuhanjj.DAO.TeachTypeDAO;
import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;
import org.wuhanjj.DTO.TeachTypeDTO;

public class TeachTypeDAOImpl implements TeachTypeDAO{

	@Override
	public List<TeachTypeDTO> getMsgByTeachScope(Connection conn,TeachScopeDTO scope) throws SQLException {
		String sql;
		if(scope.getId().equals("G")){
			 sql="select id,teachType,belong_G,belong_C,belong_X from teachtype where belong_G=1";
		}else if(scope.getId().equals("C")){
			 sql="select id,teachType,belong_G,belong_C,belong_X from teachtype where belong_C=1";
		}else{
			 sql="select id,teachType,belong_G,belong_C,belong_X from teachtype where belong_X=1";
		}
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<TeachTypeDTO> list=new ArrayList<TeachTypeDTO>();
		TeachTypeDTO teachTypeDTO=null;
		while(rs.next()){
			teachTypeDTO=new TeachTypeDTO();
			teachTypeDTO.setId(rs.getString("id"));
			teachTypeDTO.setTeachType(rs.getString("teachType"));
			teachTypeDTO.setBelong_G(rs.getInt("belong_G"));
			teachTypeDTO.setBelong_C(rs.getInt("belong_C"));
			teachTypeDTO.setBelong_X(rs.getInt("belong_X"));
			list.add(teachTypeDTO);
		}
		return list;
	}

	@Override
	public TeachTypeDTO getTeachTypeDTOByTypeName(Connection conn, String typeName) throws SQLException {
		System.out.println(typeName);
		String sql="select id,teachType,belong_G,belong_C,belong_X from teachtype where teachType=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, typeName);
		ResultSet rs=ps.executeQuery();
		TeachTypeDTO teachTypeDTO=null;
		System.out.println("@@@@@@@@@@@@@@@@@");
		if(rs.next()){
			System.out.println("@@@@@@@@@@@@@@@@@^^^^^^^");
			teachTypeDTO=new TeachTypeDTO();
			teachTypeDTO.setId(rs.getString("id"));
			teachTypeDTO.setTeachType(rs.getString("teachType"));
			teachTypeDTO.setBelong_G(rs.getInt("belong_G"));
			teachTypeDTO.setBelong_C(rs.getInt("belong_C"));
			teachTypeDTO.setBelong_X(rs.getInt("belong_X"));
		}
		return teachTypeDTO;
		
	}

	@Override
	public TeachTypeDTO getTeachTypeDTOByTypeId(Connection conn, String typeId) throws SQLException {
		String sql="select id,teachType,belong_G,belong_C,belong_X from teachtype where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, typeId);
		ResultSet rs=ps.executeQuery();
		TeachTypeDTO teachTypeDTO=null;
		System.out.println("@@@@@@@@@@@@@@@@@");
		if(rs.next()){
			System.out.println("@@@@@@@@@@@@@@@@@^^^^^^^");
			teachTypeDTO=new TeachTypeDTO();
			teachTypeDTO.setId(rs.getString("id"));
			teachTypeDTO.setTeachType(rs.getString("teachType"));
			teachTypeDTO.setBelong_G(rs.getInt("belong_G"));
			teachTypeDTO.setBelong_C(rs.getInt("belong_C"));
			teachTypeDTO.setBelong_X(rs.getInt("belong_X"));
		}
		return teachTypeDTO;
	}

}
