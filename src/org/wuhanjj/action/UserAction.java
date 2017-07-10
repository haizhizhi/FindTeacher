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

public class UserAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nickName;
	private String password;
	
	
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
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
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
	public void changeUserMsg() throws ClassNotFoundException, SQLException, IOException{
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		UserDTO userDTO=new UserDTO();
		userDTO.setId(Integer.parseInt(id));
		if(nickName!=null){
			userDTO.setNickName(nickName);
		}
		if(password!=null){
			userDTO.setPassword(password);
		}
		UsersService userServer=new UsersService();
		Boolean bol=userServer.changeUserMsg(userDTO);
		if(bol){
			HttpSession session=ServletActionContext.getRequest().getSession(true);
			UserDTO userDTO2=(UserDTO) session.getAttribute("userMsg");
			if(nickName!=null){
				userDTO2.setNickName(nickName);
				PrintWriter out=ServletActionContext.getResponse().getWriter();
				out.write(nickName);
				out.flush();
				out.close();
			}
			if(password!=null){
				userDTO2.setPassword(password);
			}
			session.setAttribute("userMsg", userDTO2);
		}
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
}
