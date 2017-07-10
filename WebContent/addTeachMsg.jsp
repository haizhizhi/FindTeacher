<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布培训班</title>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<script type="text/javascript" src="js/jquerySession.js"></script>
<link type="text/css" rel="stylesheet" href="css/reveal.css" />
<link type="text/css" rel="stylesheet" href="css/owncss/main.css" />
<link type="text/css" rel="stylesheet" href="css/owncss/main2.css" />
<style type="text/css">
a {
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="commonHeader.jsp"%>
	<div class="nab-bg">
		<div id="nav" class="pc_main_box">
			<ul>
				<li class="first">教师管理中心</li>
				<li><a href="addTeachMsg.jsp"><font color="#179e16">开设培训班</font></a></li>
				<li><a href="checkTeachMsg.jsp">培训班查询</a></li>
				<li><a href="userCenter_T.jsp">个人中心</a></li>
				<li class="first" style="margin: -38px 799px; width: 100px;">${sessionScope.userMsg.nickName}</li>
				<li class="first" style="margin: -38px 890px; width: 100px;"><a href="logoutAction">安全退出</a></li>
			</ul>
		</div>
	</div>
	<br>
	<div
		style="width: 990px; margin: 0px 182px; height: 230px; border: solid gray 1px;">
		<div
			style="background-color: yellow; height: 30px; border-bottom: solid gray 1px; line-height: 30px;">
			&nbsp;&nbsp;&nbsp;&nbsp;添加培训信息</div>
		<br>
		<div style="margin: 0px 20px 0px 20px;">
			<form>
				<div >
						标题：<input type="text"
						id="title" style="width:400px;" > 老师：<input type="text" id="teacher" placeholder="">
				</div>
				<br>
				<div>
					授课范围： <input type="radio" name="classScope" value="X"
						class="teachScope" checked="checked"><font>小学</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
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
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格：<input type="number" min="0" max="9999" id="price" >/人
				</div>
				<br>
				<div>
					地点：<input type="text" id="position" style="width:250px;" placeholder=""> &nbsp;&nbsp;&nbsp;&nbsp;电话：<input type="text"
						id="phone" style="width:100px;" placeholder="">&nbsp;&nbsp;&nbsp;&nbsp; 预开班人数：<input type="number" min="0" max="9999" style="width: 40px;"
						id="aimNumber">人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 开班时间：<input type="date" class="openDate" style="width:190px;" min="">
				</div>
				<br>
				<div style="text-align: right;margin:-8px 0px;">
					<input type="button" value="添加" id="addTeach"> <input
						type="reset" value="重置" id="reset">
				</div>
			</form>
		</div>
	</div>
	<br>
	<div
		style="width: 990px; margin: 0px 182px;border: solid gray 1px;">
		<div
			style="background-color: yellow; height: 30px; border-bottom: solid gray 1px; line-height: 30px;">
			&nbsp;&nbsp;&nbsp;&nbsp;培训信息列表
			</div>
		<div>
			<form action="" method="post">
				<table border="1px" style="width: 100%;" id="table">
					<tr>
						<th>&nbsp;</th>
						<th>编号</th>
						<th>标题</th>
						<th>老师</th>
						<th>范围</th>
						<th>年级</th>
						<th>科目</th>
						<th>地点</th>
						<th>电话</th>
						<th>预人数</th>
						<th>价格</th>
						<th>开班时间</th>
						<th>操作</th>
					</tr>

				</table>
				<div style="text-align: right;margin: 0px 20px;position:inherit;">
					<input type="button" value="发布" id="release"> <input type="button"
						id="checkALL" value="全选"> <input type="button"
						id="NoCheck" value="全不选"> <input type="button" id="delete"
						value="删除">
				</div>
			</form>
		</div>

	</div>
	<div id="myModal" class="reveal-modal"
		style="height: 300px; width: 30%; top: 50px; opacity: 1; visibility: hidden;">

		<div style="background-color: yellow; height: 31px;">
			修改发布信息<a class="close-reveal-modal out">×</a>
		</div>
		<div>
			标题：<input id="teachTitle" type="text" >
		</div>
		<div>
			老师：<input id="teacher2" type="text">
		</div>
		<div>
			授课范围： <input class="teachScope2" type="radio" name="classScope"
				value="X"><font>小学</font> <input class="teachScope2"
				type="radio" name="classScope" value="C"><font>初中</font> <input
				class="teachScope2" type="radio" name="classScope" value="G"><font>高中</font>
		</div>
		<div>
			授课年级： <select>
				<option selected="selected" class="levelSelect2">---请选择---</option>
						<option class="levelScope2">一年级</option>
						<option class="levelScope2">二年级</option>
						<option class="levelScope2">三年级</option>
						<option class="levelScope2">四年级</option>
						<option class="levelScope2">五年级</option>
						<option class="levelScope2">六年级</option>
			</select>
		</div>
		
		<div>
			授课类型： <select>
				<option selected="selected" class="typeSelect2">---请选择---</option>
						<option class="typeScope2">数学</option>
						<option class="typeScope2">英语</option>
						<option class="typeScope2">语文</option>
			</select>
		</div>
		<div>价格：<input type="number" min="0" max="9999">/人</div>
		<div>
			地点：<input type="text" id="teachPosition">
		</div>
		<div>
			电话：<input type="text" id="teachPhone">
		</div>
		<div>
			预开班人数：<input type="number" style="width: 40px;" id="teachNumber" min="0" max="9999">人
		</div>
		 开班时间：<input type="date" class="openDate" style="width:190px;" min="" id="openDate">
		<div>
			<input id="save" class="out" type="button" value="保存"> <input
				id="out" class="out" type="button" value="退出">
		</div>

	</div>
	
	<%@include file="commonBottom.jsp"%>
	
	<script type="text/javascript" src="js/ownjs/jl.js"></script>
	<script type="text/javascript" src="js/ownjs/add.js"></script>
</body>
</html>