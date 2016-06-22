<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交成功页面</title>
<script>
$(window).load(function() {
    	 $(".stuhidden1").css({"display":"none"});
    	 $(".stuhidden2").css({"display":"none"});
    	 $(".sidebar-nav").css({"display":"none"});
})
</script>
<script language="JavaScript">
 document.oncontextmenu=new Function("event.returnValue=false;");
document.onselectstart=new Function("event.returnValue=false;");
$(document).keydown(function(event){
	if ((event.altKey)&& 
	  ((event.keyCode==37)||   //屏蔽 Alt+ 方向键 ← 
	   (event.keyCode==39)))   //屏蔽 Alt+ 方向键 → 
   { 
	   event.returnValue=false; 
	   return false;
   } 
	if(event.keyCode==8){
		return false; //屏蔽退格删除键  
	}
	if(event.keyCode==116){
		return false; //屏蔽F5刷新键 
	}
	if((event.ctrlKey)){
		return false; //屏蔽alt+R 
	}
	if(event.keyCode==9){
		return false; //屏蔽Tab
	}
	if(event.keyCode==112){
		return false; //屏蔽F1
	}
	if(event.keyCode==113){
		return false; //屏蔽F2
	}
	if(event.keyCode==114){
		return false; //屏蔽F3
	}
	if(event.keyCode==115){
		return false; //屏蔽F4
	}
	if(event.keyCode==117){
		return false; //屏蔽F6
	}
	if(event.keyCode==118){
		return false; //屏蔽F7
	}
	if(event.keyCode==119){
		return false; //屏蔽F8
	}
	if(event.keyCode==120){
		return false; //屏蔽F9
	}
	if(event.keyCode==121){
		return false; //屏蔽F10
	}
	if(event.keyCode==122){
		return false; //屏蔽F11
	}
	if(event.keyCode==123){
		return false; //屏蔽F12
	}
});
</script>




<script type="text/javascript">
        window.history.forward(1);
</script>
</head>
<body>
<div class="jumbotron">
<h1>${sessionScope.sName}</h1>
<h2>成绩为:${sessionScope.count }</h2>
<p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/returnzhu" role="button">下一科</a></p>
<p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/home" role="button">退出考试</a></p>
</div>


</body>
</html>