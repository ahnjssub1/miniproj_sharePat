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
.alarm{
	text-align: center;
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
<div class="alarm">
<h1>스토리이 변경되었습니다.</h1>
<button class="btn" onclick="location.href='/story/<%=story.getStory_no()%>'">스토리상세</button>
<button class="btn" onclick="location.href='/storys'">스토리목록</button>
<button class="btn" onclick="location.href='/main'">메인</button>
</div>
</body>
</html>