package org.wuhanjj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.JoinTeachDTO;
import org.wuhanjj.DTO.SaveTeachDTO;
import org.wuhanjj.service.JoinTeachServer;
import org.wuhanjj.service.SaveTeachServer;
import org.wuhanjj.service.TeachMsgServer;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class SaveTeachAction  extends ActionSupport {

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
	public void getSaveTeachMsg() throws NumberFormatException, ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		SaveTeachServer saveServer=new SaveTeachServer();
		List<SaveTeachDTO> list=saveServer.getSaveMsg(Integer.parseInt(id));
		TeachMsgServer teachMsgServer=new TeachMsgServer();
		List list2=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			String msgId= list.get(i).getTeachMsgId();
			list2.add(teachMsgServer.getSaveTeachMsg(msgId));
		}
		Gson gson=new Gson();
		String json=gson.toJson(list2);
		System.out.println("join:"+json);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
	
	public void saveTeach() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		SaveTeachServer saveServer=new SaveTeachServer();
		SaveTeachDTO dto=new SaveTeachDTO();
		dto.setUserId(Integer.parseInt(id));
		dto.setTeachMsgId(teachMsgId);
		boolean b=saveServer.insertSaveMsg(dto);
		if(b){
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
