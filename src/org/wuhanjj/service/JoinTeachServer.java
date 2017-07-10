package org.wuhanjj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DAO.JoinTeachDAO;
import org.wuhanjj.DAO.TeachLevelDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DBUtil.DbUtil;
import org.wuhanjj.DTO.JoinTeachDTO;
import org.wuhanjj.DTO.TeachLevelDTO;

public class JoinTeachServer {
	private JoinTeachDAO joinDAO;
	
	public JoinTeachServer(){
		joinDAO=DAOFactory.getJoinTeachMsgDAO();
	}
	public List<JoinTeachDTO>  getJoinMsg(int i) throws SQLException, ClassNotFoundException{
		Connection conn=DbUtil.getConnection();
		List<JoinTeachDTO> list=joinDAO.getAllMsgByUserId(conn, i);
		conn.close();
		return list;
	}
	public boolean insertJoinMsg(JoinTeachDTO dto) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		Boolean b=joinDAO.insertIoinMsg(conn, dto);
		conn.close();
		return b;
	}
}
