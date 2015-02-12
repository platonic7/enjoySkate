<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html >
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enjoy Skate!</title>
    	  <link href="/resources/HTML/UI/Flat-UI-Pro-1.3.2/dist/css/vendor/bootstrap.min.css" rel="stylesheet">
          <link href="/resources/HTML/UI/Flat-UI-Pro-1.3.2/dist/css/flat-ui-pro.css" rel="stylesheet">
		  <link rel="shortcut icon" href="/resources/image/skateboard.png">
		
		  <script type="text/javascript" src="/resources/bootstrap/bootstrap.min.js"></script>
		  <script type="text/javascript" src="/resources/flat_ui_pro/respond.min.js"></script>
		  <script src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/js/application.js"></script>
		  <script src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/dist/js/vendor/jquery.min.js"></script>
	      <script src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/dist/js/flat-ui-pro.min.js"></script>

	     <!-- <script src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/js/prettify.js"></script>
	      <script src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/js/application.js"></script> -->
	<style>
      body {
        min-height: 2000px;
        padding-top: 70px;
      }
      .text-default {
        color: #34495e;
      }
      .text-pomegranate {
        color: #c0392b;
      }
      .text-amethyst {
        color: #9b59b6;
      }
      .text-nephritis {
        color: #27ae60;
      }
      

    </style>
    
    
 </head>
 <body>
    <!-- Static navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
          </button>
          <a class="navbar-brand" href="/home">ENJOY SKATE</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="/skate">SKATEBOARD</a></li>
            <!-- <li><a href="/news?page=0&size=2&sort=id,desc">NEWS</a></li>   -->  <!-- 페이지 처리시 다시 구현 -->
            <li><a href="/news">NEWS</a></li>
            <li><a href="/spots">SPOTS</a></li>
           <!--  <li><a href="/community">COMMUNITY</a></li> -->
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">COMMUNITY <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/dj.svg" style="max-width: 9%; alt="" />&nbsp;&nbsp;EVERY DAY SKATE!</li>
                <li><a href="/community"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/donut.svg" style="max-width: 10%; alt="" />&nbsp;&nbsp;FREE BOARD</a></li>
                <li class="divider"></li>
                <li><a href="/enjoycommunity" ><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/chat.svg" style="max-width: 10%; alt="" />&nbsp;&nbsp;ENJOY TOGETHER</a></li>
                <li><a href="/ppomppucommunity"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/paper-bag.svg" style="max-width: 10%; alt="" />&nbsp;&nbsp;PPOMPPU</a></li>
                <li><a href="/buycommunity"><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/card.svg" style="max-width: 10%; alt="" />&nbsp;&nbsp;BUY & SELL</a></li>
              </ul>
            </li>
            <li><a href="/admin">ADMIN TEST</a></li>
          </ul>
          <!-- <form class="navbar-form navbar-left" action="#" role="search">
            <div class="form-group">
              <div class="input-group">
                <input class="form-control" id="navbarInput-01" type="search" placeholder="Search">
                <span class="input-group-btn">
                  <button type="submit" class="btn"><span class="fui-search"></span></button>
                </span>
              </div>
            </div>
          </form> -->
             <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" ><img src="/resources/HTML/UI/Flat-UI-Pro-1.3.2/docs/assets/img/icons/skateboard.svg" style="max-width: 9%; alt="" />&nbsp;&nbsp;
              	<sec:authentication property="principal.username"/> <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#"><sec:authentication property="principal.username"/></a></li>
                <li class="divider"></li>
	            <li class="active"><a href="/users/my-info"><span class="fui-user text-default"></span>&nbsp;&nbsp;&nbsp;My account</a></li>
                <li class="divider"></li>
	            <li><a href="#fakelink"><span class="fui-gear text-default"></span>&nbsp;&nbsp;&nbsp;Settings</a></li>
	            <li><a href="/j_spring_security_logout"><span class="fui-time text-primary"></span>&nbsp;&nbsp;&nbsp;Logout</a></li>
                <!-- <li><a href="#fakelink"><span class="fui-mail text-pomegranate"></span>&nbsp;&nbsp;&nbsp;Messages</a></li>
	            <li><a href="#fakelink"><span class="fui-photo text-nephritis"></span>&nbsp;&nbsp;&nbsp;Photos</a></li>
	            <li><a href="#fakelink"><span class="fui-video text-danger"></span>&nbsp;&nbsp;&nbsp;Videos</a></li>
	            <li><a href="#fakelink"><span class="fui-chat text-amethyst"></span>&nbsp;&nbsp;&nbsp;Chat</a></li> -->
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
