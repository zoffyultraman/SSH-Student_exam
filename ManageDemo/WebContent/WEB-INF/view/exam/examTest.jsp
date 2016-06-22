<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请各位学生认真考试！</title>
 <link rel="stylesheet"  href="${pageContext.request.contextPath}/lib/style3.css"> 
<link href="${pageContext.request.contextPath}/lib/css/reset.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/lib/css/style.css" type="text/css" rel="stylesheet" />
<!--jQuery-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/modernizr.js"></script>
   
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/td.css">
<script>
$(window).load(function() {
/* 	  var aa=document.getElementById("panduan").value; */
    	$(".teahidden1").css({"display":"none"}); 
    	/*  $(".sideber-nav").hide("fast"); */
     	$(".stuhidden2").css({"display":"none"});
     	$(".stuhidden3").css({"display":"none"});
     	$(".stuhidden4").css({"display":"none"});
     	$(".nav>li>a").css({"display":"none"});
     	$(".teahidden5").css({"display":"block"});
     	$(".teahidden6").css({"display":"block"});
     	history.forward();
})
</script>
<!-- 
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
 -->
<script type="text/javascript">
var time1=${sessionScope.subjectTotaltime};
var intDiff = parseInt(time1)*60;//倒计时总秒数量

function timer(intDiff){
	window.setInterval(function(){
	var day=0,
		hour=0,
		minute=0,
		second=0;//时间默认值		
	if(intDiff > 0){
		day = Math.floor(intDiff / (60 * 60 * 24));
		hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
		minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
		second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
	}
	if (minute <= 9) minute = '0' + minute;
	if (second <= 9) second = '0' + second;
	$('#day_show').html(day+"天");
	$('#hour_show').html('<s id="h"></s>'+hour+'时');
	$('#minute_show').html('<s></s>'+minute+'分');
	$('#second_show').html('<s></s>'+second+'秒');
	intDiff--;
	}, 1000);
} 
//计时器结束事件
 function timeMsg(){
	 {
		 var time1=${sessionScope.subjectTotaltime};
			var time2=time1*1000*60;
			var t=setTimeout("tiaozhuan()",time2)
	 }
 }
 function tiaozhuan(){
	 window.location.href="${pageContext.request.contextPath}/exam/submit";
 }
$(function(){
	timer(intDiff);
	timeMsg();
});	

