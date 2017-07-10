package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;

public interface TeachLevelDAO {
	/**
	 * 通过教学范围获得教学年级信息
	 * @param scope 教学范围对象
	 * @return 返回教学年级集合
	 * @throws SQLException SQL连接或语句异常
	 */
	public List<TeachLevelDTO> getAllMsgByScope(Connection conn,TeachScopeDTO scope) throws SQLException;
	/**
	 * 通过年级名找到年级 对象
	 * @param conn 连接对象
	 * @param levelName 年级名
	 * @return 返回年级实体类
	 * @throws SQLException SQL连接或语句异常
	 */
	public TeachLevelDTO getTeachLevelDTOByLevelName(Connection conn,String levelName)throws SQLException;
	
	/**
	 * 通过年级名找到年级 对象
	 * @param conn 连接对象
	 * @param levelName 年级名
	 * @return 返回年级实体类
	 * @throws SQLException SQL连接或语句异常
	 */
	public TeachLevelDTO getTeachLevelDTOByLevelId(Connection conn,String levelId)throws SQLException;

}
