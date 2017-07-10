<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!--Header-part-->
	<div id="logo-intro" class="pc_main_box">
		<div class="left">
			<div class="logo l" style="margin:-11px -150px;">
				<img src="images/logo.png" width="400px" height="60" alt="家教网"/>
			</div>
			<div class="logo l" style="margin:-90px 770px;">
				<img src="images/logoTitle.png" width="500px" height="100px" alt="家教网"/>
			</div>
		</div>
		<div class="right">
			<div class="l">
				<div class="search_box" style="margin:0px 50px;">
					<form id="searchform" action="" method="post">
					<div class="searchingbar_sub">
						<select style="height:35px;width:80px;padding: 0px 10px;border:0px;">
							<option selected="selected" value="teacher" class="checkType">老师</option>
							<option value="title" class="checkType">课题</option>
						</select>
					</div>
					
						<input type="text" class="search_txt" name="msg" id="searchtxt"
							value="" placeholder="请输入内容....." />
						<input type="submit" value="搜&nbsp;&nbsp;&nbsp;&nbsp;索"
							class="search_btn"  id="submit"/>
					</form>
					<ul id="suggest_ul"></ul>
					<div style='clear: both'></div>
					<div class="hot-rec" style="width: 550px">
						<div style='color: red; float: left'>
							
						</div>
						<div style="float: right">
							
						</div>
					</div>
				</div>
			</div>
			<div id="login_status" class="loginbox"></div>
		</div>
	</div>
	<script>
		$(function(){
			$("#submit").click(function(){
				$("#searchform").attr("action","showTeachMsg.jsp?teacherOrTitle="+$(".checkType:checked").val()+"&&msg="+$("#searchtxt").val());
			});
		});
	</script>