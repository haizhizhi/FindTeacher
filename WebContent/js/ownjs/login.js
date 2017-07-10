$(function(){
			$("#userName").focus();
			$("#userName").val("");
			//保存原有的颜色
			var bcolor=$("#userName").css("border-color");
			//表单非空验证
        	$("#submit").click(function(){
        		if($("#userName").val().trim()==""){
        			$("#userName").attr("placeholder","用户名不能为空！");
        			$("#userName").css("border-color","red");
        			$("#userName").focus();
        			$("#userName").val("");
        			$("#passWord").val("");
        			$("#passWord").css("border-color",bcolor);
        			
        			return false;
        		}
        		if($("#passWord").val().trim()==""){
        			$("#passWord").attr("placeholder","密码不能为空！");
        			$("#passWord").css("border-color","red");
        			$("#userName").css("border-color",bcolor);
        			$("#passWord").focus();
        			return false;
        		}
        	});
        });