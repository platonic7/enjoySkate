<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />

<div class="container">
	<h6>Spots</h6>
	      <table class="table table-hover">
	        <thead>
	          <tr>
	            <th>#</th>
	            <th>TITLE</th>
	            <th>WRITER</th>
	          </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${spotList}" var="spot">
	         <tr>
	            <td>${spot.id}</td>
	            <td><a href="/spots/${spot.id}/detail" >${spot.title} </a></td>
	      	    <td>${spot.user.username}</td>	
	        </tr>   
	        </c:forEach>
	        </tbody>
	      </table>
	  </div>
	     
  <jsp:include page="../jspinclude/footer.jsp" flush="false" />
 </body>
</html>