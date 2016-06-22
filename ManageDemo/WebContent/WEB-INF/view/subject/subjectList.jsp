<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目列表</title>
<%--   <link href="${pageContext.request.contextPath}/lib/docs/css/bootstrap.min.css" rel="stylesheet"> --%>
    <link href="${pageContext.request.contextPath}/lib/docs/css/highlight.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/lib/dist/css/bootstrap3/bootstrap-switch.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/lib/docs/css/main.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/lib/docs/js/bootstrap.min.js"></script>  
    <script src="${pageContext.request.contextPath}/lib/dist/js/bootstrap-switch.js"></script>   
   
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
  
function update(e){
	var TgTagg=e.id;
	if(!e.checked){
	$.ajax({
		url:"${pageContext.request.contextPath}/subject/subjectFlag",
		dataType:"json",
		async:true,
		data:{
			flag:1,
			TgTagg:TgTagg
			},
		type: "post",
		success:function(req){
			alert("考试开始");
		}
		
		
	    
	})		
	}else{
		$.ajax({
			url:"${pageContext.request.contextPath}/subject/subjectFlag",
			dataType:"json",
			async:true,
			data:{
				flag:0,
				TgTagg:TgTagg
				
				},
			type: "post",
			beforeSend:function(){
				/* alert("beforeSend"); */
			},
			success:function(req){
				/* alert(req); */
				alert("考试关闭");
			},
			complete:function(){
				/* alert("complete"); */
			},
			error:function(){
				/* alert("error"); */
			}
			
		    
		})	
	}
}
  
</script>

<script>
    $(function(argument) {
      $('[type="checkbox"]').bootstrapSwitch();
    })
</script>
</head>
<body class=" theme-blue">
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
  
    	<div class="main-content clearfix">
	           <div class="btn-toolbar list-toolbar">
				    <button class="btn btn-primary" onclick=javascrtpt:add()>New User</button>
				    
				  <div class="btn-group">
				  </div>
			</div>
			<div class="row clearfix">
			        <div class="panel panel-default">
			            <div class="panel-heading no-collapse">Student List</div>
			            <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <th>科目编号</th>
			                  <th>科目名称</th>
			                  <th>题数</th>
			                  <th>总时间</th>
			                  <th>总分</th>
			                  <th>科目状态</th>

			                  <th style="width: 3.5em;"></th>
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${ page.dates}" var="ExamSubject">
			               <tr class="ttr">
			                  <td class="TdSubjectId">${ExamSubject.examsubjectid}</td>
			                  <td>${ExamSubject.examsubjectname} </td>
			                  <td>${ExamSubject.examsubjecttnumber} </td>
			                  <td>${ExamSubject.examsubjecttotaltime} </td>
			                  <td>${ExamSubject.examsubjectsum} </td>
			                  <td>
			                  <c:choose>
								   <c:when test="${ExamSubject.examsubjectid eq 1}">
			                         <div class="switch" data-on="primary" data-off="info" >
                                        <input type="checkbox"  id="${ExamSubject.examsubjectid}" checked onchange="update(this)" id="subjectFlag" />
                                     </div>
                                   </c:when>
                                   <c:otherwise>
                                     <div class="switch" data-on="primary" data-off="info" >
                                        <input type="checkbox"  id="${ExamSubject.examsubjectid}"  onchange="update(this)" id="subjectFlag" />
                                     </div>
                                   </c:otherwise>
                              </c:choose>
                              </td>
			                  <td>
						          <a href="${pageContext.request.contextPath}/student/StudentEdit/${ExamStu.examStuId}">
						           <i class="fa fa-pencil"></i></a>
						             <a href="${pageContext.request.contextPath}/student/StudentDelete/${ExamStu.examStuId}" role="button" data-toggle="modal" onclick="return disp_confirm()"> 
						          <i class="fa fa-trash-o" onclick="disp_confirm()"></i></a>
						      </td>
			                </tr> 
						  </c:forEach>
						   
						  
						  <tr>
				 			<td colspan="7">
					 			<jsp:include page="/template/page.jsp">
									<jsp:param name="url" value="Student"/>  
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