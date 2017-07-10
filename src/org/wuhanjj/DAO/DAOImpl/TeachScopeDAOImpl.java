package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wuhanjj.DAO.TeachScopeDAO;
import org.wuhanjj.DTO.TeachMsgDTO;
import org.wuhanjj.DTO.TeachScopeDTO;

public class TeachScopeDAOImpl implements TeachScopeDAO{

	@Override
	public TeachScopeDTO getAllTeachScopeMsg(Connection conn, String scopeName) throws SQLException {
		String sql="select * from teachscope where teachScopeName=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, scopeName);
		ResultSet rs =ps.executeQuery();
		TeachScopeDTO dto=null;
		if(rs.next()){
			dto=new TeachScopeDTO();
			dto.setId(rs.getString("id"));
			dto.setTeachScopeName(rs.getString("teachScopeName"));
		}
		return dto;
	
	}

}
