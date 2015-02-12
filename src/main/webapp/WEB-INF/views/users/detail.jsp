<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="true" %>
<!DOCTYPE html >
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Join</title>
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="/resources/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/resources/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/flat_ui_pro/respond.min.js"></script>
	
	<link rel="shortcut icon" href="/resources/image/skateboard.png">
	<link href="/resources/flat_ui_pro/flat-ui-pro.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/resources/bootstrap/join.css">
    <link href="/resources/HTML/UI/Flat-UI-Pro-1.3.2/dist/css/flat-ui-pro.css" rel="stylesheet">
	
		
	
</head>
<body>
     <div class="container">
        <h1>&nbsp;&nbsp;Change your Account!</h1>
        <form class="form-register" name='loginForm' >
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess"><h3>${user.email}</h3></label>
            <input type="hidden" class="form-control" id="userEmail" name="userEmail" value="${user.email}" placeholder="Email address" required >
          </div>
          <div class="form-group has-error">
            <label class="control-label" for="inputError">Password</label>
            <input type="password" class="form-control" placeholder="Password" value="${user.password}" id="userPassword" required autofocus size="35">
          </div>
          <div class="form-group has-warning">
            <label class="control-label" for="inputWarning">Name</label>
            <input type="text" class="form-control" placeholder="Name" id="name" value="${user.username}" required>
          </div>
          <div class="form-group has-warning">
            <label class="control-label" for="inputWarning">Password Quiz</label>
            <input type="text" class="form-control" placeholder="Password Quiz" id="quiz" value="${user.quiz}" required>
          </div>
          <div class="form-group has-error">
            <label class="control-label" for="inputError">Quiz Result</label>
            <input type="text" class="form-control" id="quizResult" placeholder="Quiz Result" value="${user.quizResult}" required>
          </div>
          
        </form>
        </div>
   <div class="container" style="position: relative; right: 420px; width:200px;">
      <button id="saveBt" class="btn btn-lg btn-block btn-info">SAVE</button>
   </div>
   
<br /><br /><br />
<jsp:include page="../jspinclude/footer.jsp" flush="false" />

      <script type="text/javascript">
      $(function(){
    	  $('#saveBt').click(function (){
    		  var email = $('#userEmail').val();
    		  var password = $('#userPassword').val();
    		  var name = $('#name').val();
    		  var quiz = $('#quiz').val();
    		  var quizResult = $('#quizResult').val();
    		  if(email == null || email == "" || password == null || password == "" || 
    				  name == null || name == "" || quiz == null || quiz == "" || quizResult == null || quizResult == "") {
    					alert("Please Fill All Required Field");
    			      	return false;
    		  }
    		  $.ajax({
    			  url: "/users",
    			  type: "POST",
    			  data: { 'email' : email, 'password' : password, 'username' : name, 'quiz' : quiz, 'quizResult' : quizResult},
    			  dataType: "json"
    			}).done(function(data){
    				alert("회원정보 변경이 완료되었습니다."); 
    				location.href="/login";
    			});
    	  });
      });
      </script>
</body>
</html>