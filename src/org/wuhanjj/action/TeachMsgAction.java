package org.wuhanjj.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.TeachMsgDTO;
import org.wuhanjj.service.TeachLevelServer;
import org.wuhanjj.service.TeachMsgServer;
import org.wuhanjj.service.TeachTypeServer;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class TeachMsgAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String teacher;
	private String scope;
	private String level;
	private String type;
	private String position;
	private String phone;
	private String aimNumber;
	private String openDate;
	private String price;
	private String teacherOrTitle;
	private String msg;
	
	private String scopeName;
	private String typeName;
	private String levelName;
	
	/**
	 * @return the scopeName
	 */
	public String getScopeName() {
		return scopeName;
	}

	/**
	 * @param scopeName the scopeName to set
	 */
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 * @return the teacherOrTitle
	 */
	public String getTeacherOrTitle() {
		return teacherOrTitle;
	}

	/**
	 * @param teacherOrTitle the teacherOrTitle to set
	 */
	public void setTeacherOrTitle(String teacherOrTitle) {
		this.teacherOrTitle = teacherOrTitle;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the checkType
	 */

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the aimNumber
	 */
	public String getAimNumber() {
		return aimNumber;
	}

	/**
	 * @param aimNumber the aimNumber to set
	 */
	public void setAimNumber(String aimNumber) {
		this.aimNumber = aimNumber;
	}

	/**
	 * @return the openDate
	 */
	public String getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void insertTeachMsg() throws ClassNotFoundException, SQLException, IOException{
		
		System.out.println("时间："+openDate);
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachMsgDTO teachMsgDTO=new TeachMsgDTO();
		teachMsgDTO.setId(id);
		teachMsgDTO.setTeacher(teacher);
		teachMsgDTO.setTitle(title);
		teachMsgDTO.setPosition(position);
		teachMsgDTO.setTeachTypeId(type);
		teachMsgDTO.setTeachLevelId(level);
		teachMsgDTO.setPhone(phone);
		teachMsgDTO.setAimNumber(Integer.parseInt(aimNumber));
		teachMsgDTO.setJoinNumber(0);
		teachMsgDTO.setOpenDate(openDate);
		teachMsgDTO.setPrice(Integer.parseInt(price));
		TeachMsgServer teachMsgServer=new TeachMsgServer();
		Boolean insertSON= teachMsgServer.insertTeachMsg(teachMsgDTO);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		System.out.println(insertSON.toString());
		out.write(insertSON.toString());
		out.flush();
		out.close();
	}
	
	public void getTeachMsg() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachMsgServer teachMsgServer=new TeachMsgServer();
		List<TeachMsgDTO> list= teachMsgServer.getTeachMsg(scope,teacherOrTitle,msg);
		Gson gson=new Gson();
		String json=gson.toJson(list);
		System.out.println("find："+json);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	public void getOwnTeachMsg() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachMsgServer teachMsgServer=new TeachMsgServer();
		System.out.println("asad%%%"+id);
		List<TeachMsgDTO> list= teachMsgServer.getOwnTeachMsg(Integer.parseInt(id));
		Gson gson=new Gson();
		String json=gson.toJson(list);
		System.out.println("findOwn："+json);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	public void getTeachMsgBySelected() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachMsgServer teachMsgServer=new TeachMsgServer();
		System.out.println(scopeName);
		System.out.println(typeName);
		System.out.println(levelName);
		List<TeachMsgDTO> list=teachMsgServer.getTeachMsgBySelected(scopeName, typeName, levelName);
		Gson gson=new Gson();
		String json=gson.toJson(list);
		System.out.println("find："+json);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	public void deleteTeachMsg() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachMsgServer server=new TeachMsgServer();
		boolean bol=server.deleteTeachMsgById(id);
		if(bol==true){
			PrintWriter out=ServletActionContext.getResponse().getWriter();
			out.write("true");
			out.flush();
			out.close();
		}
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	
	
}
