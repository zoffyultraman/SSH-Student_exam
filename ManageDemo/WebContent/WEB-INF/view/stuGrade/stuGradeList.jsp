<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>

<html lang="en"><head>
    <meta charset="utf-8">
    <title>学生查看考试成绩</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/style.css">

<style type="text/css">

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

  
  
  
</script>
<script>
 $(window).load(function() {
	  var bb=document.getElementsByName("Number");
	  var uname=document.getElementById("panduan").value;
	  var SS=uname;
      if(SS==2){
    	 $(".stuhidden").css({"display":"none"});
    	 $(".stuhidden2").css({"display":"none"});
     }
	  
}) 
</script>

</head>
<body class=" theme-blue" onload="IJSP()">
 
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

        </div>
        
        
        <div class="search-well">
              <form class="form-inline">
               <%--  <div class="equaltext" style="width:100px" >学生姓名:</div>
                <div class="equaltable" style="margin-right:10px"><%=request.getAttribute("stuName") %></div> --%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/gradePoint/GradeStuPrint">成绩打印</a>
              </form>
        </div>
            
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
			                  <th>学员学号</th>
			                  <th>姓名</th>
			                  <th>考试科目编号</th>
			                  <th>科目名称</th>
			                  <th>参加考试日期</th>
			                  <th>学员得分</th>
			                 <!--  <th></th>
			                  <th style="width: 3.5em;"></th> -->
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${list}" var ="gradeVO">
			               <tr> 
			                  <td>${gradeVO.examStuNumber}</td>
			                  <td>${gradeVO.examStuName} </td>
			                  <td>${gradeVO.examSubjectTnumber} </td>
			                  <td>${gradeVO.examSubjectName} </td>
			                  <td>${gradeVO.examGradeTime}</td>
			                  <td>${gradeVO.examGradePoint} </td>
			                </tr> 
						  </c:forEach>
	
	
	<tr>
<%-- 		<td colspan="9">
			<jsp:include page="/template/page.jsp">
				<jsp:param value="Grade" name="url"/>
				<jsp:param value="${page.totalSize }" name="items"/>
				<jsp:param value="${page.pageSize }" name="pageSize"/>
			</jsp:include>
		</td> --%>
	</tr>
  </tbody>
</table> 
 		<%

		Integer panduan=(Integer)session.getAttribute("panduan");
		%> 
 <input type="hidden"  value="<%=panduan %>" id="panduan"/>

    
  
</body></html>