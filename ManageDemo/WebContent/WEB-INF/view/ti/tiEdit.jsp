<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!doctype html>
<html lang="en"><head>
    <title>题目修改页面</title>
</head>
<body class=" theme-blue">
    	<div class="main-content clearfix">	     
			<div class="row clearfix">
				<form:form id="userForm" method="post" action="${pageContext.request.contextPath}/ti/TiEdit/${tiVO.examTiId}" modelAttribute="tiVO">
		         	<div class="form-group">
			        	<label class="col-sm-2 control-label"><spring:message code="ti.subjectid"/><form:errors path="examSubjectId" cssStyle="color:red" cssClass="error"/></label>
			        	<form:input path="examSubjectId" cssClass=" form-control required" />
			       	 	<!-- <input  id="userName" type="text" name="userName" class="form-control" > --> 
			        </div> 
<%-- 			        <div class="form-group">
			        	<label class="col-sm-2 control-label">examTiId<form:errors path="examTiId" cssStyle="color:red" cssClass="error"/></label>
			        	<form:input path="examTiId" cssClass=" form-control required" />
			       	 	<!-- <input  id="userName" type="text" name="userName" class="form-control" > --> 
			        </div> --%>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label"><spring:message code="ti.name"/><form:errors path="examTiName" cssStyle="color:red" cssClass="error"/></label>
			        	<form:input path="examTiName" cssClass=" form-control required" />
			       	 	<!-- <input  id="userName" type="text" name="userName" class="form-control" > --> 
			        </div>
			        <br/>
			        <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.optiona"/><form:errors path="examTiOptiona" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiOptiona" cssClass="form-control required" />
			       </div>
			        <br/>
			        <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.optionb"/><form:errors path="examTiOptionb" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiOptionb" cssClass="form-control required" />
			       </div>
			        <br/>
			        <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.optionc"/><form:errors path="examTiOptionc" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiOptionc" cssClass="form-control required" />
			       </div>
			        <br/>
			        <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.optiond"/><form:errors path="examTiOptiond" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiOptiond" cssClass="form-control required" />
			       </div>
			        <br/>
			        <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.key"/><form:errors path="examTiKey" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiKey" cssClass="form-control required" />
			       </div>
			        <br/>
			       <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.point"/><form:errors path="examTiPoint" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiPoint" cssClass="form-control required" />
			       </div>
			        <br/>
			       <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.difficulty"/><form:errors path="examTiDifficulty" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiDifficulty" cssClass="form-control required" />
			       </div>
			        <br/>
			       <div class="form-group">
			            <label class="col-sm-4 control-label"><spring:message code="ti.type"/><form:errors path="examTiType" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTiType" cssClass="form-control required" />
			       </div>
			        <br/>
			 	   <div>
			             <button class="btn btn-primary" type="submit">Save</button>
			             <button class="btn btn-default" onclick="history.go(-1)">Cancel</button>
			       </div>
			        <br/>
			       </form:form>
			       <%-- </form> --%>
			</div> 
		</div>
		<div>
		</div>
<script>
  $(function() {

    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });

  });
  </script>
<script type="text/javascript">
	$().ready(function() {
		
	 	$("#userForm").validate({
	 		errorPlacement: function(error, element) {  
	 		    error.appendTo(element.parent());  
	 		}
	 	});
	
	});
	jQuery.extend(jQuery.validator.messages, {
	    required: "必选字段",
		remote: "请修正该字段",
		email: "请输入正确格式的电子邮件",
		url: "请输入合法的网址",
		date: "请输入合法的日期",
		dateISO: "请输入合法的日期 (ISO).",
		number: "请输入合法的数字",
		digits: "只能输入整数",
		creditcard: "请输入合法的信用卡号",
		equalTo: "请再次输入相同的值",
		accept: "请输入拥有合法后缀名的字符串",
		maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
		minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
		rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
		range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		max: jQuery.validator.format("请输入一个最大为{0} 的值"),
		min: jQuery.validator.format("请输入一个最小为{0} 的值")
	});


</script>
</body>
</html>
