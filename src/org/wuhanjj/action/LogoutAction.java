package org.wuhanjj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.UserDTO;
import org.wuhanjj.service.UsersService;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return SUCCESS;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
}
