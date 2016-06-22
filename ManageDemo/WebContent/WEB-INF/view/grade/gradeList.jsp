<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>

<html lang="en"><head>
    <meta charset="utf-8">
    <title>教师管理考试成绩</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

<style type="text/css">
.text{
   font-size:16px;
   font-weight:700;

}
</style>
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

  function addTi(){
  	window.location.href="${pageContext.request.contextPath}/ti/tiAdd";
  }

</script>
</head>
<body class=" theme-blue">
 
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success">
        <button data-dismiss="alert" class="close">×</button>${message}
    </div>
</c:if>

        <div class="header">
            <h1 class="page-title">Users</h1>
                    <ul class="breadcrumb">
            <li><a href="index.html">Home</a> </li>
            <li class="active">Users</li>
        </ul>

        </div>
        
        
        <div class="search-well">
                <form class="form-inline" method="post" style="margin-top:0px;"  action="${pageContext.request.contextPath}/grade/GradeFind" >
                    <input class="input-xlarge form-control" placeholder="请输入科目、学号、姓名、考试日期" id="appendedInputButton" name="num" value="${num }" type="text">
                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i> Go</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/gradePoint/GradePrint">成绩打印</a>
                </form>
            </div>
            
<%-- <div class="btn-toolbar list-toolbar">
    <button class="btn btn-primary"><i class="fa fa-plus"></i> <a href="${pageContext.request.contextPath}/stu/add">New User</a></button>
    <button class="btn btn-default"><a href="${pageContext.request.contextPath }/upload">Import</a></button>
    <button class="btn btn-default">Export</button>
  <div class="btn-group">
  </div>
</div>
 --%>


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


    
  
</body></html>