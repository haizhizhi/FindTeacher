package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wuhanjj.DAO.UserDAO;
import org.wuhanjj.DTO.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserDTO checkUserMsg(Connection conn, UserDTO dto) throws SQLException {
		
		String sql="select id,userName,userPassword,type,nickName from users where userName=? and userPassword=? and type=?";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println(dto.getName()+dto.getPassword()+dto.getType());
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getType());
		ResultSet rs=ps.executeQuery();
		//传到LoginAction的实体对象
		UserDTO dto1=null;
		//判断结果集是否有下一条，如果有封装dto1对象
		if(rs.next()){
			dto1=new UserDTO();
			dto1.setId(rs.getInt("id"));
			dto1.setName(rs.getString("userName"));
			dto1.setPassword(rs.getString("userPassword"));
			dto1.setType(rs.getString("type"));
			dto1.setNickName(rs.getString("nickName"));
		}
		return dto1;	
	}

	@Override
	public boolean insertUser(Connection conn, UserDTO dto) throws SQLException {
		String sql="insert into users values(NULL,?,?,?,'^-^')";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getType());
		int i=ps.executeUpdate();
		if(i==1){
			conn.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean changeUserMsg(Connection conn, UserDTO dto) throws SQLException {
		String sql=null;
		PreparedStatement ps=null;
		if(dto.getNickName()!=null){
			sql="update users set nickName=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getNickName());
		}
		if(dto.getPassword()!=null){
			sql="update users set userPassword=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getPassword());
		}
		ps.setInt(2, dto.getId());
		int i=ps.executeUpdate();
		if(i==1){
			conn.commit();
			return true;
		}
		return false;
	}

}
