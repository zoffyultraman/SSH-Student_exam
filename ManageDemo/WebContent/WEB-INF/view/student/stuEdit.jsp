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
				<form:form id="userForm" method="post" action="${pageContext.request.contextPath}/ti/TiEdit/${userVO.examStuId}" modelAttribute="userVO">
				<%-- <form id="tab" action="${pageContext.request.contextPath}/users/edit/${userVO.userName}" method="post"> --%>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label"><spring:message code="stu.name"/><form:errors path="examStuName" cssStyle="color:red" cssClass="error"/></label>
			        	<form:input path="examStuName" cssClass="form-control" disabled="disabled"  onfocus="alert('无法修改!');"  readonly="true"/>
			       	 	<!-- <input  id="userName" type="text" name="userName" class="form-control" > --> 
			        </div>
			        <div class="form-group"><a>
			            <label class="col-sm-4 control-label"><spring:message code="stu.number"/><form:errors path="examStuNumber" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examStuNumber" cssClass="form-control required" />
			        </a></div>
			        
			        <div class="form-group">
			        <label class="col-sm-4 control-label"><spring:message code="stu.password"/></label><form:errors path="examStuPassword" cssStyle="color:red" />
			        <!-- <input id="password" type="text" name="password"  class="form-control" > -->
			        <form:password path="examStuPassword"  cssClass="form-control {required:true,minlength:5}"/>
			        </div>
			        <div class="form-group">
			        <label class="col-sm-1 control-label"><spring:message code="stu.sex"/></label><form:errors path="examstuSex" cssStyle="color:red" />
			       	 <form:radiobutton path="examstuSex" value="M" /><spring:message code="stu.Male"/> <form:radiobutton path="examstuSex" value="F"/><spring:message code="stu.Female"/> 
			        </div>
			          <div class="form-group">
			             <label class="col-sm-4 control-label"><spring:message code="stu.birthday"/></label>
			             <form:input path="examStuBirthday" cssClass="form-control required" id="datepicker"/>
			          </div>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label"><spring:message code="stu.tel"/></label><form:errors path="examStuTel" cssStyle="color:red" />
			        	<form:input path="examStuTel" cssClass="form-control {required:true,minlength:11}"  />
			        </div>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label"><spring:message code="stu.address"/></label><form:errors path="examStuAddress" cssStyle="color:red" />
			        	<form:input path="examStuAddress" cssClass="form-control required"  />
			        </div>
			        <div class="form-group">
			        	<label class="col-sm-2 control-label"><spring:message code="stu.done"/></label><form:errors path="examStuDone" cssStyle="color:red" />
			        	<form:input path="examStuDone" cssClass="form-control required"  />
			        </div>
			              <button class="btn btn-primary" type="submit">Update</button>
			              <button class="btn btn-default" onclick="history.go(-1)">Cancel</button>
			          </div>
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