color='white';
otherColor='red';
function swapColor() {
    var temp = color;
    color = otherColor;
    otherColor = temp;
}
//选择题目的Ajax
function selectTopic(e){
	for(i=0;i<document.getElementsByName("option").length;i++){
		document.getElementsByName("option")[i].checked = "false";
	}
	 e.style.color=color;
	 swapColor();
	 var TiId=e.innerText-1;
	 var nextTiId=e.innerText;
	 var TiNumber=e.innerText;
	   $.ajax({
			url:"${pageContext.request.contextPath}/exam/TiNumber",
			dataType:"json",
			async:true,
			data:{
				color:color,
				TiNumber:TiNumber,
				TiId:TiId,
				nextTiId:nextTiId
				},
			type: "POST",
			success:function(data){
				if(data!=false){
					function selectno()
					{
					 for(i=0;i<document.getElementsByName("option").length;i++)
					 {
					 document.getElementsByName("option")[i].checked = false;
					 }
					}
					var examStuTiVO=data.examStuTiVO;
					var examStuTiVOa=data.examStuTiVO.exam_ti_key;
					console.log(examStuTiVO);
					console.log(examStuTiVOa);
					var topic=data.topic;
					var optiona=data.optiona;
					var optionb=data.optionb;
					var optionc=data.optionc;
					var optiond=data.optiond;
					var TiNumber=data.TiNumber;
					var TiStateId=data.color;
					var typeid=data.Type;
					var key=data.key;
					console.log(key);
					 $("#topic").text(topic); 
					 $("#optiona").text(optiona);
					 $("#optionb").text(optionb);
					 $("#optionc").text(optionc);
					 $("#optiond").text(optiond);
					 $("#TiNumber").text(TiNumber);
					 var p=$("#TiNumber").text();
					 $("#TiNumber").val(TiNumber);
					 $("#TiNumbertopic").text(TiNumber);
					 var eTiId=data.eTiId;
					 $("#bTiId").val(eTiId);
					 $("#TiStateId").val(color);
					 if(typeid==1){
						 console.log("我在多选框中");
						 $("#checka").css({"display":"block"});
						 $("#checkb").css({"display":"block"});
						 $("#checkc").css({"display":"block"});
						 $("#checkd").css({"display":"block"});
						 $("#btn").css({"display":"block"});
						 $("#btnradio").css({"display":"none"});
						 $("#btnradio").css({"display":"none"});
						 $("#optiona2").css({"display":"none"});
						 $("#optionb2").css({"display":"none"});
						 $("#optionc2").css({"display":"none"});
						 $("#optiond2").css({"display":"none"});
						 var boxes=document.getElementsByName("check");  
						    if(key.indexOf("A")==0){
							       boxes[0].checked = true;
							   }else if(key.indexOf("B")==0){
								   boxes[1].checked = true;
							   }else if(key.indexOf("C")==0){
								   boxes[2].checked = true;
							   }else if(key.indexOf("D")==0){
									 boxes[3].checked = true;
							}else if(key==""){
								boxes[0].checked = false;
								boxes[1].checked = false;
								boxes[2].checked = false;
								boxes[3].checked = false;
							}
 					 }else{
						 console.log("我在单选框中");
						 $("#checka").css({"display":"none"});
						 $("#checkb").css({"display":"none"});
						 $("#checkc").css({"display":"none"});
						 $("#checkd").css({"display":"none"});
						 $("#btn").css({"display":"none"});
						 $("#btnradio").css({"display":"block"});
						 $("#btnradio").css({"display":"block"});
						 $("#optiona2").css({"display":"block"});
						 $("#optionb2").css({"display":"block"});
						 $("#optionc2").css({"display":"block"});
						 $("#optiond2").css({"display":"block"});  
					     var option=document.getElementsByName("option");
						    if(key.indexOf("A")==0){
							  document.getElementsByName("option")[0].checked = true;
						   }else if(key.indexOf("B")==0){
						  	  document.getElementsByName("option")[1].checked = true;
						   }else if(key.indexOf("C")==0){
						  	  document.getElementsByName("option")[2].checked = true;
							 }else if(key.indexOf("D")==0){
							  document.getElementsByName("option")[3].checked = true;
						}
						else if(key==""){
							document.getElementsByName("option")[0].checked = false;
							document.getElementsByName("option")[1].checked = false;
							document.getElementsByName("option")[2].checked = false;
							document.getElementsByName("option")[3].checked = false;
 					 }
 					 }
				}  
				}
            })
}

//多选项的ajax
function confirm(){
    var str =document.getElementsByName("check");
    var obj=str.length;
    var ches="";
    for(var i=0;i<obj;i++){
    	if(str[i].checked == true){
    	 	ches+=str[i].value; 
    	}
    }
    var Answers=ches;
    var idd=$("#bTiId").val();
    var color=$("#TiStateId").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/exam/Answers",
		dataType:"json",
		async:true,
		data:{
			idd:idd,
			Answers:Answers
		},
		type:"POST",
		success:function(data){
			    nextTi();
			    /* var key =data.key;
			    var boxes=document.getElementsByName("check");  
				   if(key.indexOf("A")==0){
					       boxes[0].checked = true;
					   }else if(key.indexOf("B")==0){
						   boxes[1].checked = true;
					   }else if(key.indexOf("C")==0){
						   boxes[2].checked = true;
						 }else if(key.indexOf("D")==0){
							 boxes[3].checked = true;
					} else if(key==""){
						boxes[0].checked = false;
						boxes[1].checked = false;
						boxes[2].checked = false;
						boxes[3].checked = false;
					}  */
			}
	
	})
} 

//单选框的ajax
function check_Answers(e){
	var Answers=e.value;
	var idd=$("#bTiId").val();
	var color=$("#TiStateId").val();
	$.ajax({
		url:"${pageContext.request.contextPath}/exam/Answers",
		dataType:"json",
		async:true,
		data:{
/* 			color:color, */
			idd:idd,
			Answers:Answers
		},
		type:"POST",
		success:function(data){
			}
	})
}
var a=0;
function test(){
	a=a+1;
	alert(a);
}

