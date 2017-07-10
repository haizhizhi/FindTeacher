$(function(){
	$("#find").click(function(){
		$.ajax({
			type:"GET",
			url:"getOwnTeachMsgAction?id="+$("#idMsg").val(),
			dataType:"json",
			success:function(data){
				for(var i=0;i<data.length;i++){
					$("#table").append("<tr>"+
							"<td style='text-align: center;'>"+data[i].id+"</td>"+
							"<td >"+data[i].title+"</td>"+
							"<td style='text-align: center;'>"+data[i].teacher+"</td>"+
							"<td style='text-align: center;' >"+data[i].teachLevelId+"</td>"+
							"<td style='text-align: center;' >"+data[i].teachTypeId+"</td>"+
							"<td style='text-align: center;' >"+data[i].position+"</td>"+
							"<td style='text-align: center;' >"+data[i].phone+"</td>"+
							"<td style='text-align: center;'>"+data[i].aimNumber+"</td>"+
							"<td style='text-align: center;'>"+data[i].joinNumber+"</td>"+
							"<td style='text-align: center;'>"+data[i].price+"</td>"+
							"<td style='text-align: center;'>"+data[i].openDate+"</td>"+
							"<td style='text-align: center;'><a class='delete'>删除</a></td>"+
						"</tr>");
				}
				$(".delete").click(function() {
					if(!confirm("确定删除吗？")){
						return false;
					}
					$.ajax({
						type:"GET",
						url:"deleteTeachMsg?id="+$(this).parent().prevAll().eq(10).text(),
						dataType:"text",
						success:function(data){
							if(data=="true"){
								alert("删除成功！");
							}else{
								alert("删除失败！！");
							}
						},
						error:function(){
							alert("服务器请求异常！！！");
						}
					});	
					$(this).parent().parent().remove();
				});
				
			},
			error:function(){
				alert("服务器请求异常！！！");
			}
		});	
	});
	
	
});