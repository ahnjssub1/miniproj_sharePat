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
<h1>스토리 변경</h1>
<form  action="/story/update" method="post">
  <input type="hidden" name="story_no" value="<%=story.getStory_no()%>" />
  제목<input type="text" name="story_title" value="<%=story.getStory_title()%>" /><br>
  내용<textarea cols="25" rows="5" name="story_contents" ><%=story.getStory_contents()%></textarea><br>
 <input class="btn" type="submit" value="등록" />
</form>
</body>
</html>