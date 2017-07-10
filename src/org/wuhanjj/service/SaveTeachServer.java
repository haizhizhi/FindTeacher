package org.wuhanjj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DAO.JoinTeachDAO;
import org.wuhanjj.DAO.SaveTeachDAO;
import org.wuhanjj.DAO.TeachLevelDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DBUtil.DbUtil;
import org.wuhanjj.DTO.JoinTeachDTO;
import org.wuhanjj.DTO.SaveTeachDTO;
import org.wuhanjj.DTO.TeachLevelDTO;

public class SaveTeachServer {
	private SaveTeachDAO saveDAO;
	
	public SaveTeachServer(){
		saveDAO=DAOFactory.getSaveTeachDAO();
	}
	public List<SaveTeachDTO>  getSaveMsg(int i) throws SQLException, ClassNotFoundException{
		Connection conn=DbUtil.getConnection();
		List<SaveTeachDTO> list=saveDAO.getAllSaveMsgByUserId(conn, i);
		conn.close();
		return list;
	}
	public boolean insertSaveMsg(SaveTeachDTO dto) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		Boolean b=saveDAO.insertIoinSaveMsg(conn, dto);
		conn.close();
		return b;
	}
}
