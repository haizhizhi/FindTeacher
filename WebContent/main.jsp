<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>家教网</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript"
	src="js/jquery-2.1.0.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="css/owncss/main.css" />
<link type="text/css" rel="stylesheet"
	href="css/owncss/main2.css" />
<style type="text/css">
	a{
		cursor: pointer;
	}
</style>
</head>


<body>
	<%@include file="commonHeader.jsp" %>
	<div class="nab-bg">
		<div id="nav" class="pc_main_box">
			<ul>
				<li class="first">课程阶段</li>
				<li><a href="main.jsp">首页</a></li>
				<li><a href="showTeachMsg.jsp">培训信息中心</a></li>
				<li><a href="talk.jsp">论坛中心</a></li>
				<li><a id="userCenter">个人中心</a></li>
				<li class="first outline" style="margin:-38px 799px; width:200px;display:block;">登录入口</li>
				<li class="first online" style="margin:-38px 799px; width:100px;display: none;">${sessionScope.userMsg.nickName}</li>
				<li class="first online" style="margin:-38px 890px; width:100px;display: none;"><a href="logoutAction">安全退出</a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript"
		src="js/ownjs/slide.js"></script>
	<div id="contentA" class="pc_main_box">
		<div class="left">
			<div class="box boxC" style="height:92px;">
				<h4 style="font-size: 40px;margin:28px 35px;"><a href="showTeachMsg.jsp?scope=X"><img src="images/小学.png" alt=""  style="margin:-35px -85px;width:245px;height:100px;"/></a></h4>
			</div>
			<div class="box boxB" style="height:92px;">
				<h4 style="font-size: 40px;margin:28px 35px;"><a href="showTeachMsg.jsp?scope=C"><img src="images/初中.png" alt=""  style="margin:-35px -85px;width:245px;height:100px;"/></a></h4>
			</div>
			<div class="box boxA" style="height:92px;">
				<h4 style="font-size: 40px;margin:28px 35px;"><a href="showTeachMsg.jsp?scope=G"><img src="images/高中.png" alt=""  style="margin:-35px -85px;width:245px;height:100px;"/></a></h4>
			</div>
		</div>
		
		<div class="center">
			<div id="MDC_FocusImage_2" class="fi07"></div>
			<script type="text/javascript">
				jQuery("#MDC_FocusImage_2")
						.focusImg(
								{
									"speed" : "5000",
									"flag" : "fi07",
									"hoverStop" : true
								},
								[

										{
											"p" : "images/首页.png",
											"l" : "#",
											"t" : "<span></span>"
										},
										{
											"p" : "images/slider_02.jpg",
											"l" : "#",
											"t" : "<span></span>"
										},

										{
											"p" : "images/slider_03.jpg",
											"l" : "#",
											"t" : "<span></span>"
										} ]);
			</script>
		</div>
		
		
		<div class="right outline" style="display:block;">
			<div class="box boxC" style="height:145px;">
				<a href="login.jsp"><img src="images/login.png" alt="登录" title="登录" style="margin:-12px 0px;"/></a>
			</div>
			<div class="box boxB" style="height:145px;">
				<a href="register.jsp"><img src="images/register.png" alt="注册" title="注册" style="margin:-12px 0px;"/></a>
			</div>
		</div>
		
		<div class="right online" style="display:none;">
			<div class="box boxC" style="height:20px;">
				<h4 style="font-size:20px;margin:-8px -20px;color:green;">&nbsp;&nbsp;&nbsp;&nbsp;站点公告</h4>
			</div>
			<div class="box boxB" style="height:270px;">
				<marquee behavior="scroll" direction="up" scrollamount="5" style="height:280px;margin:-10px 0px;">
					<font color="#40c169">欢迎用户访问家教网，家教网是专门为大学生家教提供的免费平台，在这个平台上大学生可以面对面的辅导小学、初中、高中的学生，特别是准备毕业当老师的同学，可以很好的锻炼自己的能力；高中及以下的学生可以提前提前了解大学生活，为自己的未来树立选校目标！</font>
				</marquee>
			</div>
		</div>
		
	</div>
	<%@include file="commonBottom.jsp" %>

</body>
</html>