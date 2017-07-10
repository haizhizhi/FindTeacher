package org.wuhanjj.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.wuhanjj.DAO.UserDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DBUtil.DbUtil;
import org.wuhanjj.DTO.UserDTO;

public class UsersService {
	private UserDAO userDAO;
	public UsersService(){
		this.userDAO=DAOFactory.getUserDAO();
	}
	/**
	 * 检查登录界面用户输入的信息
	 * @param dto 用户实体对象
	 * @return 用户信息正确返回true，否则返回false
	 * @throws SQLException 数据库链接或sql语句异常
	 * @throws ClassNotFoundException 类找不到
	 */
	public  UserDTO checkLoginMsg(UserDTO dto) throws ClassNotFoundException, SQLException{
		
		//获得连接对象
		Connection conn=DbUtil.getConnection();
		//检测用户的登录信息
		UserDTO dto1=userDAO.checkUserMsg(conn, dto);
		conn.close();
		return dto1;
	}
	public Boolean registerUser(UserDTO dto) throws SQLException, ClassNotFoundException{
		//获得连接对象
		Connection conn=DbUtil.getConnection();
		return userDAO.insertUser(conn, dto);
	}
	
	public Boolean changeUserMsg(UserDTO dto) throws SQLException, ClassNotFoundException{
		//获得连接对象
		Connection conn=DbUtil.getConnection();
		return userDAO.changeUserMsg(conn, dto);
	}
}
