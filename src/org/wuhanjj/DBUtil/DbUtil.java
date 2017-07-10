package org.wuhanjj.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * 
 * @author dhc
 *
 */
public class DbUtil {

	/**
	 * 获得数据库连接对象
	 * @return java.sql.Connection类型
	 * @throws ClassNotFoundException
	 *             数据库驱动加载失败
	 * @throws SQLException
	 *             数据库连接失败
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("AAA");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/findteacher?useUnicode=true&characterEncoding=UTF-8", "root", "123");
		conn.setAutoCommit(false);
		return conn;
	}

}
