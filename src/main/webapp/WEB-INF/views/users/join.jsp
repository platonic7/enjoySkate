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
<!-- 
<table>
  <tr>
    <th>Email</th>
    <th>Password</th>
    <th>Name</th>
    <th>Quiz</th>
    <th>QuizResult</th>
  </tr>
  <tr>
    <td><input type="text" id="userEmail"></td>
    <td><input type="text" id="userPassword"></td>
    <td><input type="text" id="name"></td>
    <td><input type="text" id="quiz"></td>
    <td><input type="text" id="quizResult"></td>
  </tr>
</table>

<button id="saveBt" class="btn btn-success">Save user</button>

<br /><hr /><br />
<label>로그인 아이디</label>
<input id="loginid" name="loginid" type="text" />
<input id="loginidcheck" type="button" value="아이디 중복검사" /> -->


     <div class="container">
        <h1>&nbsp;&nbsp;Sign Up!</h1>
        <form class="form-register" name='loginForm' >
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Email</label>
            <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="Email address" required autofocus size="35">
          </div>
          <div class="form-group has-error">
            <label class="control-label" for="inputError">Password</label>
            <input type="password" class="form-control" placeholder="Password" id="userPassword" required>
          </div>
          <div class="form-group has-warning">
            <label class="control-label" for="inputWarning">Name</label>
            <input type="text" class="form-control" placeholder="Name" id="name" required>
          </div>
          <div class="form-group has-warning">
            <label class="control-label" for="inputWarning">Password Quiz</label>
            <input type="text" class="form-control" placeholder="Password Quiz" id="quiz" required>
          </div>
          <div class="form-group has-error">
            <label class="control-label" for="inputError">Quiz Result</label>
            <input type="text" class="form-control" id="quizResult" placeholder="Quiz Result" required>
          </div>
          
        </form>
        </div>
   <div class="container" style="position: relative; right: 420px; width:200px;">
      <button id="saveBt" class="btn btn-lg btn-block btn-info">Sign Up</button>
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
    				alert("가입처리는 24시간내에 승인처리 완료됩니다. ^^"); 
    				location.href="/login";
    			});
    	  });
      });
      </script>
</body>
</html>