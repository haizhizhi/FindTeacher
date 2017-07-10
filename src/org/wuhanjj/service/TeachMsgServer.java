package org.wuhanjj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DAO.TeachMsgDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DBUtil.DbUtil;
import org.wuhanjj.DTO.TeachMsgDTO;

public class TeachMsgServer {
private TeachMsgDAO teachMsgDAO;
	
	public TeachMsgServer(){
		teachMsgDAO=DAOFactory.getTeachMsgDAO();
	}
	public boolean insertTeachMsg(TeachMsgDTO dto) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		Boolean insertSOE=teachMsgDAO.insertTeachMsg(conn, dto);
		conn.close();
		return insertSOE;
	}
	public List<TeachMsgDTO> getTeachMsg(String scope,String teacherOrTitle,String msg) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		List<TeachMsgDTO> list=teachMsgDAO.findTeachMsg(conn, scope, teacherOrTitle, msg);
		conn.close();
		return list;
	}
	
	public List<TeachMsgDTO> getOwnTeachMsg(int i) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		List<TeachMsgDTO> list=teachMsgDAO.findOwnTeachMsg(conn, i);
		conn.close();
		return list;
	}
	public TeachMsgDTO getJoinTeachMsg(String id) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		TeachMsgDTO dto=teachMsgDAO.findTeachMsgById(conn, id);
		conn.close();
		return dto;
	}
	
	public TeachMsgDTO getSaveTeachMsg(String id) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		TeachMsgDTO dto=teachMsgDAO.findTeachMsgById(conn, id);
		conn.close();
		return dto;
	}
	
	public List<TeachMsgDTO> getTeachMsgBySelected(String scopeName,String typeName,String levelName) throws ClassNotFoundException, SQLException{
		Connection conn=DbUtil.getConnection();
		List<TeachMsgDTO> list=teachMsgDAO.findTeachMsgBySelected(conn, scopeName, typeName, levelName);
		conn.close();
		return list;
	}
	
	public boolean deleteTeachMsgById(String id) throws SQLException, ClassNotFoundException{
		Connection conn=DbUtil.getConnection();
		boolean bol=teachMsgDAO.deleteTeachMsgById(conn, id);
		conn.close();
		return bol;
	}
	public boolean updateTeachMsg(String id) throws SQLException, ClassNotFoundException{
		Connection conn=DbUtil.getConnection();
		boolean bol=DAOFactory.getTeachMsgDAO().updateTeachJoinNumberMsgById(conn, id);
		return bol;
	}
}
