<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<input id="idMsg" type="hidden" value="${sessionScope.userMsg.id}">
<br/>
	<div class="foot_info" style="text-align:center;">
		<span style="font-size:8px;color:grey">
			Copyright © 2010-2017 武汉家教帮科技股份有限公司 &nbsp;
			<a href="#" target="_blank" rel="nofollow" style="color:#aaa;">鄂ICP备10235580号</a>&nbsp;
			股票代码：666666&nbsp; 
		</span>
	</div>
<script type="text/javascript">
		$(function(){
			if($("#idMsg").val()!=""){
				$(".online").css("display","block");
				$(".outline").css("display","none");
				$(".userLogin").css("display","block");
				$("#userCenter").attr("href","userCenter_S.jsp");
			}else{
				$(".online").css("display","none");
				$(".outline").css("display","block");
				$(".userLogin").css("display","none");
				$("#userCenter").attr("href","login.jsp");
			}
			
		});
</script>