package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.wuhanjj.DTO.UserDTO;

public interface UserDAO {
	/**
	 * 检测用户登录等信息的正确性
	 * @param conn 数据库连接对象
	 * @param dto 用户实体类
	 * @return 返回用户实体类
	 * @throws SQLException 数据库连接异常或者SQL语句异常
	 */
	public UserDTO checkUserMsg(Connection conn,UserDTO dto) throws SQLException;
	/**
	 * 注册用户的信息
	 * @param conn 数据库连接信息
	 * @param dto 用户实体类
	 * @return 检测成功返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean insertUser(Connection conn,UserDTO dto) throws SQLException;
	/**昵称
	 * 修改用户信息
	 * @param conn
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public boolean changeUserMsg(Connection conn,UserDTO dto) throws SQLException;
	
}
