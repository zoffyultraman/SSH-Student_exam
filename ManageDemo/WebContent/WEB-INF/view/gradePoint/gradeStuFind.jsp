<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印页面</title>
</head>
<body>
<style type="text/css" media=print>
.noprint{display : none }
</style>
<center>
<span id='div1'>
<center>
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
 
</span>
<p class="noprint">
<input id="btnPrint" type="button" value="打印" onclick="javascript:window.print();" />
</p>
</center>
</body>
</html>