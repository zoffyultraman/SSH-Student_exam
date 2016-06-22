
function startExam(e){
	  var subjectid=document.getElementById("subject"+e).innerText;
	  console.log("我在这里，可以跳转");
		console.log(subjectid);
	  $.ajax({
			url:"${pageContext.request.contextPath}/exam/ExamTest",
			dataType:"json",
			async:true,
			data:{
				subjectid:subjectid,
				},
			type: "post",
			
			success:function(req){
				console.log(req);
				if(req=="1"){
					console.log("666");
					window.location.href="${pageContext.request.contextPath}/exam/Return";
					
				}
				/* alert(req); */
			/* 	alert("考试开始"); */
			
			}
			
		    
		})		
	  
	  
/*   	window.location.href="${pageContext.request.contextPath}/exam/ExamTest"; */
  }
  


