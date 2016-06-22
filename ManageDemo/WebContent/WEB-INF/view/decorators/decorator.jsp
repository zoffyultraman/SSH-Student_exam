<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    
    <!-- 从被装饰页面获取title标签内容,并设置默认值-->  
 	<title><decorator:title default="Spring MVC Demo"/></title>
    
    <!-- <title>Spring MVC Demo</title> -->
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">

    
    <script src="${pageContext.request.contextPath}/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    
    <script src="${pageContext.request.contextPath}/lib/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/jquery.metadata.js" type="text/javascript"></script>
<%--     <script src="${pageContext.request.contextPath}/lib/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script> --%> 
    <script src="${pageContext.request.contextPath}/lib/jquery-migrate-1.2.1.js" type="text/javascript"></script> 
   <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/jquery-ui.css">
   <script src="${pageContext.request.contextPath}/lib/jquery-ui.js" type="text/javascript"></script>
   
   <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js" type="text/javascript"></script>
 
     <link rel="stylesheet"  href="${pageContext.request.contextPath}/lib/examstyle.css">
    
   
   
   
   
   
<%--    <link rel="stylesheet"  href="${pageContext.request.contextPath}/lib/style1.css"> --%>
    <script type="text/javascript">
/*         $(function() {
            $(".knob").knob();
        });
   */
        function add(){
        	window.location.href="${pageContext.request.contextPath}/student/StudentAdd";
        }
        function Account(){
        	window.location.href="${pageContext.request.contextPath}/subject/Subject";
        }
        function cancel(){
        	window.location.href="${pageContext.request.contextPath}/users/userList";
        }
        
        function Grade(){
        	window.location.href="${pageContext.request.contextPath}/stuGrade/stuGradeListS";
        }
        
        function addTeacher(){
        	window.location.href="${pageContext.request.contextPath}/teacher/TeacherAdd";
        }
        
  
    </script>


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/premium.css">
    
    <!-- 从被装饰页面获取head标签内容 -->
    <decorator:head/> 
    
        <style type="text/css">
        input.error { border: 1px solid red; }
        
		label.error {
		  background:url("./demo/images/unchecked.gif") no-repeat 0px 0px;
		
		  padding-left: 16px;
		
		  padding-bottom: 2px;
		
		  font-weight: bold;
		
		  color: #EA5200;
		}
    	.teahidden5{
		   display:none;
		}
		.teahidden6{
		   display:none;
		}
    </style>
        <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
        td:hover{
        cursor:pointer;
        }
    </style>
    
</head>
<body class=" theme-blue">

    <!-- Demo page code -->
    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }
/* 
            $('[data-popover="true"]').popover({html: true}); */
            
        });
    </script>



<script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
</script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
   <%--  <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">
   --%>
   
<!-- header begin --><!--  头部 -->
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> 学生考试管理系统</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> ${sessionScope.sName}
                    <i class="fa fa-caret-down"></i>
                </a>
              <ul class="dropdown-menu">
                <li><a tabindex="-1" href="${pageContext.request.contextPath}/logout">退出</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
<!-- header end -->     

<!-- left menu begin --><!-- 左边导航部分 -->
  <div class="sidebar-nav">
   <ul><!-- 学生可视部分 -->
    <c:set var="salary" scope="session" value="${sessionScope.role}"/>
      <c:if test="${salary == 'student'}">
       <c:forEach items="${ResourceStu}" var="resource">
        <c:if test="${ resource.fathermenu == 1}">
          <li class="teahidden1">
             <a href="${ resource.URL} " data-target=".dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>${ resource.resouceName}<span class="label label-info">+3</span></a>
          </li>
     </c:if>
	</c:forEach>
	<c:forEach items="${ResourceStu}" var="resource">
        <c:if test="${ resource.fathermenu == 0}">
        <li class="teahidden2">
    	   <ul class="dashboard-menu nav nav-list collapse in">
              <li class="teahidden3"><a href="${ resource.URL}"><span class="fa fa-caret-right"></span>${ resource.resouceName}</a></li>
    	   </ul>
        </li>
    </c:if>
	</c:forEach>
  </c:if>
     
     
    <c:set var="salary" scope="session" value="${sessionScope.role}"/>
      <c:if test="${salary == 'teacher'}">
     <!-- 教师可视部分 -->
    <c:forEach items="${ResourceTea}" var="resourceTea">
     <c:if test="${ resourceTea.fathermenu == 1}">
      <li class="teahidden2">
    	   <ul class="dashboard-menu nav nav-list collapse in">
              <li class="teahidden3"><a href="${pageContext.request.contextPath}/${ resourceTea.URL}"><span class="fa fa-caret-right"></span>${ resourceTea.resouceName}</a></li>
    	   </ul>
        </li>
      </c:if>
    </c:forEach>
    <c:forEach items="${ResourceTea}" var="resourceTea">
     <c:if test="${ resourceTea.fathermenu == 0}">  
        <li class="teahidden2">
    	   <ul class="dashboard-menu nav nav-list collapse in">
              <li class="teahidden3"><a href="${pageContext.request.contextPath}/${ resourceTea.URL}"><span class="fa fa-caret-right"></span>${ resourceTea.resouceName}</a></li>
    	   </ul>
        </li>
     </c:if>
    </c:forEach>
    
    
