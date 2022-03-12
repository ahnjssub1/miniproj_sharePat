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
<h1>분양 변경</h1>
<form  action="/shareNote/update" method="post">
  <input type="hidden" name="share_no" value="<%=shareNote.getShare_no()%>" />
  제목<input type="text" name="share_title" value="<%=shareNote.getShare_title()%>" /><br>
  내용<textarea cols="25" rows="5" name="share_contents" ><%=shareNote.getShare_contents()%></textarea><br>
 <input class="btn" type="submit" value="등록" />
</form>
</body>
</html>