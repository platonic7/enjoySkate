<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<%@ page session="true" %>

<!DOCTYPE html >
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Forgot password?</title>
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
        <h1>&nbsp;&nbsp;Forgot password?</h1><br />
          <div class="form-group has-success" style="width:25%;">
            <label class="control-label" for="inputSuccess">Email</label>
            <input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="Please Enter your Email Address." required autofocus size="35">
            <button id="getQuizBt" class="btn btn-success" style="position: absolute; right: -90px; top: 40px; width:26%;">Submit</button>
          </div>
          
          <div id="quizSection" ></div>
          <div class="form-group has-warning" >
            <label class="control-label" for="inputWarning">Quiz Answer</label>
              <input type="text" style="width:25%;" class="form-control" placeholder="Please Enter your Quiz Answer." id="solution" required >
          
          		<button id="checkSolution" class="btn btn-success" style="display:inline-block; margin:-76px 0px 0px 300px">Submit</button>
 			</div>
            <div id="resultSection"></div>
          
      </div>
      <br /><br /><br />

<script type="text/javascript">
      $(function(){
    	  $('#getQuizBt').click(function (){
    		  var email = $('#userEmail').val();
    		  if(email == null || email == "") {
					alert("Please Enter your Email Address.");
			      	return false;
		  }
    		  console.log(email);
    		  $.ajax({
    			  url: "/quiz?email="+email,
    			  type: "GET",
    			  dataType: "json"
    			}).done(function(data){
    				var page = data.quiz;
    				/* $("#quizSection").html(page); */
    				$("#quizSection").html("<h3>Quiz : " +  data.quiz + "</h3>");
    			});
    	  });
    	  
    	  $('#checkSolution').click(function (){
    		  var solution = $('#solution').val();
    		  var email = $('#userEmail').val();
    		  if(solution == null || solution == "" || email == null || email == "") {
    					alert("Please Fill All Required Field");
    			      	return false;
    		  }
    		  $.ajax({
    			  url: "/quiz/check?email="+email+"&solution=" + solution,
    			  type: "GET",
    			  dataType: "json"
    			}).done(function(data){
    				if(data.result) {
    					$('#resultSection').html("<h3>정답입니다.</h3><h3>Password : " + data.passwd + "</h3>");
    				} else {
    					$('#resultSection').html("<h3>정답을 다시 확인해주세요.</h3>");
    				}
    			});
    	  });
      });
      </script>
		<jsp:include page="../jspinclude/footer.jsp" flush="false" />

	</body>
</html>