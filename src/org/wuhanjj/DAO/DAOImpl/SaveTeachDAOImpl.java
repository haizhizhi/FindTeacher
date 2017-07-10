package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wuhanjj.DAO.JoinTeachDAO;
import org.wuhanjj.DAO.SaveTeachDAO;
import org.wuhanjj.DTO.JoinTeachDTO;
import org.wuhanjj.DTO.SaveTeachDTO;

public class SaveTeachDAOImpl implements SaveTeachDAO {

	@Override
	public List<SaveTeachDTO> getAllSaveMsgByUserId(Connection conn, int it) throws SQLException {
		String sql="select * from saveteach where userId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, it);
		ResultSet rs=ps.executeQuery();
		List<SaveTeachDTO> list =new ArrayList<SaveTeachDTO>();
		SaveTeachDTO dto=null;
		while(rs.next()){
			dto=new SaveTeachDTO();
			dto.setSaveId(rs.getInt("joinId"));
			dto.setUserId(rs.getInt("userId"));
			dto.setTeachMsgId(rs.getString("teachmsgId"));
			list.add(dto);
		}
		return list;
	}

	@Override
	public boolean insertIoinSaveMsg(Connection conn, SaveTeachDTO dto) throws SQLException {
		String sql="insert into saveteach values(null,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, dto.getUserId());
		ps.setString(2, dto.getTeachMsgId());
		int i=ps.executeUpdate();
		if(i==1){
			conn.commit();
			return true;
		}
		return false;
	}

	

}
