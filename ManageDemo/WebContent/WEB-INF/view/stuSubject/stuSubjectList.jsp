<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" import="java.util.*,com.ite.smvcDemo.common.vo.users.UserVO" %>    
<!doctype html>

<html lang="en"><head>
    <meta charset="utf-8">
    <title>教师管理考试成绩</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/style.css">
<link href="${pageContext.request.contextPath}/lib/css/jquery.modal.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/lib/css/jquery.modal.theme-xenon.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/lib/css/jquery.modal.theme-atlant.css" type="text/css" rel="stylesheet" />
<!--jQuery-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery-latest.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery.modal.js"></script>
<style type="text/css">
 a{
 cursor:pointer;
   color:#FFFFFF;
 
 }
 td a{
 
 }
</style>
<script type="text/javascript">
function disp_confirm()
  {
  var r=confirm("确定删除？")
  if (r==true)
    {
	  return true;
    }
  else
    {
	  return false;
    }
  }    

  function addTi(){
  	window.location.href="${pageContext.request.contextPath}/ti/tiAdd";
  }

/* function IJSP(){
	  var bb=document.getElementsByName("Number");
	  var panduan=document.getElementsByName("panduan");
	  var aa=$("#panduan").val();
	  var uname=document.getElementById("panduan").value;
	  var SS=uname;
	  alert(SS);
	  alert("165611");
     if(panduan==2){
    	 $("#stuhidden").hide();
     }
	  
  } */
  function confim(id,totaltime){
	  	
	  	var subjectId=document.getElementById("subject"+id).innerText;
	  	var time=document.getElementById("totalTime"+totaltime).innerText;
	  	var name="${sessionScope.sName}";
        var sessionlist="${sessionScope.list}";
   		var Subjectname=0;
   				modal({
   		            type: 'confirm',
   		            title: '考试信息',
   		            text: '<center>'+'学生名字：'+name+'<br/><br/>'+'考试科目编号:'+subjectId+'<br/><br/>'+'考试时间:'+time+'<br/><br/></center>',
   		            callback: function(result) {
   		                if(result==true){
   		                  e=$("#subjectid").val();
   		               	  var subjectid=document.getElementById("subject"+e).innerText;
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
   		               			
   		               			}
   		               			
   		               		    
   		               		})		
   		                }
   		            }
   		        });
/*    			}
	  	}) */
        
  }
  
</script>


</head>
<body class="theme-blue" >
 
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success">
        <button data-dismiss="alert" class="close">×</button>${message}
    </div>
</c:if>

        <div class="header">
            <h1 class="page-title">Users</h1>
                    <ul class="breadcrumb">
            <li><a href="index.html">Home</a> </li>
            <li class="active">Users</li>
        </ul>

        </div>
        
        
        <div class="search-well">
                <%-- <form class="form-inline" method="post" style="margin-top:0px;"  action="${pageContext.request.contextPath}/grade/GradeFind" >
                    <input class="input-xlarge form-control" placeholder="请输入科目、学号、姓名、考试日期" id="appendedInputButton" name="num" value="${num }" type="text">
                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i> Go</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/gradePoint/GradePrint">成绩打印</a>
                
                </form> --%>

            
<%-- <div class="btn-toolbar list-toolbar">
    <button class="btn btn-primary"><i class="fa fa-plus"></i> <a href="${pageContext.request.contextPath}/stu/add">New User</a></button>
    <button class="btn btn-default"><a href="${pageContext.request.contextPath }/upload">Import</a></button>
    <button class="btn btn-default">Export</button>
  <div class="btn-group">
  </div>
</div>
 --%>


   <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <td>科目编号</td>
			                  <th>科目名称</th>
			                  <th>说明</th>
			                  <th>题数</th>
			                  <th>总时间</th>
			                  <th>总分</th>
			                  <th>学生是否已参加考试</th>
			                  <td>科目状态</td>
			                  <td>得分情况</td>
			                 <!--  <th></th>
			                  <th style="width: 3.5em;"></th> -->
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${list}" var ="userVO">
			               <tr>
			                  <td id="subject${userVO.exam_subject_id}">${userVO.exam_subject_id}</td> 
			                  <td id="subName${userVO.exam_subject_name}">${userVO.exam_subject_name}</td>
			                  <td >${userVO.exam_subject_description} </td>
			                  <td>${userVO.exam_subject_tnumber} </td>
			                  <td id="totalTime${userVO.exam_subject_totaltime}">${userVO.exam_subject_totaltime}</td>
			                  <td>${userVO.exam_subject_sum} <input type="hidden" id="sum" value="${userVO.exam_subject_sum}"></td>
			                  <td>
			                     <c:choose>
								   <c:when test="${userVO.UPDUSER eq 1}">
									 <a class="btn btn-primary" href="">已考</a>
<%-- 									 <a class="btn btn-primary"  href="${pageContext.request.contextPath}/stuGrade/stuGradeListS">成绩打印</a> --%>
									 
								   </c:when>
								   <c:otherwise>
								   <input type="hidden" id="subjectid" value="${userVO.exam_subject_id}">
								<!-- 	 <button class="btn btn-default"  onclick="startExam()">开始考试</button>   -->
								 	<button class="btn btn-default"  onclick="confim(${userVO.exam_subject_id},${userVO.exam_subject_totaltime})">开始考试</button>  
									
								   </c:otherwise>
							    </c:choose>
			                  </td>
			                  <td>
			                   <c:choose>
								   <c:when test="${userVO.exam_subject_done eq 0}">
									 <button class="btn btn-primary"  onclick="">关闭</button>
								   </c:when>
								   <c:otherwise>
									 <button class="btn btn-default"  onclick="">开放</button>
								   </c:otherwise>
							    </c:choose>
			                  </td>
			                  <td>${userVO.exam_grade_point}</td>
			                  <%-- <td>
						          <a href="${pageContext.request.contextPath}/ti/TiEdit/${ExamTi.examTiId}">
						          <i class="fa fa-pencil"></i></a>
						           <a href="${pageContext.request.contextPath}/ti/TiDelete/${ExamTi.examTiId}" role="button" data-toggle="modal" onclick="return disp_confirm()"> 
						         <i class="fa fa-trash-o" onclick="disp_confirm()"></i></a>
						      </td> --%>
			                </tr> 
						  </c:forEach>
		
	       
	
	<tr>
		<td colspan="9">
<%-- 			<jsp:include page="/template/page.jsp">
				<jsp:param value="Grade" name="url"/>
				<jsp:param value="${page.totalSize }" name="items"/>
				<jsp:param value="${page.pageSize }" name="pageSize"/>
			</jsp:include> --%>
		</td>
	</tr>

  </tbody>
</table>



    
  
</body></html>

















