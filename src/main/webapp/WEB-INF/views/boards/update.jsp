<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../jspinclude/topBar.jsp" flush="false" />
<jsp:include page="../jspinclude/adminTopBar.jsp" flush="false" />
    
	<center><div class="container">
	      <div class="row">
	        <div class="col-md-12">
	          <div class="panel panel-info">
	            <div class="panel-heading">
	              <h4 class="panel-title"></h4>
         		    <h4><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/donut.svg" style="max-width: 2.7%; alt="" />&nbsp;&nbsp;BOARD UPDATE&nbsp;&nbsp;<img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/donut.svg" style="max-width: 2.7%; alt="" /></h4>
	               </div>
	                <div class="panel-body">
	                  <div class="row">
                        <div class="col-md-12">
				          <form action="/update" class="form" enctype="multipart/form-data" method="post">
				            <div class="form-group">
				              
				              <div class="col-md-4">
				                <div class="form-group has-warning" style="position: absolute; right: 50px; top: 0px; width:86%;">
				                  <div class="fileinput fileinput-new input-group" data-provides="fileinput" >
				                    <div class="form-control uneditable-input" data-trigger="fileinput">
				                      <span class="fui-clip fileinput-exists"></span>
				                      <span class="fileinput-filename"></span>
				                    </div>
				                    <span class="input-group-addon btn btn-default btn-file">
				                      <span class="fileinput-new">Select file</span>
				                      <span class="fileinput-exists"><span class="fui-gear"></span>&nbsp;&nbsp;Change</span>
				                      <input type="file" name="file">
				                    </span>
				                    <a href="#" class="input-group-addon btn btn-default fileinput-exists" data-dismiss="fileinput"><span class="fui-trash"></span>&nbsp;&nbsp;Remove</a>
				                  </div>
				                 </div>
				            	 </div>
				              	<input type="text" name="title" value="${boardUpdate.title}" class="form-control" style="width:66.5%;">
				              </div>
			              	 <div class="form-group">
				         		<textarea class="form-control" name="content" rows="10" >${boardUpdate.content}</textarea>
				        	</div>
					        	<input type="hidden" name="id" value="${boardUpdate.id}"/>
					            <button type='reset' class="btn btn-info">CLEAR</button>
					            <button type="submit" class="btn btn-success" value="Upload">&nbsp;&nbsp;SAVE&nbsp;&nbsp;</button>
				           </form>
				        </div>
				     </div>
	   			  </div>
	       	   </div>
	     	</div>
	   	</div>
	 </div></center>

  <jsp:include page="../jspinclude/footer.jsp" flush="false" />
 </body>
</html>	
