package org.wuhanjj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.TeachLevelDTO;
import org.wuhanjj.DTO.TeachScopeDTO;
import org.wuhanjj.service.TeachLevelServer;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class TeachLevelAction extends ActionSupport{
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
	
	public void getTeachLevel() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		TeachScopeDTO scope=new TeachScopeDTO();
		System.out.println(classScope);
		scope.setId(classScope);
		TeachLevelServer server=new TeachLevelServer();
		List<TeachLevelDTO> list=server.getLevelAllMsgByScope(scope);
		Gson gson=new Gson();
		String json =gson.toJson(list);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		System.out.println(json);
		out.write(json);
		out.flush();
		out.close();
	}
}
