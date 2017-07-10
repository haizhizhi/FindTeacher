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
			var bol=true;
			$(".changeNickName").click(function(){
				if(bol){
					$(this).text("确定");
					$("#nickName").attr("disabled",false);
					$("#nickName").focus();
					bol=false;
				}else{
					if($("#nickName").val()==""){
						alert("昵称不能为空");
						return;
					}
					$(this).text("修改");
					$("#nickName").attr("disabled",true);
					bol=true;
					$.ajax({
						type:"GET",
						url:"changeUserMsgAction?id="+$("#idMsg").val()+"&&nickName="+$("#nickName").val(),
						dataType:"text",
						success:function(data){
							$("#topNickName").text(data);
						},
						error:function(){
							alert("服务器请求异常！！！");
						}
					});
				}
				
			});
			
			var bol2=true;
			$(".changePassword").click(function(){
				if(bol2){
					$(this).text("确定");
					$("#password").attr("disabled",false);
					$("#password").focus();
					bol2=false;
				}else{
					if($("#password").val()==""){
						alert("密码不能为空");
						return;
					}
					$(this).text("修改");
					$("#password").attr("disabled",true);
					bol2=true;
					
					$.ajax({
						type:"GET",
						url:"changeUserMsgAction?id="+$("#idMsg").val()+"&&password="+$("#password").val(),
						dataType:"text",
						success:function(data){
						},
						error:function(){
							alert("服务器请求异常！！！");
						}
					});
				}
				
			});
			
		});