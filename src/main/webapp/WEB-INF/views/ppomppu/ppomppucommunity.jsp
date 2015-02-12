<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />

    <div class="container">
      <h4><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/paper-bag.svg" style="max-width: 2.7%; alt="" />&nbsp;&nbsp;PPOMPPU</h4>
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
              <c:forEach items="${ppomppuBoardList}" var="ppomppuBoard">
			   <tr>
			     <td>${ppomppuBoard.id}</td>
			     <td><a href="/ppomppu/${ppomppuBoard.id}/content" >${ppomppuBoard.title} </a></td>
			     <td>${ppomppuBoard.user.username}</td>
			     <td>${ppomppuBoard.updatedTime}</td>
              </tr>
			   </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div><!-- /.container -->	
    <div><img src="assets/img/icons/android.svg" alt="" /></div>
	
		<a href="/ppomppu/write" class="btn btn-primary" style="position: absolute; right: 110px; margin: 12px  0px  0px  0px ;">WRITE</a>
		<!-- <br />
		<br />
		<a href="/boards/write" class="btn btn-success" style="position: absolute; right: 110px; margin: 12px  0px  0px  0px ;">WRITE</a> -->
		
<br /><br /><br />

<div class="container">
  <h4><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/paper-bag.svg" style="max-width: 2.7%; alt="" />&nbsp;&nbsp;PPOMPPU</h4>
      <div class="row">
	    <c:forEach items="${ppomppuBoardList}" var="ppomppuBoard">
         <div class="col-xs-6 col-md-3" >
           <a class="thumbnail" href="/ppomppu/${ppomppuBoard.id}/content">
			 <img alt="" src="<c:url value="${ppomppuBoard.imagePath }" />" >
              <center><p>${ppomppuBoard.title}</p></center>
          </a>
        </div>
     </c:forEach>
  </div>
</div>

    <script type="text/javascript" charset="utf-8">
      $(document).ready(function() {
        $('table').dataTable();
      } );
    </script>
    
  <jsp:include page="../jspinclude/footer.jsp" flush="false" />
 </body>
</html>