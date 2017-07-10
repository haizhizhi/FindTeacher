package org.wuhanjj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class SiteFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 对用户的请求进行拦截
	 * @param req	非http请求
	 * @param resp  非http响应
	 * @param chain  过滤器链对象 
	 * @throws IOException 读取异常
	 * @throws ServletException servlet异常
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//转换request和response成http请求
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//获取请求的URL
		StringBuffer strb=request.getRequestURL();
		//将strb转化成String
		String str=strb.toString();
		//获取session中user的值
		HttpSession session=request.getSession();
		String sessionValue=(String) session.getAttribute("userName");
		//获取请求中state的值
		String stateValue=request.getParameter("state");
		//判断request.getParameter("state")是否为空，如果为空，改变stateValue的值，从而避免下面比较空指针异常
		if(stateValue==null){
			stateValue="in";
		}
		//对CSS，js，图片等请求进行直接放行，防止样式或js丢失
		if(str.endsWith(".css")||str.endsWith(".png")||str.endsWith(".js")||str.endsWith(".jpg")||str.endsWith(".json")){
			chain.doFilter(req, resp);
		}
		//注销时，消除session
		else if(sessionValue!=null&&stateValue.equals("out")){
			response.sendRedirect("main.jsp");
			request.getSession().invalidate();
		}
		//登录用户直接在地址栏访问登录页面
		else if(sessionValue!=null&&str.endsWith("login.jsp")){
			response.sendRedirect("main.jsp");
		}
		//登录用户直接在地址栏访问登录页面
		else if(sessionValue!=null&&str.endsWith("register.jsp")){
			response.sendRedirect("main.jsp");
		}
		//登录成功后，除了登录和注册页面，其他都放行 
		else if(sessionValue!=null){
			chain.doFilter(req, resp);
		}
		else if(str.endsWith("login.jsp")){
			//先放行,因为登录页面要获取session中的错误信息
			chain.doFilter(req, resp);
			//再消除session，防止下次刷新显示错误信息
			request.getSession().invalidate();
		}
		//不满足上述条件直接重定向main.jsp
		else{
			response.sendRedirect("main.jsp");
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
