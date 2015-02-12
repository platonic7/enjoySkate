<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<style>
.carousel .item {
    width: 100%; /*slider width*/
    max-height: 600px; /*slider height*/
}
.carousel .item img {
    width: 100%; /*img width*/
}
/*full width container*/
@media (max-width: 767px) {
    .block {
        margin-left: -20px;
        margin-right: -20px;
    }
    
    .carousel {
  height: 500%;
  weight: 500%;
}
}

</style>

<div class="container">
        <div class="row">
            <div class="col-md-8 mtl">
              <div id="myCarousel" class="carousel slide" >
                <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- Carousel items -->
                <div class="carousel-inner">
                  <div class="active item">
                  <a href="/spots/1/detail" >
					<img src="/resources/image/topimg02.jpg" style="max-width: 100%; height: auto;" alt="Test" /></a>
                    <div class="carousel-caption">
                      <h3>Tokyo HLNA Park!</h3>
                      <p>도쿄 오다이바에 있는 유명한 파크 함께 가볼실까요?</p>
                    </div>
                  </div>
                  <div class="item">
                  <a href="/skate" >
                    <img src="/resources/image/topimg03.jpg" alt="" /></a>
                    <div class="carousel-caption">
                      <h3>Summer is Back!</h3>
                      <p>여름엔 서핑보드를 배워보는거 어떄요?</p>
                    </div>
                  </div>
                  <div class="item">
                    <img src="/resources/image/topimg04.jpg" alt="" />
                    <div class="carousel-caption">
                      <h3>Winter is too Cold</h3>
                      <p>스노우 보드도 함께 해볼까요?</p>
                    </div>
                  </div>
                </div>
                <!-- Carousel nav -->
                <a class="carousel-control fui-arrow-left left" href="#myCarousel" data-slide="prev"></a>
                <a class="carousel-control fui-arrow-right right" href="#myCarousel" data-slide="next"></a>
              </div>
            </div>
        </div><!-- /.row -->
    </div><!-- /.container -->
    
    <script>
      $('.carousel').carousel({
      interval: 2000
    })
    </script>