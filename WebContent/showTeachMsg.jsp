<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培训班信息中心</title>
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
				<li class="first">个人信息列表</li>
				<li><a href="main.jsp">首页</a></li>
				<li><a href="showTeachMsg.jsp"><font color="#179e16">培训信息中心</font></a></li>
				<li><a href="talk.jsp">论坛中心</a></li>
				<li><a href="userCenter_S.jsp" id="userCenter">个人中心</a></li>
				<li class="first userLogin" style="margin:-38px 799px; width:100px;">${sessionScope.userMsg.nickName}</li>
				<li class="first userLogin" style="margin:-38px 890px; width:100px;"><a href="logoutAction">安全退出</a></li>
			</ul>
		</div>
	</div>
	<br>
	<div style="width:990px;margin:0px 175px;line-height:30px;">
		<div>
			<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;范围：</strong><a class="scope checked find" id="allScope"><font color="red">全部</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="scope find" id="XXScope"><font>小学</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="scope find" id="CZScope"><font>初中</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="scope find" id="GZScope"><font>高中</font></a>
			<br>
			<hr Style="border:solid #CFD5D8 1px;">
		</div>
		
		<br>
		
		<!--全部-->
		<div style="display：block;" id="showAll" class="showScope">
			<div>
				<div style="float:left;">
				<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学科：</strong>
				<a class="type allType find"><font color="red">全部</font></a>
				</div>
				<div style="float:left;" id="XXType" class="main mainType ">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type find"><font>语文</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type find"><font>英语</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type find"><font>数学</font></a>
				</div>
				<div style="float:left;" class="main mainType">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type Mtype find"><font>物理</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type Mtype find"><font>化学</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type Mtype find"><font>生物</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type Mtype find"><font>地理</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type Mtype find"><font>政治</font></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="type Mtype find"><font>历史</font></a>
				</div>
				<br>
				<hr Style="border:solid #CFD5D8 1px;">
				<br>
			</div>
			
			<div>
				<div style="float:left;">
					<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年级：</strong>
					<a class="level find" id="allLevel"><font color="red">全部</font></a>
				</div>
				<div style="float:left;" id="XXLevel" class="main">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>一年级</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>二年级</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>三年级</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>四年级</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>五年级</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>六年级</font></a>
			</div>
			<div style="float:left;" id="CZLevel" class="main">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>初一</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>初二</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>初三</font></a>
			</div>
			<div style="float:left;" id="GZLevel" class="main">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>高一</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>高二</font></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="level find"><font>高三</font></a>
			</div>
			<br>
			<hr Style="border:solid #CFD5D8 1px;">
			</div>
			
		</div>
	</div>
	<br>
	<div style="width:990px;margin:0px 175px;height:750px;background-color: #f3f5f7;">
		<div id="boxTop">
			<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a>最新</a>&nbsp;&nbsp;&nbsp;<a>最热</a>
			<br>
		</div>
		<br>
		<div style="height:200px;" >
			<diV id="item1" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item2" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item3" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item4" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
		</div>
		<br>
		<div style="height:200px;">
			<diV id="item5" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item6" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item7" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item8" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
		</div>	
		<br>
		<div style="height:200px;">
			<diV id="item9" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item10" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item11" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
			<diV id="item12" class="item" style="float: left;width:22%;height:200px;border:solid red 1px;border-radius:5px;margin:0px 5px 0px 20px;background-color: #ffffff;">
				
			</div>
		</div>	
		<br>
		<div style="text-align: center;">
			<a>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>1</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>2</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>3</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>4</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a>尾页</a>
		</div>
	</div>	
	<input type="hidden"   value="${param.scope}" id="scopeHidden">
	<input type="hidden"   value="${param.teacherOrTitle}" id="teacherOrTitle">
	<input type="hidden"   value="${param.msg}" id="msg">
	<%@include file="commonBottom.jsp" %>
	
	<script type="text/javascript">
		
		$(function(){
			$(".item").css("display","none");
			
			if($("#scopeHidden").val()=="X"){
				$(".scope").children().first().removeAttr("color");
				$("#XXScope").children().first().attr("color","red");
			}

			if($("#scopeHidden").val()=="C"){
				$(".scope").children().first().removeAttr("color");
				$("#CZScope").children().first().attr("color","red");
			}

			if($("#scopeHidden").val()=="G"){
				$(".scope").children().first().removeAttr("color");
				$("#GZScope").children().first().attr("color","red");
			}
			$.ajax({
				type:"GET",
				url:"getTeachMsgAction?scope="+$("#scopeHidden").val()+"&&teacherOrTitle="+$("#teacherOrTitle").val()+"&&msg="+$("#msg").val(),
				dataType:"json",
				success:function(data){
					$(".item").children().remove();
					$(".item").css("display","none");
					for(var i=0;i<data.length;i++){
						$("#item"+(i+1)).css("display","block");
						$("#item"+(i+1)).append("<diV style='height:48px;background:linear-gradient(270deg,rgba(210,115,230,.7),#c872da);border-radius:5px 5px 0px 0px;line-height: 48px;'>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].teachLevelId+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].teachTypeId+
						"</div>"+
						"<div style='margin:0px 10px 0px 10px;'>"+
							"<strong>"+data[i].title+"</strong>"+
							"<br>"+
							"<span>开班时间："+data[i].openDate+"</span>"+
							"<p>地点："+data[i].position+"</p>"+
							"<span>"+data[i].teacher+"老师·"+data[i].joinNumber+"人以参加 &nbsp;&nbsp;"+data[i].price+"元/人</span>"+
							"<br>"+
							"<button style='background-color: #389ece;' ><a class='join' title='joinTeachAction?id="+$("#idMsg").val()+"&&teachMsgId="+data[i].id+"'>报名</a></button>"+
						"</div>");
					}
					if($("#idMsg").val()==""){
						$(".join").attr("href","login.jsp");
						$(".save").attr("href","login.jsp");
					}
					
					$(".join").click(function(){
						$.ajax({
							type:"GET",
							url:$(this).attr("title"),
							dataType:"text",
							success:function(data){
								if(data=="true"){
									alert("报名成功！！");
									window.location.reload();
								}else{
									alert("报名失败！！！");
								}
							},
							error:function(){
								alert("服务器请求异常！！！");
							}
						});
					});
					
					$(".save").click(function(){
						
						$.ajax({
							type:"GET",
							url:$(this).attr("title"),
							dataType:"text",
							success:function(data){
								if(data=="true"){
									alert("收藏成功！！");
									window.location.reload();
								}else{
									alert("收藏失败！！！");
								}
								
							},
							error:function(){
								alert("服务器请求异常！！！");
							}
						});
					});
					
				},
				error:function(){
					alert("服务器请求异常！！！");
				}
			});
			
			$(".scope").click(function(){
				$(".main").css("display","none");
				var idName=$(this).attr("id");
				if(idName=="allScope"){
					$(".main").css("display","block");
				}
				if(idName=="XXScope"){
					var mTypeArray=$(".Mtype");
					 for(var i=0;i<mTypeArray.length;i++){
						if($(".Mtype").eq(i).children().first().attr("color")=="red"){
							var typeArray=$(".type");
							
							for(var i=0;i<typeArray.length;i++){
								$(".type").eq(i).children().first().removeAttr("color");
							}
							$(".allType").children().first().attr("color","red");
							break;
						}
					}
					 
					$("#XXType").css("display","block");
					$("#XXLevel").css("display","block");
					var levelArray=$(".level");
					
					for(var i=0;i<levelArray.length;i++){
						$(".level").eq(i).children().first().removeAttr("color");
					}
					$("#allLevel").children().first().attr("color","red");
				}
				if(idName=="CZScope"){
					$(".mainType").css("display","block");
					$("#CZLevel").css("display","block");
					var levelArray=$(".level");
					
					for(var i=0;i<levelArray.length;i++){
						$(".level").eq(i).children().first().removeAttr("color");
					}
					$("#allLevel").children().first().attr("color","red");
				}
				if(idName=="GZScope"){
					$(".mainType").css("display","block");
					$("#GZLevel").css("display","block");
					var levelArray=$(".level");
					
					for(var i=0;i<levelArray.length;i++){
						$(".level").eq(i).children().first().removeAttr("color");
					}
					$("#allLevel").children().first().attr("color","red");
					
				}
			});
			
			$(".scope").click(function(){
				var scopeArray=$(".scope");
				
				for(var i=0;i<scopeArray.length;i++){
					$(".scope").eq(i).children().first().removeAttr("color");
				}
				$(this).children().first().attr("color","red");
			});
			
			$(".type").click(function(){
				var typeArray=$(".type");
				
				for(var i=0;i<typeArray.length;i++){
					$(".type").eq(i).children().first().removeAttr("color");
				}
				$(this).children().first().attr("color","red");
			});
			
			$(".level").click(function(){
				var levelArray=$(".level");
				
				for(var i=0;i<levelArray.length;i++){
					$(".level").eq(i).children().first().removeAttr("color");
				}
				$(this).children().first().attr("color","red");
			});
			
			
			$(".find").click(function(){
				var val=[];
				var findArray=$(".find");
				for(var i=0;i<findArray.length;i++){
					var text=$(".find").eq(i).children().first().text();
					var state=$(".find").eq(i).children().first().attr("color");
					if(state=="red"){
						val.push(text);
					}
				
				}
				$.ajax({
					type:"GET",
					url:"getTeachMsgBySelectedAction?scopeName="+val[0]+"&&typeName="+val[1]+"&&levelName="+val[2],
					dataType:"json",
					success:function(data){
						$(".item").children().remove();
						$(".item").css("display","none");
						for(var i=0;i<data.length;i++){
							$("#item"+(i+1)).css("display","block");
							$("#item"+(i+1)).append("<diV style='height:48px;background:linear-gradient(270deg,rgba(210,115,230,.7),#c872da);border-radius:5px 5px 0px 0px;line-height: 48px;'>"+
							"&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].teachLevelId+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].teachTypeId+
							"</div>"+
							"<div style='margin:0px 10px 0px 10px;'>"+
								"<strong>"+data[i].title+"</strong>"+
								"<br>"+
								"<span>开班时间："+data[i].openDate+"</span>"+
								"<p>地点："+data[i].position+"</p>"+
								"<span>"+data[i].teacher+"老师·"+data[i].joinNumber+"人以参加 &nbsp;&nbsp;"+data[i].price+"元/人</span>"+
								"<br>"+
								"<button style='background-color: #389ece;' ><a class='join' title='joinTeachAction?id="+$("#idMsg").val()+"&&teachMsgId="+data[i].id+"'>报名</a></button>"+
							"</div>");
						}
						if($("#idMsg").val()==""){
							$(".join").attr("href","login.jsp");
							$(".save").attr("href","login.jsp");
						}
					},
					error:function(){
						alert("服务器请求异常！！！");
					}
				});
			});
			
		});
	</script>
</body>
</html>