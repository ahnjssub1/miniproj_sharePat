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
<h1>회원 정보</h1>
 ID: <%=member.getMember_id() %><br>
 E-mail: ${member.member_email}<br><br>

 
 <button class="btn" onclick="location.href='/shareNotes'">분양목록</button>
 <button class="btn" onclick="location.href='/storys'">스토리목록</button>
 <br><br>
 <button class="btn" onclick="location.href='/main'">메인</button>
 
</body>
</html>