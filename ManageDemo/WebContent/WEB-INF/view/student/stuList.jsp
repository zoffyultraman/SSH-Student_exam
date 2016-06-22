<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
  
  
</script>
<script>
$(document).ready(function(){
	for(var i=1;i<6;i++){
	if($("#done"+i).text()==1){
		$("#done"+i).text("考试已开始");
	}else{
		$("#done"+i).text("考试已结束");
	}
	}
})
</script>
</head>
<body class=" theme-blue">
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
  
    	<div class="main-content clearfix">
	           <div class="btn-toolbar list-toolbar">
				    <button class="btn btn-primary" onclick=javascrtpt:add()>New User</button>
				    <button class="btn btn-default">Export</button>
				  <div class="btn-group">
				  </div>
			</div>
			<div class="row clearfix">
			        <div class="panel panel-default">
			            <div class="panel-heading no-collapse">Student List</div>
			            <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <th><spring:message code="stu.name"/></th>
			                  <th><spring:message code="stu.number"/></th>
			                  <th><spring:message code="stu.sex"/></th>
			                  <th><spring:message code="stu.birthday"/></th>
			                  <th><spring:message code="stu.tel"/></th>
			                  <th><spring:message code="stu.address"/></th>
			                  <th><spring:message code="stu.done"/></th>

			                  <th style="width: 3.5em;"></th>
			                </tr>
			              </thead>
			              <tbody><%int i=0; %>
			              <c:forEach items="${page.dates}" var="ExamStu">
			               <tr><%i=i+1; %>
			                  <td>${ExamStu.examStuName} </td>
			                  <td>${ExamStu.examStuNumber} </td>
			                  <td>${ExamStu.examstuSex} </td>
			                  <td>${ExamStu.examStuBirthday} </td>
			                  <td >${ExamStu.examStuTel} </td>
			                  <td >${ExamStu.examStuAddress} </td>
			                  <td id="done<%=i%>">${ExamStu.examStuDone}</td>
			                  <td>
						          <a href="${pageContext.request.contextPath}/student/StudentEdit/${ExamStu.examStuId}">
						          <i class="fa fa-pencil"></i></a>
						           <a href="${pageContext.request.contextPath}/student/StudentDelete/${ExamStu.examStuId}" role="button" data-toggle="modal" onclick="return disp_confirm()"> 
						         <i class="fa fa-trash-o" onclick="disp_confirm()"></i></a>
						      </td>
			                </tr> 
						  </c:forEach>
						  
						  <tr>
				 			<td colspan="7">
					 			<jsp:include page="/template/page.jsp">
									<jsp:param name="url" value="Student"/>  
								    <jsp:param name="items" value="${page.totalSize}"/> 
								     <jsp:param name="pageSize" value="${page.pageSize}"/>  
								</jsp:include>  
				 		   </td>
				 		</tr>
			              </tbody>
			            </table>
			        </div>
			</div> 
		</div>
		
		<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		        <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		            <h3 id="myModalLabel">Delete Confirmation</h3>
		        </div>
		        <div class="modal-body">
		            <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the user?<br>This cannot be undone.</p>
		        </div>
		        <div class="modal-footer">
		            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
		            <button class="btn btn-danger" data-dismiss="modal" type="submit" formaction="${pageContext.request.contextPath}/users/delete/${user.userName}">Delete</button>
		        </div>
		      </div>
		    </div>
		</div>


   
</body>
</html>