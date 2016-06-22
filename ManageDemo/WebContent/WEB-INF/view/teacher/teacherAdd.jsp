<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
	
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>教师信息增加</title>
</head>
<body class=" theme-blue">
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
  
    	<div class="main-content clearfix">	     
			<div class="row clearfix">
				<form:form method="post" action="${pageContext.request.contextPath}/teacher/TeacherAdd" modelAttribute="teacherVO" id="userForm">
				<!-- <form id="tab" action="${pageContext.request.contextPath}/users/add" method="post"> -->
			        <div class="form-group">
			        	<label class="col-sm-2 control-label">教师姓名<form:errors path="examStuName" cssStyle="color:red" cssClass="error"/></label>
			        	<form:input path="examTeacherName" cssClass=" form-control required" />
			       	 	<!-- <input  id="userName" type="text" name="userName" class="form-control" > --> 
			        </div>
			        <div class="form-group">
			            <label class="col-sm-4 control-label">教师号码<form:errors path="examStuNumber" cssStyle="color:red" cssClass="error"/></label>
			            <form:input path="examTeacherNumber" cssClass="form-control required" />
			       </div>
			        
			        <div class="form-group">
			        <label class="col-sm-4 control-label">教师密码</label><form:errors path="examStuPassword" cssStyle="color:red" />
			        <!-- <input id="password" type="text" name="password"  class="form-control" > -->
			        <form:password path="examTeacherPassword"  cssClass="form-control {required:true,minlength:3}"/>
			        </div>

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
<script>
  $(function() {

    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });

  });
  </script>
<script type="text/javascript">
		
	 $("#userForm").validate({
		 errorPlacement: function(error, element) {  
			    error.appendTo(element.parent());  
			}
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