//上一题的ajax方法
function upTi(){
	upa=$("#aa").text();
	if((upa-1)>1)
	upa=upa-1;
	if(upa>0){

	$("#aa").text(upa);
	
	}
	$.ajax({
		url:"${pageContext.request.contextPath}/exam/upTi",
		dataType:"json",
		async:true,
		data:{
			upa:upa
		},
		type:"POST",
		success:function(data){
 			var topic=data.topic;
			var optiona=data.optiona;
			var optionb=data.optionb;
			var optionc=data.optionc;
			var optiond=data.optiond;
			var aa=data.aa;
			 $("#aa").text(aa);
			 $("#topic").text(topic); 
			 $("#optiona").text(optiona);
			 $("#optionb").text(optionb);
			 $("#optionc").text(optionc);
			 $("#optiond").text(optiond);
			 var option=document.getElementsByName("option");
			    if(key.indexOf("A")==0){
				  document.getElementsByName("option")[0].checked = true;
			   }else if(key.indexOf("B")==0||key.indexOf("B")==1){
			  	  document.getElementsByName("option")[1].checked = true;
			   }else if(key.indexOf("C")==0||key.indexOf("C")==1){
			  	  document.getElementsByName("option")[2].checked = true;
				 }else if(key.indexOf("D")==0||key.indexOf("D")==1){
				  document.getElementsByName("option")[3].checked = true;
			}
			else if(key==""){
					 for(i=0;i<option.length;i++){
						 option[i].checked= false;
						 }
					 }
		   var boxes=document.getElementsByName("check");  
		   if(key.indexOf("A")==0){
			       boxes[0].checked = true;
			   }else if(key.indexOf("B")==0||key.indexOf("B")==1){
				   boxes[1].checked = true;
			   }else if(key.indexOf("C")==0||key.indexOf("C")==1){
				   boxes[2].checked = true;
				 }else if(key.indexOf("D")==0||key.indexOf("D")==1){
					 boxes[3].checked = true;
			}else if(key==""){
				 for(i=0;i<boxes.length;i++){
					 boxes[i].checked= false;
					 }
			}
		}
	}) 
}
var centera=0;
//下一题的ajax方法	    
function nextTi(){
	var TiNumber=$("#TiNumber").val();
	var a=parseInt(TiNumber)+1;
	console.log(a);
    if(a<=20){
    	$("#TiNumber").val(a);
    	$("#TiNumber").text(a);
	   $.ajax({
			url:"${pageContext.request.contextPath}/exam/nextTi",
			dataType:"json",
			async:true,
			data:{
				a:a
			},
			type:"POST",
			success:function(data){
			/* 	$("#search_content").empty(); */
	 			var topic=data.topic;
				var optiona=data.optiona;
				var optionb=data.optionb;
				var optionc=data.optionc;
				var optiond=data.optiond;
				var aa=data.aa;
				var key=data.key;
				var tiType=data.tiType;
				 if(tiType==1){
					 console.log("我在多选框中");
					 $("#checka").css({"display":"block"});
					 $("#checkb").css({"display":"block"});
					 $("#checkc").css({"display":"block"});
					 $("#checkd").css({"display":"block"});
					 $("#btn").css({"display":"block"});
					 $("#btnradio").css({"display":"none"});
					 $("#optiona2").css({"display":"none"});
					 $("#optionb2").css({"display":"none"});
					 $("#optionc2").css({"display":"none"});
					 $("#optiond2").css({"display":"none"});
					 $("#aa").text(aa);
					 $("#topic").text(topic); 
					 $("#optiona").text(optiona);
					 $("#optionb").text(optionb);
					 $("#optionc").text(optionc);
					 $("#optiond").text(optiond);
					 var boxes=document.getElementsByName("check");  
					   if(key.indexOf("A")==0){
						       boxes[0].checked = true;
						   }else if(key.indexOf("B")==0){
							   boxes[1].checked = true;
						   }else if(key.indexOf("C")==0){
							   boxes[2].checked = true;
							 }else if(key.indexOf("D")==0){
								 boxes[3].checked = true;
						} else if(key==""){
							boxes[0].checked = false;
							boxes[1].checked = false;
							boxes[2].checked = false;
							boxes[3].checked = false;
						} 
					 }else{
					var key=data.key;
					 console.log("我在单选框中");
					 $("#checka").css({"display":"none"});
					 $("#checkb").css({"display":"none"});
					 $("#checkc").css({"display":"none"});
					 $("#checkd").css({"display":"none"});
					 $("#btn").css({"display":"none"});
					 $("#btnradio").css({"display":"block"});
					 $("#optiona2").css({"display":"block"});
					 $("#optionb2").css({"display":"block"});
					 $("#optionc2").css({"display":"block"});
					 $("#optiond2").css({"display":"block"});  
					 $("#aa").text(aa);
					 $("#topic").text(topic); 
					 $("#optiona").text(optiona);
					 $("#optionb").text(optionb);
					 $("#optionc").text(optionc);
					 $("#optiond").text(optiond);
					 
					 var option=document.getElementsByName("option");
					    if(key.indexOf("A")==0){
						  document.getElementsByName("option")[0].checked = true;
					   }else if(key.indexOf("B")==0){
					  	  document.getElementsByName("option")[1].checked = true;
					   }else if(key.indexOf("C")==0){
					  	  document.getElementsByName("option")[2].checked = true;
					   }else if(key.indexOf("D")==0){
						  document.getElementsByName("option")[3].checked = true;
					}
					else if(key==""){
						option[0].checked = false;
						option[1].checked = false;
						option[2].checked = false;
						option[3].checked = false;
					   }
                   }
			}
		}) 
	 
}
}
//上一题的ajax方法	    
function upTi1(){
	var TiNumber=$("#TiNumber").val();
	var a=parseInt(TiNumber)-1;
    if(a>0){
    	$("#TiNumber").val(a);
    	$("#TiNumber").text(a);
	   $.ajax({
			url:"${pageContext.request.contextPath}/exam/nextTi",
			dataType:"json",
			async:true,
			data:{
				a:a
			},
			type:"POST",
			success:function(data){
	 			var topic=data.topic;
				var optiona=data.optiona;
				var optionb=data.optionb;
				var optionc=data.optionc;
				var optiond=data.optiond;
				var aa=data.aa;
				var tiType=data.tiType;
				 if(tiType==1){
					 console.log("我在多选框中");
					 $("#checka").css({"display":"block"});
					 $("#checkb").css({"display":"block"});
					 $("#checkc").css({"display":"block"});
					 $("#checkd").css({"display":"block"});
					 $("#btn").css({"display":"block"});
					 $("#btnradio").css({"display":"none"});
					 $("#btnradio").css({"display":"none"});
					 $("#optiona2").css({"display":"none"});
					 $("#optionb2").css({"display":"none"});
					 $("#optionc2").css({"display":"none"});
					 $("#optiond2").css({"display":"none"});
					 
					 $("#aa").text(aa);
					 $("#topic").text(topic); 
					 $("#optiona").text(optiona);
					 $("#optionb").text(optionb);
					 $("#optionc").text(optionc);
					 $("#optiond").text(optiond);
					 var check=document.getElementsByName("check");
					 for(i=0;i<document.getElementsByName("check").length;i++){
						    if(key.indexOf("A")==0){
						    	document.getElementsByName("check")[0].setAttribute("")
							  document.getElementsByName("check")[0].checked = true;
						   }else if(key.indexOf("B")==0||key.indexOf("B")==1){
						  	  document.getElementsByName("check")[1].checked = true;
						   }else if(key.indexOf("C")==0||key.indexOf("C")==1){
						  	  document.getElementsByName("check")[2].checked = true;
							 }else if(key.indexOf("D")==0||key.indexOf("D")==1){
							  document.getElementsByName("check")[3].checked = true;
							 }
					   }
					 }else{
					 console.log("我在单选框中");
					 $("#checka").css({"display":"none"});
					 $("#checkb").css({"display":"none"});
					 $("#checkc").css({"display":"none"});
					 $("#checkd").css({"display":"none"});
					 $("#btn").css({"display":"none"});
					 $("#btnradio").css({"display":"block"});
					 $("#btnradio").css({"display":"block"});
					 $("#optiona2").css({"display":"block"});
					 $("#optionb2").css({"display":"block"});
					 $("#optionc2").css({"display":"block"});
					 $("#optiond2").css({"display":"block"});  
					 $("#aa").text(aa);
					 $("#topic").text(topic); 
					 $("#optiona").text(optiona);
					 $("#optionb").text(optionb);
					 $("#optionc").text(optionc);
					 $("#optiond").text(optiond);
					 
}
				 
				 var option=document.getElementsByName("option");
				 
				   for(i=0;i<document.getElementsByName("option").length;i++){
					    if(key.indexOf("A")==0){
						  document.getElementsByName("option")[0].checked = true;
					   }else if(key.indexOf("B")==0||key.indexOf("B")==1){
					  	  document.getElementsByName("option")[1].checked = true;
					   }else if(key.indexOf("C")==0||key.indexOf("C")==1){
					  	  document.getElementsByName("option")[2].checked = true;
						 }else if(key.indexOf("D")==0||key.indexOf("D")==1){
						  document.getElementsByName("option")[3].checked = true;
						 }
				   }
				  
			}
		}) 
   }
	
	 
}
function suu(){
     modal({
        type: 'confirm',
        title: 'Confirm',
        text: '你确定要交卷？',
        callback: function(result) {
        	if(result==true){
        	    window.location.href="${pageContext.request.contextPath}/exam/submit";
     }
        	}
    }); 
}


