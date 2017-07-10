package org.wuhanjj.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.UserDTO;
import org.wuhanjj.service.UsersService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPassword;
	private String userType;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		UsersService userService=new UsersService();
		UserDTO userDTO=new UserDTO();
		userDTO.setName(userName);
		userDTO.setPassword(userPassword);
		userDTO.setType(userType);
		if(userService.registerUser(userDTO)){
			UserDTO userDTO2=userService.checkLoginMsg(userDTO);
			HttpSession session=ServletActionContext.getRequest().getSession(true);
			session.setAttribute("userMsg", userDTO2);
			if(userType.equals("T")){
				System.out.println("csjl");
				return "success_T";
			}
			return "success_S";
		}
		return INPUT;
	}
}
