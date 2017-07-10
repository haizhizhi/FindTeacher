<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="js/jquery-2.1.0.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="css/owncss/main.css" />
<link type="text/css" rel="stylesheet"
	href="css/owncss/main2.css" />
<title>论坛中心</title>
</head>
<body>
	<%@include file="commonHeader.jsp" %>
	<div class="nab-bg">
		<div id="nav" class="pc_main_box">
			<ul>
				<li class="first">个人信息列表</li>
				<li><a href="main.jsp">首页</a></li>
				<li><a href="showTeachMsg.jsp">培训信息中心</a></li>
				<li><a href="talk.jsp"><font color="#179e16">论坛中心</font></a></li>
				<li><a href="userCenter_S.jsp" id="userCenter">个人中心</a></li>
				<li class="first userLogin" style="margin:-38px 799px; width:100px;">${sessionScope.userMsg.nickName}</li>
				<li class="first userLogin" style="margin:-38px 890px; width:100px;"><a href="logoutAction">安全退出</a></li>
			</ul>
		</div>
	</div>
	<div style="width:990px;height:40px;background-color:#e8eff5;margin:0px 175px;">
		<form>
			<input type="text" placeholder="请输入搜索内容" style="width:500px;height:25px;margin:6px 20px;">
			<input type="submit" value="搜索">
		</form>
		<div style="margin:-22px 600px;width:400px;font:12px；">
			今日：<em>XX</em> | 昨日：<em>XX</em> | 贴子：<em>XX</em>  | 欢迎用户：<em>XX</em>
		</div>
	</div>
	<br>
	<!--学生交流专区-->
	<div class="openOrClose" style="width:990px;margin:0px 175px;background-color:yellow;height:30px;border:solid gray 1px;line-height:30px;cursor: pointer;">
			&nbsp;&nbsp;&nbsp;&nbsp;学生交流专区
	</div>
	<div class="item" style="border:solid gray 1px;border-top:0px; width:990px;height:200px;margin:0px 175px;">
		XXXXXX
	</div>
	<br>
	
	<!--老师交流专区-->
	<div class="openOrClose" style="width:990px;margin:0px 175px;background-color:yellow;height:30px;border:solid gray 1px;line-height:30px;cursor: pointer;">
			&nbsp;&nbsp;&nbsp;&nbsp;老师交流专区
	</div>
	<div class="item" style="border:solid gray 1px;border-top:0px; width:990px;height:200px;margin:0px 175px;">
		XXXXXX
	</div>
	<br>
	
	<!--家长交流专区-->
	<div class="openOrClose" style="width:990px;margin:0px 175px;background-color:yellow;height:30px;border:solid gray 1px;line-height:30px;cursor: pointer;">
			&nbsp;&nbsp;&nbsp;&nbsp;家长交流专区
	</div>
	<div class="item" style="border:solid gray 1px;border-top:0px; width:990px;height:200px;margin:0px 175px;">
		XXXXXX
	</div>
	<%@include file="commonBottom.jsp" %>
	<script type="text/javascript">
		$(function(){
			$(".openOrClose").click(function(){
				$(this).next().slideToggle();
			});
		});
	</script>
</body>
</html>