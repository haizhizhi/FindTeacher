$(function(){
	$("#teachMsg").click(function(){
		$.ajax({
			type:"GET",
			url:"getOwnTeachMsgAction?id="+$("#idMsg").val(),
			dataType:"json",
			success:function(data){
				
				for(var i=0;i<data.length;i++){
					var openOrNot="";
					var openDate=data[i].openDate;
					var openDateArray=openDate.split("-");
					var openDateInt=parseInt(openDateArray.toString());
					var nowDate=new Date();
					var year=nowDate.getFullYear();
					var month=nowDate.getMonth();
					var day=nowDate.getDate();
					var nowDateInt=parseInt(year+month+day);
					if(openDateInt<nowDateInt){
						openOrNot="即将开班";
					}else{
						openOrNot="进行中";
					}
					$("#ownTeachMsg").children().remove();
					$("#ownTeachMsg").append("<div >"+
							"<div><strong>"+data[i].title+"</strong>&nbsp;&nbsp;"+data[i].teacher+"&nbsp;&nbsp;开班时间："+data[i].openDate+"</div>"+
							"<br>"+
							"<div><font Style='color: red;'>"+openOrNot+"</font>&nbsp;&nbsp;&nbsp;&nbsp;加入<font color='red'>"+data[i].joinNumber+"</font>人"+
							"</div>"+
							"</div>"+
							"<hr Style='border:solid #CFD5D8 1px;'>"
						);
				}
			},
			error:function(){
				alert("服务器请求异常！！！");
			}
		});
	});
});