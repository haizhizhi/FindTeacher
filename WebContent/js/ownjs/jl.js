$(function(){
	$(".teachScope").click(function(){
		var scopeType=$(this).val();
		$.ajax({
			type:"GET",
			url:"getTeachLevelAction?classScope="+scopeType,
			dataType:"json",
			success:function(data){
				$(".levelSelect").nextAll().remove();
				for(var i=data.length-1;i>=0;i--){
					$(".levelSelect").after("<option class='levelScope'>"+data[i].teachLevelName+"</option>");
				}
			},
			error:function(){
				alert("服务器请求异常！！！");
			}
		});
		
		$.ajax({
			type:"GET",
			url:"getTeachTypeAction?classScope="+scopeType,
			dataType:"json",
			success:function(data){
				$(".typeSelect").nextAll().remove();
				for(var i=data.length-1;i>=0;i--){
					$(".typeSelect").after("<option class='typeScope'>"+data[i].teachType+"</option>");
				}
			},
			error:function(){
				alert("服务器请求异常！！！");
			}
		});
	});
	
	$(".teachScope2").click(function(){
		var scopeType=$(this).val();
		$.ajax({
			type:"GET",
			url:"getTeachLevelAction?classScope="+scopeType,
			dataType:"json",
			success:function(data){
				$(".levelSelect2").nextAll().remove();
				for(var i=data.length-1;i>=0;i--){
					$(".levelSelect2").after("<option class='levelScope2'>"+data[i].teachLevelName+"</option>");
				}
			},
			error:function(){
				alert("服务器请求异常！！！");
			}
		});
		
		$.ajax({
			type:"GET",
			url:"getTeachTypeAction?classScope="+scopeType,
			dataType:"json",
			success:function(data){
				$(".typeSelect2").nextAll().remove();
				for(var i=data.length-1;i>=0;i--){
					$(".typeSelect2").after("<option class='typeScope2'>"+data[i].teachType+"</option>");
				}
			},
			error:function(){
				alert("服务器请求异常！！！");
			}
		});
	});
});