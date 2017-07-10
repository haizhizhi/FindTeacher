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
<title>个人中心</title>
</head>
<body>
	<%@include file="commonHeader.jsp" %>
	<div class="nab-bg">
		<div id="nav" class="pc_main_box">
			<ul>
				<li class="first">教师管理中心</li>
				<li><a href="addTeachMsg.jsp">开设培训班</a></li>
				<li><a href="checkTeachMsg.jsp">培训班查询</a></li>
				<li><a href="userCenter_T.jsp"><font color="#179e16">个人中心</font></a></li>
				<li class="first" style="margin:-38px 799px; width:100px;" id="topNickName">${sessionScope.userMsg.nickName}</li>
				<li class="first" style="margin:-38px 890px; width:100px;"><a href="logoutAction" >安全退出</a></li>
			</ul>
		</div>
	</div>
	
	<div id="contentA" class="pc_main_box">
		<div class="left">
			<div class="box" style="height:50px;cursor: pointer;" title="首页" >
				<h4 style="font-size: 25px;margin:10px 35px;">首页</h4>
			</div>
			<div class="box" style="height:50px;cursor: pointer;" title="个人信息">
				<h4 style="font-size: 25px;margin:10px 35px;">个人信息</h4>
			</div>
			<div class="box" style="height:50px;cursor: pointer;" title="培训班">
				<h4 style="font-size: 25px;margin:10px 35px;" id="teachMsg">培训班</h4>
			</div>
		
			<div class="box" style="height:50px;cursor: pointer;" title="消息">
				<h4 style="font-size: 25px;margin:10px 35px;">消息</h4>
			</div>
		</div>
		
		<!--首页-->
		<div class="center" style="display:none;width:730px;">
			<label style="display:none;" class="rightID">首页</label>
				敬请期待！！！！！
			
		</div>
		
		<!--个人信息-->
		<div class="center" style="display:block;width:730px;">
			<label style="display:none;" class="rightID">个人信息</label>
			<div>
				<table style="border:solid red 0px;width:530px;height:300px;">
					<tr>
						<th>昵称：</th>
						<td style="text-align: center;"><input id="nickName" type="text" disabled="disabled" value="${sessionScope.userMsg.nickName}" style="background-color: transparent;border: 0px;text-align: center;"></td>
						<td><button class="changeNickName" href="#">修改</button></td>
					<tr>
					<tr >
						<th >用户名：</th>
						<td style="text-align: center;"><label>${sessionScope.userMsg.name}</label></td>
						<td></td>
					<tr>
					<tr>
						<th>密码：</th>
						<td style="text-align: center;"><input id="password" type="text" disabled="disabled" value="${sessionScope.userMsg.password}" style="background-color: transparent;border: 0px;text-align: center;"></td>
						<td><button class="changePassword">修改</button></td>
					<tr>
				</table>
			</div>
		</div>
		<!--培训班-->
		<div class="center" style="display: none;width:730px;" >
			<label style="display:none;" class="rightID" id="findTeach">培训班</label>
			<div id="ownTeachMsg">
				
		
			</div>
		</div>
		
		<div class="center" style="display:none;width:730px;">
			<label style="display:none;" class="rightID">消息</label>
				敬请期待！！！！！
			
		</div>
	</div>
	<%@include file="commonBottom.jsp" %>
	<script type="text/javascript">
		$(function(){
			$(".box").click(function(){
				$(".center").css("display","none");
				$(".box").children().css("color","#49B3C8");
				$(this).children().css("color","red");
				var rightIdArray =$(".rightID");
				for(var i=0;i<rightIdArray.length;i++){
					if(rightIdArray[i].innerHTML==$(this).attr("title")){
						rightIdArray[i].parentNode.style.display="block";
						return;
					}
				}
				
			});
		});
	</script>
	<script type="text/javascript" src="js/ownjs/userCenter.js"></script>
	<script type="text/javascript" src="js/ownjs/ownTeachMsg.js"></script>
</body>
</html>