package org.wuhanjj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;
import org.wuhanjj.DTO.TeachTypeDTO;
import org.wuhanjj.service.TeachTypeServer;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class TeachTypeAction extends ActionSupport{
	private String classScope;
	
	/**
	 * @return the classScope
	 */
	public String getClassScope() {
		return classScope;
	}

	/**
	 * @param classScope the classScope to set
	 */
	public void setClassScope(String classScope) {
		this.classScope = classScope;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void getTeachType() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachScopeDTO scope=new TeachScopeDTO();
		System.out.println(classScope);
		scope.setId(classScope);
		TeachTypeServer server=new TeachTypeServer();
		List<TeachTypeDTO> list=server.getTypeAllMsgByScope(scope);
		Gson gson=new Gson();
		String json =gson.toJson(list);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		System.out.println(json);
		out.write(json);
		out.flush();
		out.close();
	}
}
