<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
	
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>User management</title>
</head>
<body class=" theme-blue">
    	<div class="main-content clearfix">	     
			<div class="row clearfix">
				<form:form method="post" action="${pageContext.request.contextPath}/users/add" modelAttribute="usersVO" id="userForm">
				<!-- <form id="tab" action="${pageContext.request.contextPath}/users/add" method="post"> -->
			        <div class="form-group">
			        	<label class="col-sm-4 control-label"><spring:message code="website.username" /><form:errors path="userName" cssStyle="color:red" cssClass="error"/></label>
			        	<form:input path="userName" cssClass="form-control " />
			       	 	<!-- <input  id="userName" type="text" name="userName" class="form-control" > --> 
			        </div>
			        <div class="form-group">
			        <label class="col-sm-4 control-label">Password</label><form:errors path="password" cssStyle="color:red" />
			        <!-- <input id="password" type="text" name="password"  class="form-control" > -->
			        <form:password path="password"  cssClass="form-control {required:true,minlength:5}"/>
			        </div>
			        <div class="form-group">
			        <label class="col-sm-1 control-label">Sex</label><form:errors path="password" cssStyle="color:red" />
			       	 <form:radiobutton path="sex" value="M" />Male <form:radiobutton path="sex" value="F"/>Female 
			        </div>
			        <div class="form-group">
			        <label class="col-sm-5 control-label">Age</label><form:errors path="age" cssStyle="color:red" />
			        <!-- <input id="age" type="text" name="age" class="form-control"> -->
			        <form:input path="age" cssClass="form-control {required:true, min:1, max:180, digits:true}" />
			        </div>
			        <div class="form-group">
			        <label class="col-sm-4 control-label">Email</label><form:errors path="email" cssStyle="color:red " />
			        <!-- <input id="email" type="text" name="email" class="form-control"> -->
			        <form:input path="email" cssClass="form-control required email" />
			        </div>
			        <div class="form-group">
			        <label class="col-sm-2 control-label">Role Name</label><form:errors path="email" cssStyle="color:red" />
			        <form:select path="roleId" items="${roleList}" cssClass="form-control"/>
			        </div>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label">Remark</label><form:errors path="remark" cssStyle="color:red" />
			        	<form:input path="remark" cssClass="form-control"  />
			        </div>
	<%-- 		        
			        <div class="form-group">
			        	<label class="col-sm-2 control-label">BirthDay</label><form:errors path="remark" cssStyle="color:red" />
			        	<form:input path="birthDay" cssClass="form-control" id="birthDay" />
			        </div>
			         --%>
			 		<div>
			              <button class="btn btn-primary" type="submit">Save</button>
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
		$("#birthDay").datepicker();
		$("#birthDay").datepicker('option',"dateFormat","yy-mm-dd" )
		
	 $("#userForm").validate({
		 errorPlacement: function(error, element) {  
			    error.appendTo(element.prev());  
			}
	 });
	});

</script>	
</body>
</html>
