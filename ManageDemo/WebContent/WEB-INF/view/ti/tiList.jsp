<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理考试题</title>
<style type="text/css">
.ni{
height:60px;
width:220px;
overflow:scroll;
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
<script type="text/javascript">
$(document).ready(function(){
	
/* var haha=document.getElementById("SendTextArea").value; */
/* var haha=$('#SendTextArea').val();
alert($('#SendTextArea').val());
haha=haha.replace("<br/>","/n"); */
/* alert(haha); */
})
	
</script>
</head>
<body class=" theme-blue">
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
       <form class="form-inline" method="post" style="margin-top:0px;"  action="${pageContext.request.contextPath}/grade/GradeFind" >
                    <input class="input-xlarge form-control" placeholder="Search Help..." id="appendedInputButton" name="num" value="${num }" type="text">
                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i> Go</button>
       </form>
    	<div class="main-content clearfix">
	           <div class="btn-toolbar list-toolbar">
				    <button class="btn btn-primary" onclick=javascrtpt:addTi()>New User</button>
				    <button class="btn btn-default">Export</button>
				  <div class="btn-group">
				  </div>
			</div>
			<div class="row clearfix">
			        <div class="panel panel-default">
			            <div class="panel-heading no-collapse">Ti List</div>
			            <table class="table table-bordered table-striped">
			              <thead>
			                <tr>
			                  <th>科目编号</th>
			                  <th>题目编号</th>
			                  <th>题目内容</th>
			                  <th>正确答案</th>
			                  <th>分数</th>
			                  <th>题目难度</th>
			                  <th style="width: 3.5em;"></th>
			                </tr>
			              </thead>
			              <tbody>
			              <c:forEach items="${page.dates}" var="ExamTi">
			               <tr>
			                  <td>${ExamTi.examSubjectId} </td>
			                  <td>${ExamTi.examTiId}</td>
			                  <td>${ExamTi.examTiName}</td>
			                  <td>${ExamTi.examTiKey}</td>
			                  <td>${ExamTi.examTiPoint}</td>
			                  <td>${ExamTi.examTiDifficulty}</td>
			                  <td>
						          <a href="${pageContext.request.contextPath}/ti/TiEdit/${ExamTi.examTiId}">
						          <i class="fa fa-pencil"></i></a>
						           <a href="${pageContext.request.contextPath}/ti/TiDelete/${ExamTi.examTiId}" role="button" data-toggle="modal" onclick="return disp_confirm()"> 
						         <i class="fa fa-trash-o" onclick="disp_confirm()"></i></a>
						      </td>
			                </tr> 
						  </c:forEach>
						  
						  <tr>
				 			<td colspan="7">
					 			<jsp:include page="/template/page.jsp">
									<jsp:param name="url" value="Ti"/>  
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