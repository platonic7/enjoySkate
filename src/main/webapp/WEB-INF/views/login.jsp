<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	   <title>Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
		<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	    <link rel="stylesheet" href="/resources/bootstrap/signin.css">
	    <link rel="shortcut icon" href="/resources/image/skateboard.png">
		<link href="/resources/flat_ui_pro/flat-ui-pro.min.css" rel="stylesheet">
		
	</head>
	
	    <body onload='document.loginForm.username.focus();'>

 <div class="container">
    <form class="form-signin" name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
      <h3 class="form-signin-heading">Please sign in</h3>
		
		<c:if test="${not empty error}">
     		<div class="error">${error}</div>
   		</c:if>
   		<c:if test="${not empty msg}">
     		<div class="msg">${msg}</div>
   		</c:if>
        <input type="email" class="form-control" name='username' value='' placeholder="Email address" required autofocus>
        <input type="password" class="form-control" name='password' value='' placeholder="Password" required>

        <label class="checkbox">
          <input type="checkbox" value="remember-me" checked="checked"> Remember me
		  <a href="/users/password" class="text-warning">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Forgot password?</a>
        </label>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

  <a href="/users/join" class="btn btn-lg btn-block btn-info">Sign up</a>
    </form>
 </div>
	
  </body>
</html>