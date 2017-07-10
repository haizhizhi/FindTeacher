<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培训班信息查询</title>
<script type="text/javascript"
	src="js/jquery-2.1.0.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="css/owncss/main.css" />
<link type="text/css" rel="stylesheet"
	href="css/owncss/main2.css" />
<style type="text/css">
a {
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="commonHeader.jsp" %>
	<div class="nab-bg">
		<div id="nav" class="pc_main_box">
			<ul>
				<li class="first">教师管理中心</li>
				<li><a href="addTeachMsg.jsp">开设培训班</a></li>
				<li><a href="checkTeachMsg.jsp"><font color="#179e16">培训班查询</font></a></li>
				<li><a href="userCenter_T.jsp">个人中心</a></li>
				<li class="first" style="margin:-38px 799px; width:100px;">${sessionScope.userMsg.nickName}</li>
				<li class="first" style="margin:-38px 890px; width:100px;"><a href="logoutAction">安全退出</a></li>
			</ul>
		</div>
	</div>
	<br>
	<div style="width:990px;margin:0px 175px;height:230px;border:solid gray 1px;">
		<div style="background-color:yellow;height:30px;border-bottom:solid gray 1px;line-height:30px;">
			&nbsp;&nbsp;&nbsp;&nbsp;查询信息列表
		</div>
		<br>
		<div style="margin: 0px 20px 0px 20px;">
			<form>
				<div style="0px 30px;">
					发布日期：<input type="date" id="releaseDateScope1">~<input type="date" id="releaseDateScope2">
					&nbsp;&nbsp;&nbsp;&nbsp;开班日期：<input type="date" id="openDateScope1">~<input type="date" id="openDateScope2">
				</div>
				<br>
				<div>
					授课范围： <input type="radio" name="classScope" value="X"
						class="teachScope"><font>小学</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
						name="classScope" value="C" class="teachScope"><font>初中</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="classScope" value="G" class="teachScope"><font>高中</font>
				</div>
				<br>
				<div>
					授课年级： <select style="width:10%;" class="selectLJ">
						<option selected="selected" class="levelSelect">---请选择---</option>
						<option class="levelScope">一年级</option>
						<option class="levelScope">二年级</option>
						<option class="levelScope">三年级</option>
						<option class="levelScope">四年级</option>
						<option class="levelScope">五年级</option>
						<option class="levelScope">六年级</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 授课类型： <select style="width:10%;" class="selectXK">
						<option selected="selected" class="typeSelect">---请选择---</option>
						<option class="typeScope">数学</option>
						<option class="typeScope">英语</option>
						<option class="typeScope">语文</option>
					</select>
				</div>
				<br>
				<div style="text-align: right;">
					<input type="button" value="查询" id="find">
					<input type="submit" value="重置">
				</div>
			</form>
		</div>
	</div>
	<br>
	<div style="width:990px;margin:0px 175px;border:solid gray 1px;">
		<div style="background-color:yellow;height:30px;border-bottom:solid gray 1px;line-height:30px;">
			&nbsp;&nbsp;&nbsp;&nbsp;查询结果列表
		</div>
		<div>
			<form>
				<table border="1px" style="width:100%;" id="table">
					<tr>
						<tr>
						<th>编号</th>
						<th>标题</th>
						<th>老师</th>
						<th>年级</th>
						<th>科目</th>
						<th>地点</th>
						<th>电话</th>
						<th>预人数</th>
						<td>加入人数</td>
						<td>价格</td>
						<th>开班时间</th>
						<th>操作</th>
					</tr>
					
					
				</table>
			</form>
		</div>
	</div>
	<%@include file="commonBottom.jsp" %>
	<script type="text/javascript" src="js/ownjs/jl.js"></script>
	<script type="text/javascript" src="js/ownjs/check.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#releaseDateScope1").change(function(){
				$("#releaseDateScope2").removeAttr("min");
				var releaseDateScope1=$(this).val();
				$("#releaseDateScope2").attr("min",releaseDateScope1);
			});
			$("#releaseDateScope2").change(function(){
				$("#releaseDateScope1").removeAttr("max");
				var releaseDateScope2=$(this).val();
				$("#releaseDateScope1").attr("max",releaseDateScope2);
			});
			
			$("#openDateScope1").change(function(){
				$("#openDateScope2").removeAttr("min");
				var openDateScope1=$(this).val();
				$("#openDateScope2").attr("min",openDateScope1);
			});
			$("#openDateScope2").change(function(){
				$("#openDateScope1").removeAttr("max");
				var openDateScope2=$(this).val();
				$("#openDateScope1").attr("max",openDateScope2);
			});
			
		});
		
	</script>
</body>
</html>