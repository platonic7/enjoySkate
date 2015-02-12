<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />

    <div class="container">
      <h4><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/money.svg" style="max-width: 2.7%; alt="" />&nbsp;&nbsp;BUY & SELL</h4>
      <div class="row">
        <div class="col-md-12">
          <table class="table table-striped table-bordered">
            <thead>
              <tr>
                <th>#</th>
			    <th>TITLE</th>
                <th>NAME</th>
			    <th>TIME</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${buyBoardList}" var="buyBoard">
			   <tr>
			     <td>${buyBoard.id}</td>
			     <td><a href="/buyandsell/${buyBoard.id}/content" >${buyBoard.title} </a></td>
			     <td>${buyBoard.user.username}</td>
			     <td>${buyBoard.updatedTime}</td>
              </tr>
			   </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div><!-- /.container -->	
    <div><img src="assets/img/icons/android.svg" alt="" /></div>
	
		<a href="/buyandsell/write" class="btn btn-primary" style="position: absolute; right: 110px; margin: 12px  0px  0px  0px ;">WRITE</a>
		<!-- <br />
		<br />
		<a href="/boards/write" class="btn btn-success" style="position: absolute; right: 110px; margin: 12px  0px  0px  0px ;">WRITE</a> -->
		

    <script type="text/javascript" charset="utf-8">
      $(document).ready(function() {
        $('table').dataTable();
      } );
    </script>
    
  <jsp:include page="../jspinclude/footer.jsp" flush="false" />
 </body>
</html>