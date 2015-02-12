<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />

<div class="container">
	 <form action="/newsCommentUpdate" method="post" >
	<table>
		<tr>
	  			<td><input name="newsId" type="hidden" value="${news.id}"></td>
	  			<td><input name="id" type="hidden" value="${boardComment.id}"></td>
	            <td><textarea style="width:500%; height:100;" rows="3" name="content"   placeholder="Add comment..." class="form-control" >${boardComment.content}</textarea></td>
	   			<td><button id="getQuizBt" class="btn btn-success" style="display:inline-block; right: 1px; margin: 0px  0px  0px  820px ; top: 0px; width:13%; height:50%">Submit</button><td>
	   	</td>		
	</table>
	</form>
</div>

<jsp:include page="../jspinclude/footer.jsp" flush="false" />

</body>
</html>