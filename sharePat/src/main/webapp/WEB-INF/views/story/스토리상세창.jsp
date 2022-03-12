<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  session="false"%>
<%@ page import="com.stone.springmvc.story.common.*" %>    
<%
	Story story=(Story)request.getAttribute("story");
    Boolean isWriter=(Boolean)request.getAttribute("isWriter");
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
<h1>스토리 상세</h1>
제목:<%=story.getStory_title() %><br>
<img src="/profile2/${story.story_no}" width="200" height="300"/><br> 
내용:<%=story.getStory_contents() %><br>
적성자:${story.writer.member_name}<br>
조회수:  <%=story.getStory_views() %><br>
시간: <%=story.getStory_time() %><br>

<!-- 글쓴이와 로그인한 회원이 동일 인 일때 -->
<%if( isWriter!=null && isWriter==true ){ %>
<button class="btn" onclick="location.href='/story/<%=story.getStory_no()%>/delete'">삭제</button>
<button class="btn" onclick="location.href='/story/<%=story.getStory_no()%>/prepare_update'">수정</button>
<%} %>
<button class="btn" onclick="location.href='/storys'">스토리목록</button>
<button class="btn" onclick="location.href='/main'">메인</button>


</body>
</html>