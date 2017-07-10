package org.wuhanjj.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;
import org.wuhanjj.DTO.TeachTypeDTO;

public interface TeachTypeDAO {
	/**
	 * 通过教学范围，获得教学类型
	 * @param scope 教学范围
	 * @return 范围教学类型集合
	 * @throws SQLException SQL连接或语句异常
	 */
	public List<TeachTypeDTO> getMsgByTeachScope(Connection conn,TeachScopeDTO scope)throws SQLException;
	/**
	 * 通过学科名找到学科 对象
	 * @param conn 连接对象
	 * @param typeName 学科名
	 * @return 返回学科实体类
	 * @throws SQLException SQL连接或语句异常
	 */
	public TeachTypeDTO getTeachTypeDTOByTypeName(Connection conn,String typeName)throws SQLException;
	
	/**
	 * 通过学科名找到学科 对象
	 * @param conn 连接对象
	 * @param typeName 学科名
	 * @return 返回学科实体类
	 * @throws SQLException SQL连接或语句异常
	 */
	public TeachTypeDTO getTeachTypeDTOByTypeId(Connection conn,String typeId)throws SQLException;
	
}
