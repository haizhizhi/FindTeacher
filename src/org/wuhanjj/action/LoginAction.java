package org.wuhanjj.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.wuhanjj.DTO.UserDTO;
import org.wuhanjj.service.UsersService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String userType;
	//private UserDTO userMsg;
	HttpSession session;
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
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		UserDTO userDTO=new UserDTO();
		userDTO.setName(userName);
		userDTO.setPassword(password);
		userDTO.setType(userType);
		UsersService userService=new UsersService();
		UserDTO userDTO1=userService.checkLoginMsg(userDTO);
		if(userDTO1==null){
			session = ServletActionContext.getRequest().getSession(true);
			// 登录页面登录错误返回页面，并传递msg错误提示信息
			session.setAttribute("msg", "用户名或密码不正确！！！");
			return INPUT;
		}
		session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("userMsg",userDTO1);
		if(userType.equals("T")){
			session.setAttribute("line", "0");
			return "success_T";
		}else{
			return "success_S";
		}
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
}
