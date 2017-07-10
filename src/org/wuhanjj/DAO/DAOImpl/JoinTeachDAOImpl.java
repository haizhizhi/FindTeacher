package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wuhanjj.DAO.JoinTeachDAO;
import org.wuhanjj.DTO.JoinTeachDTO;

public class JoinTeachDAOImpl implements JoinTeachDAO {

	@Override
	public List<JoinTeachDTO> getAllMsgByUserId(Connection conn, int it) throws SQLException {
		String sql="select * from jointeach where userId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, it);
		ResultSet rs=ps.executeQuery();
		List<JoinTeachDTO> list =new ArrayList<JoinTeachDTO>();
		JoinTeachDTO dto=null;
		while(rs.next()){
			dto=new JoinTeachDTO();
			dto.setJoinTeachId(rs.getInt("joinId"));
			dto.setUserId(rs.getInt("userId"));
			dto.setTeachMsgId(rs.getString("teachmsgId"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public boolean insertIoinMsg(Connection conn, JoinTeachDTO dto) throws SQLException {
		String sql="insert into jointeach values(null,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, dto.getUserId());
		ps.setString(2, dto.getTeachMsgId());
		int i=ps.executeUpdate();
		if(i==1){
			System.out.println("报名成功！！！！");
			conn.commit();
			return true;
		}
		return false;
	}

}
