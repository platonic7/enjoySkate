<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../../jspinclude/topBar.jsp" flush="false" />
<jsp:include page="../../jspinclude/adminTopBar.jsp" flush="false" />

<div class="container">
	<h6>News Custom</h6>
      <table class="table table-hover">
        <thead>
          <tr>
            <th>#</th>
            <th>TITLE</th>
            <th>WRITER</th>
    		<th>UPDATE</th>
            <th>DELETE</th>
          </tr>
        </thead>
	        <tbody>
		        <c:forEach items="${newsList}" var="news">
		         <tr>
		            <td>${news.id}</td>
		            <td><a href="/news/${news.id}/detail" >${news.title} </a></td>
		      	    <td>${news.user.username}</td>
		      		<td><a href="/admin/${news.id}/update" class="btn btn-success">UPDATE</a></td>
		      	    <td><a href="/admin/${news.id}/delete" class="btn btn-danger">DEL</a></td>
		        </tr>   
		        </c:forEach>
	        </tbody>
      </table>
     </div>
  	<jsp:include page="../../jspinclude/footer.jsp" flush="false" />
 </body>
</html>