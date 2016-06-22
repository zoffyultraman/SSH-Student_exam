<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %> 
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/premium.css">
        <script src="${pageContext.request.contextPath}/lib/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/jquery.metadata.js" type="text/javascript"></script>

        <style type="text/css">
        input.error { border: 1px solid red; }
        
		label.error {
		  background:url("./demo/images/unchecked.gif") no-repeat 0px 0px;
		
		  padding-left: 16px;
		
		  padding-bottom: 2px;
		
		  font-weight: bold;
		
		  color: #EA5200;
		}
    </style>
</head>
 <c:if test="${not empty message}">
    <div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
</c:if>
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

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
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
    </style>

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
   <!--  <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png"> -->
  <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>
  
  <div class="dialog">
  	<div class="panel panel-default">
        <p class="panel-heading no-collapse">Sign In</p>
        <div class="panel-body">
        	<form:form method="post" action="${pageContext.request.contextPath}/login" modelAttribute="userVO" id="userForm">
            <%-- <form action="${pageContext.request.contextPath}/login" method="post"> --%>
                <div class="form-group">
                    <label>Username</label>
                    <form:input path="examStuNumber" cssClass="form-control span12 required" />
                    <form:errors path="examStuNumber" cssStyle="color:red" cssClass="error"/>
                    <!-- <input id="userName" name="userName" type="text" class="form-control span12"> -->
                </div>
                <div class="form-group">
                	<label>Password</label>
                	<form:password path="examStuPassword"  class="form-control span12 required"/>
                	<form:errors path="examStuPassword" cssStyle="color:red" cssClass="error"/>
                   <!--  <input id="password" name="password"  type="password" class="form-control span12 form-control"> -->
                </div>
                <div class="form-group">
                   <label>character</label>
                
                   <select class="form-control span12" name="character" >
                       <option value="student" name="student">student</option>
                       <option value="teacher" name="teacher">teacher</option>
                   </select>
                
                
                
                </div>
                <button type="submit" class="btn btn-primary pull-right"> Sign In</button>
                <label class="remember-me"><input type="checkbox"> Remember me</label>
                <div class="clearfix"></div>
            <%-- </form> --%>
            </form:form>
        </div>
    </div>  
  </div>
    <script type="text/javascript">
	 $("#userForm").validate({
		 errorPlacement: function(error, element) {  
			    error.appendTo(element.prev());  
			}
	 });
	 jQuery.extend(jQuery.validator.messages, {
		    required: "必选字段",
			remote: "请修正该字段",

			maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
			minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),

		});
</script>
<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
</script>
</body>
</html>