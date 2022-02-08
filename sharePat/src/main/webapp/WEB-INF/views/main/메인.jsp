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
</head>
<body>
<p>우리의 반려동물</p>
<p>나의 반려 동물을 자랑하세요.</p>
<p>주변에 반려 동물 입양하고 분양하세요.</p>


<%if(isLogin){ %>
  	<button onclick="location.href='/member'">자신의 정보</button>
	<button onclick="location.href='/shareNotes'">분양목록</button>
    <button onclick="location.href='/storys'">스토리목록</button>
    <button onclick="location.href='/logOut'">로그아웃</button>
<%}else{ %>
	<button onclick="location.href='/login'">로그인</button>
	<button onclick="location.href='/assign'">회원가입</button>
<%} %>

<p>모든 항목은 로그인 후 이용이 가능합니다.</p>
</body>
</html>