</script>



<script>
$(document).ready(function(e) {
	
/* 	check_Answers(1);
	var Ti1=$("#Ti1").text(); */
/* 	nextTi();
 */   $('#Ti1').click(); 

});



//交卷按钮
function submitTi(){
		$.ajax({
			url:"${pageContext.request.contextPath}/exam/submit",
			dataType:"json",
			async:true,
			data:{
			},
			type:"POST",
			success:function(data){
				   alert("成绩提交成功");
				/*    windiow.onload.href("${pageContext.request.contextPath}/exam/submit"); */
/* 				   var submitTi=data.submitTi;
				   $("#submitTi").text(submitTi); */
				}
			
		}) 
		
		/* window.location.href="${pageContext.request.contextPath}/exam/submit"; */
		
}

</script>




</head>

<body>
<!--     <a class="btn btn-info"  onclick="test()">点我，我是测试！！</a> -->
<input type="hidden" id="bTiId">
<input type="hidden" id="TiStateId">
<input type="hidden" id="nextTiId">
<div  id="count" ></div>
<input type="hidden" id="typeid">
<input type="hidden" id="centera">
<!-- <p id="Ti1Id">1</p>
<p id="Ti1Id"></p> -->
<!-- <input type="button" class="btn btn-info" id="submitTi" onclick="submitTi()" value="交卷"/> -->






  <a href="" class="cd-popup-trigger">交卷</a>

