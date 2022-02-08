<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stone.springmvc.story.common.*" %>    
<%
	Story story=(Story)request.getAttribute("story");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스토리이 변경되었습니다.</h1>
<button onclick="location.href='/story/<%=story.getStory_no()%>'">스토리상세</button>
<button onclick="location.href='/storys'">스토리목록</button>
<button onclick="location.href='/main'">메인</button>
</body>
</html>