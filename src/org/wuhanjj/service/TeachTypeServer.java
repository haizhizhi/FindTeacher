package org.wuhanjj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DAO.TeachTypeDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DBUtil.DbUtil;
import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;
import org.wuhanjj.DTO.TeachTypeDTO;

public class TeachTypeServer {
	private TeachTypeDAO teachTypeDAO;
	
	public TeachTypeServer(){
		teachTypeDAO=DAOFactory.getTeachTypeDAO();
	}
	public List<TeachTypeDTO> getTypeAllMsgByScope(TeachScopeDTO scope) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		List<TeachTypeDTO> list=teachTypeDAO.getMsgByTeachScope(conn, scope);
		conn.close();
		return list;
	}
	public TeachTypeDTO getTeachTypeDTO(String typeName) throws SQLException, ClassNotFoundException{
		Connection conn=DbUtil.getConnection();
		TeachTypeDTO teachTypeDTO=teachTypeDAO.getTeachTypeDTOByTypeName(conn, typeName);
		conn.close();
		return teachTypeDTO;
	}
}
