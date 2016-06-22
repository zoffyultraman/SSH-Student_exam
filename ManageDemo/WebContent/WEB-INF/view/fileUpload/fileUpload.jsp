<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
	
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>File Upload</title>
</head>
<body class=" theme-blue">
    	<div class="main-content clearfix">	     
			<div class="row clearfix">
				 <c:if test="${not empty message}">
				    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
				</c:if>
				<form:form method="post" action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data">
			        <div class="form-group">
					    <label for="exampleInputFile" class="control-label">选择上传文件</label>
					    <input type="file" id="exampleInputFile" name="file" class="form-control">
					  </div>
			        
			 		<div>
			              <button class="btn btn-primary" type="submit">Upload</button>
			             <button class="btn btn-default" onclick="history.go(-1)">Cancel</button>
			          </div>
			          </form:form>
			</div> 
		</div>
		<div>
		</div>
</body>
</html>
