package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DTO.JoinTeachDTO;
import org.wuhanjj.DTO.SaveTeachDTO;

public interface SaveTeachDAO {
	
	public List<SaveTeachDTO> getAllSaveMsgByUserId(Connection conn,int it) throws SQLException;
	
	
	public boolean insertIoinSaveMsg(Connection conn,SaveTeachDTO dto) throws SQLException;
}
