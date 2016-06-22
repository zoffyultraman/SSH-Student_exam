<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Spring MVC Demo</title>
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
</head>
<body class=" theme-blue">
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
  
    	<div class="main-content clearfix">
	           <div class="btn-toolbar list-toolbar">
				    <button class="btn btn-primary" onclick=javascrtpt:addTeacher()>New User</button>
				    <button class="btn btn-default" onclick=javascript:Account()> Administration account</button>
				  <div class="btn-group">
				  </div>
			</div>
			<div class="row clearfix">
			        <div class="panel panel-default">
			            <div class="panel-heading no-collapse">User List</div>
			            <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <th>Teacher_name</th>
			                  <th>Teacher_number</th>
			                  <th>Teacher_password</th>
			                  <th style="width: 3.5em;"></th>
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${ page.dates}" var="ExamTeacher">
			               <tr>
			                  <td>${ExamTeacher.examTeacherName} </td>
			                  <td>${ExamTeacher.examTeacherNumber} </td>
			                  <td>${ExamTeacher.examTeacherPassword} </td>
			                  <td>
						          <a href="${pageContext.request.contextPath}/users/edit/${user.userId}"><i class="fa fa-pencil"></i></a>
						          <a href="${pageContext.request.contextPath}/teacher/TeacherDelete/${ExamTeacher.examTeacherId}" role="button" data-toggle="modal" onclick="return disp_confirm()"><i class="fa fa-trash-o"></i></a>
						      </td>
			                </tr> 
						  </c:forEach>
						  
						  <tr>
				 			<td colspan="7">
					 			<jsp:include page="/template/page.jsp">
									<jsp:param name="url" value="userList"/>  
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