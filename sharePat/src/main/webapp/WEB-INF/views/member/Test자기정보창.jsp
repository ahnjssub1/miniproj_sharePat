<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자신의 정보</h1>

 ID:${member.member_id}<br>
  성명:${member_name}<br>
 E-mail:${member_email}<br>
  전화번호:${member_phone}<br>
  
 <button onclick="location.href='/shareNote'">분양등록</button>
 <button onclick="location.href='/story'">스토리등록</button>
 <button onclick="location.href='/shareNotes'">분양목록</button>
 <button onclick="location.href='/storys'">스토리목록</button>
 <br><br>
  <button onclick="location.href='/main'">메인</button>
</body>
</html>