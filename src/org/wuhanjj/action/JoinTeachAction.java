package org.wuhanjj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.JoinTeachDTO;
import org.wuhanjj.service.JoinTeachServer;
import org.wuhanjj.service.TeachMsgServer;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class JoinTeachAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String teachMsgId;
	
	private String id;
	
	
	/**
	 * @return the teachMsgId
	 */
	public String getTeachMsgId() {
		return teachMsgId;
	}
	/**
	 * @param teachMsgId the teachMsgId to set
	 */
	public void setTeachMsgId(String teachMsgId) {
		this.teachMsgId = teachMsgId;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void getJoinTeachMsg() throws NumberFormatException, ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		JoinTeachServer joinServer=new JoinTeachServer();
		List<JoinTeachDTO> list=joinServer.getJoinMsg(Integer.parseInt(id));
		TeachMsgServer teachMsgServer=new TeachMsgServer();
		List list2=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			String msgId= list.get(i).getTeachMsgId();
			list2.add(teachMsgServer.getJoinTeachMsg(msgId));
		}
		Gson gson=new Gson();
		String json=gson.toJson(list2);
		System.out.println("join:"+json);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	public void joinTeach() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		JoinTeachServer joinServer=new JoinTeachServer();
		JoinTeachDTO dto=new JoinTeachDTO();
		dto.setUserId(Integer.parseInt(id));
		dto.setTeachMsgId(teachMsgId);
		boolean b=joinServer.insertJoinMsg(dto);
		TeachMsgServer server=new TeachMsgServer();
		boolean bol=server.updateTeachMsg(teachMsgId);
		if(b&&bol){
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
