package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DTO.JoinTeachDTO;

public interface JoinTeachDAO {
	public List<JoinTeachDTO> getAllMsgByUserId(Connection conn,int it) throws SQLException;
	public boolean insertIoinMsg(Connection conn,JoinTeachDTO dto) throws SQLException;
}
