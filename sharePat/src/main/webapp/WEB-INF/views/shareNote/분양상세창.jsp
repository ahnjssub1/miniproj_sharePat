<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="com.stone.springmvc.shareNote.common.*" %>    
<%
	ShareNote shareNote=(ShareNote)request.getAttribute("shareNote");
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
<h1>분양 상세</h1>
제목:<%=shareNote.getShare_title() %><br>
<img src="/profile/${shareNote.share_no}" width="200" height="300"/><br> 
내용:<%=shareNote.getShare_contents() %><br>
적성자:${shareNote.writer.member_name}<br>
시간: <%=shareNote.getShare_time() %><br>

<!-- 글쓴이와 로그인한 회원이 동일 인 일때 -->
<%if( isWriter!=null && isWriter==true ){ %>
<button class="btn" onclick="location.href='/shareNote/<%=shareNote.getShare_no()%>/delete'">삭제</button>
<button class="btn" onclick="location.href='/shareNote/<%=shareNote.getShare_no()%>/prepare_update'">수정</button>
<%} %>
<button class="btn" onclick="location.href='/shareNotes'">분양목록</button>
<button class="btn" onclick="location.href='/main'">메인</button>


</body>
</html>