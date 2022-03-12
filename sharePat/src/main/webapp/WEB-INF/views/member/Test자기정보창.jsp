<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%-- <%@ page import="com.stone.springmvc.member.common.*" %>    --%>
<%-- <% Member member=(Member)request.getAttribute("member"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header{
	margin-top: -70px;
    padding-top: 70px;
  	left: 0;
	right: 0;
	text-align: center;
	color: white;
	background-color: #99A799;
	
}
.btn{
	margin-left: 8px;
    border:none;
    color: white;
    background-color: #406254;
    border-radius: 3px;
}
</style>
</head>
<body>
<header>
	<h1> 유기 동물 무료 분양 </h1>
</header>
<h1>자신의 정보</h1>

 ID: ${member.member_id}<br>
  성명: ${member.member_name}<br>
 E-mail: ${member.member_email}<br>
  전화번호: ${member.member_phone}<br><br>
  
 <button class="btn" onclick="location.href='/shareNote'">분양등록</button>
 <button class="btn" onclick="location.href='/story'">스토리등록</button>
 <button class="btn" onclick="location.href='/shareNotes'">분양목록</button>
 <button class="btn" onclick="location.href='/storys'">스토리목록</button>
 <br><br>
  <button class="btn" onclick="location.href='/main'">메인</button>
</body>
</html>