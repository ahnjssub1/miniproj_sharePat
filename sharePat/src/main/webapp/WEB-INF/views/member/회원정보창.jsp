<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="com.stone.springmvc.member.common.*" %>    
<%
    Member member=(Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>각 사용자 마다의 공개가능한 정보 및 분양목록과 스토리목록 출력</title>
</head>
<body>
<h1>회원 정보</h1>
 ID:<%=member.getMember_id() %><br>
 E-mail:${member.member_email}<br>

 
 <button onclick="location.href='/shareNotes'">분양목록</button>
 <button onclick="location.href='/storys'">스토리목록</button>
 <br><br>
 <button onclick="location.href='/main'">메인</button>
 
</body>
</html>