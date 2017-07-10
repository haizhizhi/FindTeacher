package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DTO.TeachScopeDTO;

public interface TeachScopeDAO {
	/**
	 * 获得所有教学范围信息
	 * @return 所有教学信息列表
	 * @throws SQLException SQL语句或连接异常
	 */
	public TeachScopeDTO getAllTeachScopeMsg(Connection conn,String scopeName) throws SQLException;
}
