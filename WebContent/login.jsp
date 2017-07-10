<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<div style="height:100px;">
	<div class="span8" style="height:100px;"><img src="images/logo.png"/></div>
	<div class="span8" style="height:100px;"><img src="images/logoTitle.png"/></div>
	</div>
	<hr>
	
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" action="login">
				<div style="margin:0px 160px;color: red;">${sessionScope.msg}</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
					<div class="col-md-5">
						<input type="text"  name="userName" id="userName" />
					</div>
				</div>
				<br>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"  id="passWord"/>
					</div>
				</div>
				<br>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">登录类型：</label>
					<div class="col-sm-10">
						<input type="radio" name="userType" checked="checked" value="T"/>教师
						<input type="radio" name="userType" value="S"/>学生
					</div>
				</div>
				<br>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button id="submit" type="submit" class="btn btn-primary btn-lg" style="width:220px;height:42px;margin:0px 160px;">登录</button>
						<label><ins><a href="register.jsp" style="color:red;">注册帐号>></a></ins></label>
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	<div class="footer" style="text-align:center;height:20px;">
			Copyright © 2010-2017 武汉家教帮科技股份有限公司 &nbsp;
			<a href="http://www.wuhanjj.com/" target="_blank" rel="nofollow" style="color:#aaa;">鄂ICP备10235580号</a>&nbsp;
			股票代码：666666&nbsp; 
</div>
	<script src="js/jquery-2.1.0.min.js "></script>
	<script src="js/ownjs/login.js"></script>
</body>
</html>