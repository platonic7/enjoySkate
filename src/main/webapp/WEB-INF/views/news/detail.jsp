<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />

<center>
	<div class="container">
	      <div class="row">
	        <div class="col-md-12">
	          <div class="panel panel-info">
	            <div class="panel-heading">
	              <h3 class="panel-title"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/mic.svg" style="max-width: 3%; alt="" />&nbsp;&nbsp;${news.title}</h3>
	            </div>
	            <div class="panel-body">
	              <div style="float:right;"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/pencils.svg" style="max-width: 5.5%; alt="" />&nbsp;&nbsp;
	              ${news.user.username}&nbsp;&nbsp; 입력&nbsp;&nbsp;${news.updatedTime}
	   			</div>
	   			 <p style="clear:both;">&nbsp;</p>
		         <img alt="" style="max-width: 100%; height: auto;" vspace="20" src="<c:url value="${news.imagePath }" />" >
					<div id="test">
					<pre><h3><c:out value="${news.content}"/></h3></pre>
					</div>
		       </div>
		     </div>
		   </div>
		 </div>
		</div>
</center>

<script type="text/javascript">
	$('#test').each(function(){
	    var $this = $(this);
	    var t = $this.text();
	    $this.html(t.replace('&lt','<').replace('&gt', '>'));
	});
</script>

<div class="container">
	 <form action="/newsComment" method="post" >
	<table>
		<tr>
	  			<td><input name="newsId" type="hidden" value="${news.id }"></td>
	            <td><textarea style="width:500%; height:100;" rows="3" name="content"   placeholder="Add comment..." class="form-control" ></textarea></td>
	   			<td><button id="getQuizBt" class="btn btn-success" style="display:inline-block; right: 1px; margin: 0px  0px  0px  820px ; top: 0px; width:13%; height:50%">Submit</button><td>
	   	</td>		
	</table>
	</form>
</div>
 <br />
 <div class="container">
	   <c:forEach items="${news.boardcommentList}" var="boardComment">
	     <dl>
	  		<dd><c:out value="${boardComment.user.username}"/></dd>
	  		<dd><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/girl.svg" style="max-width: 3.5%; alt="girl" />&nbsp;<c:out value="${boardComment.content}"/></dd>
	  		<dd><a href="/news/${news.id}/${boardComment.id}/commentUpdate" class="btn">UpDate</a>
	  		<a href="/news/${boardComment.id}/commentDelete" class="btn">Delete</a></dd>
		</dl>
	  </c:forEach>
  </div>

<jsp:include page="../jspinclude/footer.jsp" flush="false" />

</body>
</html>