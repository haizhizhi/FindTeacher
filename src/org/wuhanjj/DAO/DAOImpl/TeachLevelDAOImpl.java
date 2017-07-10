package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wuhanjj.DAO.TeachLevelDAO;
import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;
import org.wuhanjj.DTO.TeachTypeDTO;

public class TeachLevelDAOImpl implements TeachLevelDAO {

	@Override
	public List<TeachLevelDTO> getAllMsgByScope(Connection conn,TeachScopeDTO scope) throws SQLException {
		String sql="select id,teachLevel,belong from teachlevel where belong=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, scope.getId());
		ResultSet rs=ps.executeQuery();
		List<TeachLevelDTO> list=new ArrayList<TeachLevelDTO>();
		TeachLevelDTO teachLevelDTO=null;
		while(rs.next()){
			teachLevelDTO=new TeachLevelDTO();
			teachLevelDTO.setId(rs.getString("id"));
			teachLevelDTO.setTeachLevelName(rs.getString("teachLevel"));
			teachLevelDTO.setBelong(rs.getString("belong"));
			list.add(teachLevelDTO);
		}
		return list;
	}

	@Override
	public TeachLevelDTO getTeachLevelDTOByLevelName(Connection conn, String levelName) throws SQLException {
		String sql="select id,teachLevel,belong from teachlevel where teachLevel=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, levelName);
		ResultSet rs=ps.executeQuery();
		TeachLevelDTO teachLevelDTO=null;
		if(rs.next()){
			teachLevelDTO=new TeachLevelDTO();
			teachLevelDTO.setId(rs.getString("id"));
			teachLevelDTO.setTeachLevelName(rs.getString("teachLevel"));
			teachLevelDTO.setBelong(rs.getString("belong"));
		}
		return teachLevelDTO;
	}

	@Override
	public TeachLevelDTO getTeachLevelDTOByLevelId(Connection conn, String levelId) throws SQLException {
		String sql="select id,teachLevel,belong from teachlevel where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, levelId);
		ResultSet rs=ps.executeQuery();
		TeachLevelDTO teachLevelDTO=null;
		if(rs.next()){
			teachLevelDTO=new TeachLevelDTO();
			teachLevelDTO.setId(rs.getString("id"));
			teachLevelDTO.setTeachLevelName(rs.getString("teachLevel"));
			teachLevelDTO.setBelong(rs.getString("belong"));
		}
		return teachLevelDTO;
	}

}
