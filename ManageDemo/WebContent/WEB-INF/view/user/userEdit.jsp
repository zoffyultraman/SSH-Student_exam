<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!doctype html>
<html lang="en"><head>
    <title>User Management</title>
</head>
<body class=" theme-blue">
    	<div class="main-content clearfix">	     
			<div class="row clearfix">
				<form:form id="userForm" method="post" action="${pageContext.request.contextPath}/users/edit/${userVO.userId}" modelAttribute="userVO">
				<%-- <form id="tab" action="${pageContext.request.contextPath}/users/edit/${userVO.userName}" method="post"> --%>
			        <div class="form-group">
			        	<label class="col-sm-4 control-label">Username</label><form:errors path="userName" cssStyle="color:red" />
			       	 	<%-- <input  type="text" name="userName" value="${userVO.userName}" class="form-control" readonly>  --%>
			       	 	<form:input path="userName" cssClass="form-control" readonly="true"/>
			        </div>
			        <div class="form-group">
			        <label class="col-sm-1 control-label">Sex</label><form:errors path="password" cssStyle="color:red" />
			       <%--  <input type="text" name="password"  value="${userVO.password}" class="form-control" readonly> --%>
			        <form:radiobutton path="sex" value="M" />Male <form:radiobutton path="sex" value="F"/>Female 
			        <%-- <form:input path="password" cssClass="form-control" readonly="true"/> --%>
			        </div>
			        <div class="form-group">
			        <label class="col-sm-6 control-label">Age</label><form:errors path="age" cssStyle="color:red" />
			        <%-- <input type="text" name="age" value="${userVO.age}" class="form-control"> --%>
			         <form:input path="age" cssClass="form-control {required:true, min:1, max:180, digits:true}"  />
			        </div>
			        <div class="form-group">
			        <label class="col-sm-6 control-label">Email</label><form:errors path="email" cssStyle="color:red" />
			        <%-- <input type="text" name="email" value="${userVO.email}" class="form-control"> --%>
			        <form:input path="email" cssClass="form-control required email"  />
			        </div>
			        <div class="form-group">
			        <label class="col-sm-2 control-label">Role Name</label><form:errors path="email" cssStyle="color:red" />
			        <form:select path="roleId" items="${roleList}" cssClass="form-control"/>
			        </div>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label">Remark</label><form:errors path="remark" cssStyle="color:red" />
			        	<form:input path="remark" cssClass="form-control "  />
			        </div>
			 		<div>
			              <button class="btn btn-primary" type="submit">Update</button>
			              <button class="btn btn-default" onclick="history.go(-1)">Cancel</button>
			          </div>
			     </form:form>
			       <%-- </form> --%>
			</div> 
		</div>
		<div>
		</div>
		
<script type="text/javascript">
	$().ready(function() {
		
	 	$("#userForm").validate({
	 		errorPlacement: function(error, element) {  
	 		    error.appendTo(element.prev());  
	 		}
	 	});
	
	});


</script>
</body>
</html>
