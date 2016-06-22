<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>role数据展示</title>
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
			            <div class="panel-heading no-collapse">User List</div>
			            <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <th>RoleName</th>
			                  <th>UPDUSER</th>
			                  <th>UPDDATE</th>

			                  <th style="width: 3.5em;"></th>
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${ page.dates}" var="role">
			               <tr>
			                  <td>${role.roleName} </td>
			                  <td>${role.updUser} </td>
			                  <td>${role.updDate} </td>
			                  <td>
						          <a href="${pageContext.request.contextPath}/users/edit/${role.roleId}"><i class="fa fa-pencil"></i></a>
						          <a href="${pageContext.request.contextPath}/users/delete/${role.roleId}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
</html>