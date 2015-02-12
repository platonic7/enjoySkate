<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />

<div class="container">
	<h6>News</h6>
	      <table class="table table-hover">
	        <thead>
	          <tr>
	            <th>#</th>
	            <th>TITLE</th>
	            <th>WRITER</th>
	          </tr>
	        </thead>
	        <tbody>
<%-- 	        <c:forEach items="${newsList.content}" var="news">
	         <tr>
	            <td>${news.id}</td>
	            <td><a href="/news/${news.id}/detail" >${news.title} </a></td>
	      	    <td>${news.user.username}</td>	
	        </tr>   
	        </c:forEach>
	        </tbody>
	      </table>
	     <c:if test="${!newsList.firstPage}">
	     <a href="/news?page=${newsList.number - 1 }&size=2&sort=id,desc">pre</a>
	     </c:if>
	     <c:if test="${!newsList.lastPage}">
	     <a href="/news?page=${newsList.number + 1 }&size=2&sort=id,desc">next</a>
	     </c:if>
	 </div> --%>   <!--  페이지 처리시 다시 구현 -->
	 
	 <c:forEach items="${newsList}" var="news">
	         <tr>
	            <td>${news.id}</td>
	            <td><a href="/news/${news.id}/detail" >${news.title} </a></td>
	      	    <td>${news.user.username}</td>	
	        </tr>   
	        </c:forEach>
	        </tbody>
	      </table>
	  </div>
  <jsp:include page="../jspinclude/footer.jsp" flush="false" />
  
 </body>
</html>