<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="com.stone.springmvc.member.common.*" %>   
<%
Member member=(Member)request.getAttribute("member");
boolean isLogin=(boolean)request.getAttribute("isLogin");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main HOME</title>
<style>
header{
	position: fixed;
	top: 0;
  	left: 0;
	right: 0;
	text-align: center;
	color: white;
	background-color: #99A799;
	
}
.button-area{
	text-align : center;
}
.btn{
	margin-left: 8px;
    border:none;
    color: white;
    background-color: #406254;
    border-radius: 3px;
}
#ss{
	font-size: smaill;
	color: gray;
	text-align : center;
	
}
#mainboard{
	font-size: medium;
	background: #FBFBCE;
	padding: 15px;
	
}
</style>
</head>
<body>

<header>
	<h1> 유기 동물 무료 분양 </h1>
</header>
<br><br><br><br><br><br>

<nav class="button-area">
<%if(isLogin){ %>
  	<button class="btn" onclick="location.href='/member'">자신의 정보</button>
	<button class="btn" onclick="location.href='/shareNotes'">분양목록</button>
    <button class="btn" onclick="location.href='/storys'">스토리목록</button>
    <button class="btn" onclick="location.href='/logOut'">로그아웃</button>
<%}else{ %>
	<button class="btn" onclick="location.href='/login'">로그인</button>
	<button class="btn" onclick="location.href='/assign'">회원가입</button>
<%} %>
</nav>
<p id="ss">모든 항목은 로그인 후 이용이 가능합니다.</p><br><br>
<div id="mainboard">

나의 반려 동물을 스토리에 작성하여 자랑해보세요. 다양한 사람들의 반려동물들을 볼 수 있습니다.<br><br>
주변에 반려 동물 입양하고 분양하세요. 무료 분양을 통해 아직 주인을 찾지 못한 동물들에게 사랑을 선사합시다

</div>

</body>
</html>