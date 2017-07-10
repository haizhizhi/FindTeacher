package org.wuhanjj.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wuhanjj.DAO.TeachMsgDAO;
import org.wuhanjj.DAOFactory.DAOFactory;
import org.wuhanjj.DTO.TeachMsgDTO;

public class TeachMsgDAOImpl implements TeachMsgDAO{

	@Override
	public Boolean insertTeachMsg(Connection conn, TeachMsgDTO dto) throws SQLException {
		System.out.println(dto.getOpenDate());
		String sql="insert into teachmsg values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getTeacher());
		ps.setString(3, dto.getTitle());
		ps.setString(4, dto.getPosition());
		ps.setString(5, new TeachTypeDAOImpl().getTeachTypeDTOByTypeName(conn, dto.getTeachTypeId()).getId());
		ps.setString(6, new TeachLevelDAOImpl().getTeachLevelDTOByLevelName(conn, dto.getTeachLevelId()).getId());
		ps.setString(7, dto.getPhone());
		ps.setInt(8, dto.getAimNumber());
		ps.setInt(9, 0);
		ps.setString(10, dto.getOpenDate());
		ps.setInt(11, dto.getPrice());
		int i=ps.executeUpdate();
		if(i==1){
			conn.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<TeachMsgDTO> findTeachMsg(Connection conn, String scope,String teacherOrTitle,String msg) throws SQLException {
		StringBuilder sql=null;
		PreparedStatement ps=null;
		if(teacherOrTitle.equals("teacher")){
			sql=new StringBuilder("select * from teachmsg where teacher=?");
			ps=conn.prepareStatement(sql.toString());
			ps.setString(1, msg);
		}else if(teacherOrTitle.equals("title")){
			sql=new StringBuilder("select * from teachmsg where title like '%"+msg+"%'");
			ps=conn.prepareStatement(sql.toString());
		}
		else if(scope==null){
			sql=new StringBuilder("select * from teachmsg");
			ps=conn.prepareStatement(sql.toString());
		}else{
			sql=new StringBuilder("select * from teachmsg where teachLevelId like '"+scope+"%'");
			ps=conn.prepareStatement(sql.toString());
		}
		ResultSet rs=ps.executeQuery();
		List<TeachMsgDTO> list =new ArrayList<TeachMsgDTO>();
		TeachMsgDTO teachMsgDTO=null;
		while(rs.next()){
			teachMsgDTO=new TeachMsgDTO();
			teachMsgDTO.setId(rs.getString("id"));
			teachMsgDTO.setTeacher(rs.getString("teacher"));
			teachMsgDTO.setTitle(rs.getString("title"));
			teachMsgDTO.setTeachLevelId(new TeachLevelDAOImpl().getTeachLevelDTOByLevelId(conn, rs.getString("teachLevelId")).getTeachLevelName());
			teachMsgDTO.setTeachTypeId(new TeachTypeDAOImpl().getTeachTypeDTOByTypeId(conn, rs.getString("teachTypeId")).getTeachType());
			teachMsgDTO.setPosition(rs.getString("phone"));
			teachMsgDTO.setAimNumber(rs.getInt("aimNumber"));
			teachMsgDTO.setJoinNumber(rs.getInt("joinNumber"));
			teachMsgDTO.setOpenDate(rs.getString("openDate"));
			teachMsgDTO.setPrice(rs.getInt("price"));
			list.add(teachMsgDTO);
		}
		return list;
	}

	@Override
	public List<TeachMsgDTO> findOwnTeachMsg(Connection conn,int i) throws SQLException {
		System.out.println(i);
		String sql="select * from teachmsg where id like '_"+i+"-%'";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<TeachMsgDTO> list =new ArrayList<TeachMsgDTO>();
		TeachMsgDTO teachMsgDTO=null;
		while(rs.next()){
			teachMsgDTO=new TeachMsgDTO();
			teachMsgDTO.setId(rs.getString("id"));
			teachMsgDTO.setTeacher(rs.getString("teacher"));
			teachMsgDTO.setTitle(rs.getString("title"));
			teachMsgDTO.setTeachLevelId(new TeachLevelDAOImpl().getTeachLevelDTOByLevelId(conn, rs.getString("teachLevelId")).getTeachLevelName());
			teachMsgDTO.setTeachTypeId(new TeachTypeDAOImpl().getTeachTypeDTOByTypeId(conn, rs.getString("teachTypeId")).getTeachType());
			teachMsgDTO.setPosition(rs.getString("position"));
			teachMsgDTO.setPhone(rs.getString("phone"));
			teachMsgDTO.setAimNumber(rs.getInt("aimNumber"));
			teachMsgDTO.setJoinNumber(rs.getInt("joinNumber"));
			teachMsgDTO.setOpenDate(rs.getString("openDate"));
			teachMsgDTO.setPrice(rs.getInt("price"));
			list.add(teachMsgDTO);
		}
		return list;
	}

	@Override
	public TeachMsgDTO findTeachMsgById(Connection conn, String id) throws SQLException {
		String sql="select * from teachmsg where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs =ps.executeQuery();
		TeachMsgDTO teachMsgDTO=null;
		if(rs.next()){
			teachMsgDTO=new TeachMsgDTO();
			teachMsgDTO.setId(rs.getString("id"));
			teachMsgDTO.setTeacher(rs.getString("teacher"));
			teachMsgDTO.setTitle(rs.getString("title"));
			teachMsgDTO.setTeachLevelId(new TeachLevelDAOImpl().getTeachLevelDTOByLevelId(conn, rs.getString("teachLevelId")).getTeachLevelName());
			teachMsgDTO.setTeachTypeId(new TeachTypeDAOImpl().getTeachTypeDTOByTypeId(conn, rs.getString("teachTypeId")).getTeachType());
			teachMsgDTO.setPosition(rs.getString("position"));
			teachMsgDTO.setPhone(rs.getString("phone"));
			teachMsgDTO.setAimNumber(rs.getInt("aimNumber"));
			teachMsgDTO.setJoinNumber(rs.getInt("joinNumber"));
			teachMsgDTO.setOpenDate(rs.getString("openDate"));
			teachMsgDTO.setPrice(rs.getInt("price"));
		}
		return teachMsgDTO;
	}

	@Override
	public List<TeachMsgDTO> findTeachMsgBySelected(Connection conn, String scopeName, String typeName,
			String levelName) throws SQLException {
		StringBuilder sql=new StringBuilder("select * from teachmsg");
		if(!scopeName.equals("全部")){
			sql.append(" where teachLevelId like '"+new TeachScopeDAOImpl().getAllTeachScopeMsg(conn, scopeName).getId()+"%'");
		}
		if(!typeName.equals("全部")){
			if(sql.indexOf("where")!=-1){
				sql.append(" and teachTypeId='"+new TeachTypeDAOImpl().getTeachTypeDTOByTypeName(conn, typeName).getId()+"'");
			}else{
				sql.append(" where teachTypeId='"+new TeachTypeDAOImpl().getTeachTypeDTOByTypeName(conn, typeName).getId()+"'");
			}
		}
		if(!levelName.equals("全部")){
			if(sql.indexOf("where")!=-1){
				sql.append(" and teachLevelId='"+new TeachLevelDAOImpl().getTeachLevelDTOByLevelName(conn, levelName).getId()+"'");
			}else{
				sql.append(" where teachLevelId='"+new TeachLevelDAOImpl().getTeachLevelDTOByLevelName(conn, levelName).getId()+"'");
			}
		}
		System.out.println("sql语句:"+sql.toString());
		PreparedStatement ps=conn.prepareStatement(sql.toString());
		ResultSet rs=ps.executeQuery();
		List<TeachMsgDTO> list=new ArrayList<TeachMsgDTO>();
		TeachMsgDTO teachMsgDTO=null;
		while(rs.next()){
			teachMsgDTO=new TeachMsgDTO();
			teachMsgDTO.setId(rs.getString("id"));
			teachMsgDTO.setTeacher(rs.getString("teacher"));
			teachMsgDTO.setTitle(rs.getString("title"));
			teachMsgDTO.setTeachLevelId(new TeachLevelDAOImpl().getTeachLevelDTOByLevelId(conn, rs.getString("teachLevelId")).getTeachLevelName());
			teachMsgDTO.setTeachTypeId(new TeachTypeDAOImpl().getTeachTypeDTOByTypeId(conn, rs.getString("teachTypeId")).getTeachType());
			teachMsgDTO.setPosition(rs.getString("position"));
			teachMsgDTO.setPhone(rs.getString("phone"));
			teachMsgDTO.setAimNumber(rs.getInt("aimNumber"));
			teachMsgDTO.setJoinNumber(rs.getInt("joinNumber"));
			teachMsgDTO.setOpenDate(rs.getString("openDate"));
			teachMsgDTO.setPrice(rs.getInt("price"));
			list.add(teachMsgDTO);
		}
		return list;
	}

	@Override
	public boolean deleteTeachMsgById(Connection conn, String id) throws SQLException {
		String sql="delete from teachmsg where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		int i=ps.executeUpdate();
		if(i==1){
			conn.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTeachJoinNumberMsgById(Connection conn, String id) throws SQLException {
		String sql="update teachmsg set joinNumber=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, DAOFactory.getTeachMsgDAO().findTeachMsgById(conn, id).getJoinNumber()+1);
		ps.setString(2, id);
		int i=ps.executeUpdate();
		if(i==1){
			conn.commit();
			return true;
		}
		return false;
	}


}
