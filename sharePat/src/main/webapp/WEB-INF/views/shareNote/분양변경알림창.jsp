<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stone.springmvc.shareNote.common.*" %>    
<%
	ShareNote shareNote=(ShareNote)request.getAttribute("shareNote");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>분양이 변경되었습니다.</h1>
<button onclick="location.href='/shareNote/<%=shareNote.getShare_no()%>'">분양상세</button>
<button onclick="location.href='/shareNotes'">분양목록</button>
<button onclick="location.href='/main'">메인</button>
</body>
</html>