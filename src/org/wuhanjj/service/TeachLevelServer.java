package org.wuhanjj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DAO.TeachLevelDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DBUtil.DbUtil;
import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;

public class TeachLevelServer {
	private TeachLevelDAO teachLevelDAO;
	
	public TeachLevelServer(){
		teachLevelDAO=DAOFactory.getTeachLevelDAO();
	}
	public List<TeachLevelDTO> getLevelAllMsgByScope(TeachScopeDTO scope) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		List<TeachLevelDTO> list=teachLevelDAO.getAllMsgByScope(conn, scope);
		return list;
	}
	
	public TeachLevelDTO getTeachLevelDTO(String levelName) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		TeachLevelDTO teachLevelDTO=teachLevelDAO.getTeachLevelDTOByLevelName(conn, levelName);
		conn.close();
		return teachLevelDTO;
	}
}