<%--     <li id="stuhidden2" class="stuhidden2">
       <a href="${pageContext.request.contextPath}/upload" class="nav-header">
       <i class="fa fa-fw fa-briefcase"></i> 学员资料批量导入 </a>
    </li> --%>
    </c:if>

     <li class="teahidden5">
       <center><h3>考试状态：正在考试！</h3></center>
             <hr>
               <center>  
         <h2>考试剩余时间</h2>
           <div class="time-item">
	          <strong id="hour_show">0时</strong> 
	          <strong id="minute_show">0分</strong>
	          <strong id="second_show">0秒</strong>
           </div>
           </center>
         
<br>
<hr>
             
           
             
  <center><h2>考试题目如下</h2></center>
    <div class="table-responsive">
  <table class="table table-bordered" style="border:0px;font-weight:800;background:#5BC0DE"  id="div">
     <tr class="tdfont" >
       <td onclick="selectTopic(this)" id="Ti1" >1</td>
       <td onclick="selectTopic(this)" id="Ti2" >2</td>
       <td onclick="selectTopic(this)" id="Ti3">3</td>
       <td onclick="selectTopic(this)" id="Ti4">4</td>
       <td onclick="selectTopic(this)" id="Ti5">5</td>
       <td onclick="selectTopic(this)" id="Ti6">6</td>
    </tr>
    <tr class="tdfont2" >
       <td onclick="selectTopic(this)" id="Ti7">7</td>
       <td onclick="selectTopic(this)" id="Ti8">8</td>
       <td onclick="selectTopic(this)" id="Ti9">9</td>
       <td onclick="selectTopic(this)" id="Ti10">10</td>
       <td onclick="selectTopic(this)" id="Ti11">11</td>
       <td onclick="selectTopic(this)" id="Ti12">12</td>
    </tr>
    <tr class="tdfont3">
       <td onclick="selectTopic(this)" id="Ti13">13</td>
       <td onclick="selectTopic(this)" id="Ti14">14</td>
       <td onclick="selectTopic(this)" id="Ti15">15</td>
       <td onclick="selectTopic(this)" id="Ti16">16</td>
       <td onclick="selectTopic(this)" id="Ti17">17</td>
       <td onclick="selectTopic(this)" id="Ti18">18</td>
    </tr>
    <tr class="tdfont4">
       <td onclick="selectTopic(this)" id="Ti19">19</td>
       <td onclick="selectTopic(this)" id="Ti20">20</td>
    </tr> 
   <%--  <tr>
    <%for(int i=1;i<7;i++){ %>
    <td onclick="selectTopic(this)" id="Ti<%=i%>"><%=i%></td>
    <%} %>
    </tr>
    --%>
  </table>
  <br/>

  <hr>
  <p><h3>注释：红色字体为已选题目</h3></p>
  
</div>  
          
    
    
    </li>
    <li class="teahidden6">
       <a href="#" data-target=".dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>退出考试系统 <span class="label label-info">+3</span></a>
    </li>




     </ul>
    </div>










    
    
 <!-- left menu end -->
 
 
 
 
 
 
 
    <div class="content clearfix">
    	 <!-- 从被装饰页面获取body标签内容 -->  
   		 <decorator:body />
   		 
   		  
		   <footer>
		       <hr>
		       
		       dasd
		       
		       
		       
	
		       
		       
		       
		       
		       
		       <p>© 2016 <a href="http://www.zh-ite.com/" target="_blank">ITE</a></p>
		   </footer>
	</div>

    		<%
		Integer panduan=(Integer)session.getAttribute("panduan");
		%> 
 <input type="hidden"  value="<%=panduan %>" id="panduan"/>
    <script type="text/javascript">
/*         $("[rel=tooltip]").tooltip(); */
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
</body>
</html>