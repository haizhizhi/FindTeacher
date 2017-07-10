<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
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
			<form class="form-horizontal" role="form" action="register">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userName"  name="userName" placeholder="请输入用户名"/>
					</div>
				</div>
				<br>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password1" name="userPassword" placeholder="请输入密码"/>
					</div>
				</div>
				<br>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">确认密码：</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password2" placeholder="请确认密码"/>
					</div>
				</div>
				<br>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">注册类型：</label>
					<div class="col-sm-10">
						<input type="radio" name="userType" checked="checked" value="T"/>教师
						<input type="radio" name="userType" value="S"/>学生
					</div>
				</div>
				<br>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-lg register" style="width:220px;height:42px;margin:0px 160px;">免费注册</button>
						 <label><ins><a href="login.jsp" style="color:red;">已有帐号，返回登录界面>>></a></ins></label>
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
	<script>
		$(function(){
			$(".register").click(function(){
				var userName=$("#userName").val();
				var password1=$("#password1").val();
				var password2=$("#password2").val();
				if(userName==""){
					$("#userName").css("border-color","red");
					$("#userName").attr("placeholder","用户名不能为空！！");
					return false;
				}
				if(password1==""){
					$("#password1").css("border-color","red");
					$("#password1").attr("placeholder","密码不能为空！！");
					return false;
				}
				if(password2==""){
					$("#password2").css("border-color","red");
					$("#password2").attr("placeholder","请确认密码！！");
					return false;
				}
				if(password1!=password2){
					$("#password1").css("border-color","red");
					$("#password1").focus();
					$("#password1").val("");
					$("#password1").attr("placeholder","请重新输入密码");
					$("#password2").attr("placeholder","两次密码不正确");
					$("#password2").val("");
					return false;
				}
			});
		});
	
	</script>
</body>
</html>