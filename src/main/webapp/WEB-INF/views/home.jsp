<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
	
    <jsp:include page="./jspinclude/topBar.jsp" flush="false" />
    <jsp:include page="./jspinclude/carousel.jsp" flush="false" />
    
    <!-- 메인 배너 or 베스트글 -->
    <!-- <div id="coupon">
    	<a href="http://www.naver.com" style="border: none;" title="공짜 스케이트보드라면 여기를 클릭">
    		<img src="/resources/image/IMG_3032.JPG" style="max-width: 27.5%; position: absolute;
    		top: 95px; left: 860px; height: auto;"  alt="Test" />
    	</a>
    </div> -->  

<div class="container">
  <h4 class="text-info"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/weather.svg" style="max-width: 2.7%; alt="" />&nbsp;&nbsp;NEW UPDATE</h4>
    <h5 class="text-primary"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/video.svg" style="max-width: 2.7%; alt="" />&nbsp;&nbsp;News</h5>
      <div class="row">
	    <c:forEach items="${newsList}" begin="0" end="3" var="news">
         <div class="col-xs-6 col-md-3" >
           <a class="thumbnail" href="/news/${news.id}/detail">
			 <img alt="" src="<c:url value="${news.imagePath }" />" >
              <center><p>${news.title}</p></center>
          </a>
        </div>
     </c:forEach>
  </div>
</div>

<div class="container">
  <h5><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/converse.svg" style="max-width: 3.5%; alt="" />&nbsp;&nbsp;Spots Review</h5>
        <div class="row">
         <c:forEach items="${spotList}" begin="0" end="2" var="spot">
            <div class="col-sm-6 col-md-4">
              <div class="thumbnail">
              <a href="/spots/${spot.id}/detail" >
                <img alt="" src="<c:url value="${spot.imagePath }" />" > </a>
                  <center><h5>${spot.title}</h5></center>
                </div>
              </div>
        </c:forEach>
    </div>
</div>

    <br />
    <br />
    
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/girl.svg" style="max-width: 100%; alt="" />&nbsp;
        We need Skate friends&nbsp;<img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/dude.svg" style="max-width: 100%; alt="" /></h1>
        <h4>We always need a friend. Come join us!</h4>
        <p>우리는 언제나 친구가 필요합니다. 같이 스케이트를 탄다면 더욱 좋겠죠?</p>
        <p>우리 함께해요!</p>
        <p><iframe src="//player.vimeo.com/video/108875763" width="500" height="281" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe></p>
          <a class="btn btn-lg btn-primary" href="/enjoycommunity" role="button">Enjoy Together &raquo;</a>
        </p>
      </div>
    </div>
  
<br />
<br />
    
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/bulb.svg" style="max-width: 100%; alt="" />&nbsp;
        Let's Go Together Spot!&nbsp;<img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/skateboard.svg" style="max-width: 100%; alt="" /></h1>
        <h4>if you need skate park. Take a look at this!</h4>
        <p>ENJOY SKATE와 함꼐 SPOT 탐방!</p>
        <p>우리 함께해요!</p>
        <img src="/resources/image/4.JPG" style="max-width: 100%; height: auto;" hspace="300" vspace="30" alt="Test" />
        <center><span style="FONT-SIZE: 32px">Australia&nbsp; ::&nbsp; Pizzey Park</span></center><br>
        <p align="center" ><iframe marginheight="0" src="https://maps.google.co.kr/maps?ie=UTF8&amp;t=m&amp;q=-28.063654,153.42762100000004&amp;z=14&amp;iwloc=A&amp;ll=-28.063654,153.427621&amp;output=embed" marginwidth="0" scrolling="no" frameborder="0" height="350" width="425" >
			</iframe><br><small><a style="TEXT-ALIGN: left; COLOR: #0000ff" href="https://maps.google.co.kr/maps?ie=UTF8&amp;t=m&amp;q=-28.063654,153.42762100000004&amp;z=14&amp;iwloc=A&amp;ll=-28.063654,153.427621&amp;source=embed">크게 보기</a></small></p>
        <p>
          <a class="btn btn-lg btn-primary" href="/spots/3/detail" role="button" style="display:inline-block; margin:50px 0px 0px 450px">Go Spots! &raquo;</a>
        </p>
      </div>
    </div>
  
  	<!-- footer -->
  	<jsp:include page="./jspinclude/footer.jsp" flush="false" />
  </body>
</html>

