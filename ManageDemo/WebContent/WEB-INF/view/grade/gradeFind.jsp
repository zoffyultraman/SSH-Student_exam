<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印页面/title>
</head>
<body>

   <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <th>科目编号</th>
			                  <th>科目</th>
			                  <th>学生学号</th>
			                  <th>学生姓名</th>
			                  <th>考试时间</th>
			                  <th>考试成绩</th>
			                  <th style="width: 3.5em;"></th>
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${list}" var ="gradeVO">
			               <tr> 
			                  <td>${gradeVO.exam_subject_id}</td>
			                  <td>${gradeVO.exam_subject_name} </td>
			                  <td>${gradeVO.exam_stu_number} </td>
			                  <td>${gradeVO.exam_stu_name} </td>
			                  <td>${gradeVO.exam_grade_time} </td>
			                  <td>${gradeVO.exam_grade_point }</td>
			                  <td>
						          <a href="${pageContext.request.contextPath}/ti/TiEdit/${ExamTi.examTiId}">
						          <i class="fa fa-pencil"></i></a>
						           <a href="${pageContext.request.contextPath}/ti/TiDelete/${ExamTi.examTiId}" role="button" data-toggle="modal" onclick="return disp_confirm()"> 
						         <i class="fa fa-trash-o" onclick="disp_confirm()"></i></a>
						      </td>
			                </tr> 
						  </c:forEach>
	
	
	<tr>
		<td colspan="9">
<%-- 			<jsp:include page="/template/page.jsp">
				<jsp:param value="Grade" name="url"/>
				<jsp:param value="${page.totalSize }" name="items"/>
				<jsp:param value="${page.pageSize }" name="pageSize"/>
			</jsp:include> --%>
		</td>
	</tr>
  </tbody>
</table>

</body>
</html>