<div class="cd-popup" role="alert">
	<div class="cd-popup-container">
		<p>Are you sure you want to delete this element?</p>
		<ul class="cd-buttons">
			<li><a href="${pageContext.request.contextPath}/exam/submit" class="left">Yes</a></li>
			<li><a href="">No</a></li>
		</ul>
		<a href="#" class="cd-popup-close img-replace">Close</a>
	</div> <!-- cd-popup-container -->
</div> <!-- cd-popup -->
<div id="submitTi"></div>

<p><h2>总共题数:20</h2></p>
 <p><h2>这是第<input type="hidden" id="aa"> <a id="TiNumber"></a>题</h2></p> <!-- <button type="button" class="btn btn-info" onclick="upTi()">
上一题  -->
<button type="button" class="btn btn-info" onclick="nextTi()">
下一题
</button> 
<hr>
<br>
<table>
<%-- <c:forEach items="${page.dates}" var="ExamStu"> --%>
          <tr>  
             <div class="panel panel-default">
                
                <div class="panel-body">
               
               <form action="${pageContext.request.contextPath}/exam/Return" class="form-horizontal" method="post" >
                <div class="form-group">
			       <p><div id="topic"></div>
			       	  A:<input type="radio" name="option" id="optiona2" onclick="check_Answers(this)" value="A" class="optiond1"  />
			       	  <input type="checkbox" name="check"  id="checka" value="A" class="checkbox1"/>
			       	  <div id="optiona"></div>
			       	 <br>
			         B:<input type="radio" name="option"  id="optionb2" onclick="check_Answers(this)" value="B" class="optiond2" />
			       	  <input type="checkbox" name="check"  id="checkb" value="B" class="checkbox2" />
			       	 <div id="optionb"></div>
			       	 <br>
			       	  C:<input type="radio" name="option" id="optionc2" onclick="check_Answers(this)" value="C"  class="optiond3" />
			       	  <input type="checkbox" name="check" id="checkc" value="C" class="checkbox3" />
			       	<div id="optionc"></div>
			       	 <br>
			       	 D:<input type="radio" name="option" id="optiond2" onclick="check_Answers(this)" value="D" class="optiond4" />
			       	  <input type="checkbox" name="check"  id="checkd" value="D" class="checkbox4" />
			       	<div id="optiond"></div>
			       	<input type="button"  id="btnradio" onclick="nextTi()" value="确认" class="btn btn-info">
			       	<input type="button"  id="btn" onclick="confirm()" name="button" value="确认" class="btn btn-info">
			        </div>  
		      </form>
                </div>
            </div>
         </tr>	
        
</table>
<%-- </c:forEach> --%>
</body>
</html>