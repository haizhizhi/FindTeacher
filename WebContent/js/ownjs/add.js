$(function(){
	var changeRow;
	var number=0;
	var year =new Date().getFullYear();
	var month=new Date().getMonth()+1;
	var day=new Date().getDate();
	var i=0;
	if(month<=9){
		month="0"+month;
	}
	if(day<=9){
		day="0"+day;
	}
	var timeString=year+"-"+month+"-"+day;
	$(".openDate").attr("min",timeString);
	$("#save").click(
			function() {
				var teachTitle = $("#teachTitle").val()
				var teacher = $("#teacher2").val();
				var teachScope = $(".teachScope2:checked")
						.next().text();
				var teachLevel = $(".levelScope2:selected")
						.text();
				var teachType = $(".typeScope2:selected")
						.text();
				var position = $("#teachPosition").val();
				var teachPhone = $("#teachPhone").val();
				var teachNumber = $("#teachNumber").val();
				var openDate = $("#openDate").val();
				changeRow.parent().prevAll().eq(0).text(openDate);
				changeRow.parent().prevAll().eq(1).text(teachNumber);
				changeRow.parent().prevAll().eq(2).text(teachPhone);
				changeRow.parent().prevAll().eq(3).text(position);
				changeRow.parent().prevAll().eq(4).text(teachType);
				changeRow.parent().prevAll().eq(5).text(teachLevel);
				changeRow.parent().prevAll().eq(6).text(teachScope);
				changeRow.parent().prevAll().eq(7).text(teacher);
				changeRow.parent().prevAll().eq(8).text(teachTitle);
			});
	$("#title").mouseout(function(){
		if($("#title").val()!=""){
			$("#title").css("border-color","initial");
		}
	});
	
	$("#teacher").mouseout(function(){
		if($("#teacher").val()!=""){
			$("#teacher").css("border-color","initial");
		}
	});
	
	$(".selectLJ").mouseout(function(){
		if($(".levelScope:selected").text()!=""){
			$(".selectLJ").css("border-color","initial");
		}
	});
	
	$(".selectXK").mouseout(function(){
		if($(".typeScope:selected").text()!=""){
			$(".selectXK").css("border-color","initial");
		}
	});
	
	$("#position").mouseout(function(){
		if($("#position").val()!=""){
			$("#position").css("border-color","initial");
		}
	});
	$("#openDate").mouseout(function(){
		if($("#openDate").val()!=""){
			$("#openDate").css("border-color","initial");
		}
	});
	
	
	$("#addTeach").click(function(){
		var title=$("#title").val();
		var teacher=$("#teacher").val();
		var teachScope=$(".teachScope:checked").next().text();
		var levelScope=$(".levelScope:selected").text();
		var typeScope=$(".typeScope:selected").text();
		var position=$("#position").val();
		var phone=$("#phone").val();
		var aimNumber=$("#aimNumber").val();
		var price=$("#price").val();
		var openData=$(".openDate").val();
		if(title==""){
			$("#title").css("border-color","red");
			alert("标题不能为空！！！");
			return;
		}
		if(teacher==""){
			$("#teacher").css("border-color","red");
			alert("老师不能为空！！！");
			return;
		}
		if(levelScope==""){
			$(".selectLJ").css("border-color","red");
			alert("年级不能为空！！！");
			return;
		}
		if(typeScope==""){
			$(".selectXK").css("border-color","red");
			alert("学科不能为空！！！");
			return;
		}
		if(position==""){
			$("#position").css("border-color","red");
			alert("位置不能为空！！！");
			return;
		}
		if(openData==""){
			$("#openDate").css("border-color","red");
			alert("时间不能为空！！！");
			return;
		}
		number++;
		i++;
		if(number<=9){
			number="00"+number;
		}else if(number<=99){
			number="0"+number;
		}
		//$("#reset").click();
		$("#table").append("<tr>"+
						"<td><input type='checkbox' name='classCheck' class='classCheck'></td>"+
						"<td style='text-align: center;'>"+"T"+$("#idMsg").val()+"-"+year+month+day+number+"</td>"+
						"<td >"+title+"</td>"+
						"<td style='text-align: center;'>"+teacher+"</td>"+
						"<td style='text-align: center;'>"+teachScope+"</td>"+
						"<td style='text-align: center;' >"+levelScope+"</td>"+
						"<td style='text-align: center;' >"+typeScope+"</td>"+
						"<td>"+position+"</td>"+
						"<td style='text-align: center;' >"+phone+"</td>"+
						"<td style='text-align: center;' >"+aimNumber+"</td>"+
						"<td style='text-align: center;' >"+price+"</td>"+
						"<td style='text-align: center;' >"+openData+"</td>"+
						"<td style='text-align: center;'><a class='change' data-reveal-id='myModal'>编辑</a>|<a class='delete'>删除</a></td>"+
					"</tr>");
		
		$(".delete").click(function() {
			
			$(this).parent().parent().remove();
		});
		$("#checkALL").click(function() {
			$(".classCheck").attr("checked", "checked");
		});
		$("#NoCheck").click(function() {
			$(".classCheck").removeAttr("checked");
		});
		$("#delete").click(function() {
			
			$(".classCheck:checked").parent().parent().remove();
		});
		
		$(".change").click(function() {
			changeRow = $(this);
			var teachTitle = $(this).parent().prevAll().eq(8).text();
			var teacher = $(this).parent().prevAll().eq(7).text();
			var teachScope = $(this).parent().prevAll().eq(6).text();
			var teachLevel = $(this).parent().prevAll().eq(5).text();
			var teachtype = $(this).parent().prevAll().eq(4).text();
			var position = $(this).parent().prevAll().eq(3).text();
			
			var phone = $(this).parent().prevAll().eq(2).text();
			
			var aimNumber = $(this).parent().prevAll().eq(1).text();
			
			var openDate = $(this).parent().prevAll().eq(0).text();
			
			$("#teachTitle").val(teachTitle);
			$("#teacher2").val(teacher);
			$("#teachPosition").val(position);
			$("#teachPhone").val(phone);
			$("#teachNumber").val(aimNumber);
			$("#openDate").val(openDate);
			var scopeType="";
			$(".teachScope2").each(function() {
				var teachScope2 = $(this).next().text();
				if (teachScope2 == teachScope) {
					$(this).attr("checked", "checked");
					scopeType=$(this).val();
				}
			});
			
			$.ajax({
				type:"GET",
				url:"getTeachLevelAction?classScope="+scopeType,
				dataType:"json",
				success:function(data){
					$(".levelSelect2").nextAll().remove();
					for(var i=data.length-1;i>=0;i--){
						$(".levelSelect2").after("<option class='levelScope2'>"+data[i].teachLevelName+"</option>");
					}
					$(".levelScope2").each(function() {
						var levelScope2 = $(this).text();
						if (levelScope2 == teachType) {
							$(this).attr("selected", "selected");
						}
					});
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
			
			
			$(".typeScope2").each(function() {
				var typeScope2 = $(this).text();
				if (typeScope2 == teachType) {
					$(this).attr("selected", "selected");
				}
			});
		});

		
	});
	$("#release").click(function(){
		$("td").removeAttr("id");
		var teachRow=$(".classCheck:checked")
		for(var i=0;i<=teachRow.length;i++){
			$(".classCheck:checked").eq(i).parent().nextAll().eq(0).attr("id","id"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(1).attr("id","title"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(2).attr("id","teacher"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(3).attr("id","scope"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(4).attr("id","level"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(5).attr("id","type"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(6).attr("id","position"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(7).attr("id","phone"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(8).attr("id","aimNumber"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(9).attr("id","price"+(i+1));
			$(".classCheck:checked").eq(i).parent().nextAll().eq(10).attr("id","openDate"+(i+1));
		}
		
		for(var i=1;i<=teachRow.length;i++){
			$.ajax({
				type:"GET",
				url:"insertTeachMsgAction?id="+$("#id"+i).text()+"&&title="+$("#title"+i).text()+"&&teacher="+$("#teacher"+i).text()+"&&scope="+$("#scope"+i).text()+"&&level="+$("#level"+i).text()+"&&type="+$("#type"+i).text()+"&&position="+$("#position"+i).text()+"&&phone="+$("#phone"+i).text()+"&&aimNumber="+$("#aimNumber"+i).text()+"&&openDate="+$("#openDate"+i).text()+"&&price="+$("#price"+i).text(),
				dataType:"text",
				success:function(data){
					if(data=="true"){
						$(".classCheck:checked").parent().parent().remove();
					
					}if(data=="false"){
						alert("发布失败！！！");
					}
				},
				error:function(){
					alert("服务器请求异常！！！");
				}
			});
		}
		alert("发布成功！！！");
	});
	
});