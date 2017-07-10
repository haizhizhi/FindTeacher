package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DTO.TeachMsgDTO;

public interface TeachMsgDAO {
	/**
	 * 插入培训信息
	 * @param conn
	 * @param dao
	 * @return
	 * @throws SQLException
	 */
	public Boolean insertTeachMsg(Connection conn,TeachMsgDTO dto) throws SQLException;

	
	public List<TeachMsgDTO> findTeachMsg(Connection conn,String scope,String teacherOrTitle,String msg) throws SQLException;

	public List<TeachMsgDTO> findOwnTeachMsg(Connection conn,int i) throws SQLException;
	
	
	public TeachMsgDTO findTeachMsgById(Connection conn,String id) throws SQLException;
	
	public List<TeachMsgDTO> findTeachMsgBySelected(Connection conn,String scopeName,String typeName,String levelName) throws SQLException;
	
	public boolean deleteTeachMsgById(Connection conn,String id) throws SQLException;
	
	public boolean updateTeachJoinNumberMsgById(Connection conn,String id) throws SQLException;
	
}
