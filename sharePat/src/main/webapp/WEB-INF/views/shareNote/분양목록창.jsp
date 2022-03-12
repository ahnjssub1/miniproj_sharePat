<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.stone.springmvc.shareNote.common.*" %>
<% List<ShareNote> shareNotes= (List<ShareNote>) request.getAttribute("shareNotes"); %>
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
<h1>분양 목록</h1>
<ul>
<% for(int 일련번호=0;일련번호<shareNotes.size();일련번호++){ 
	ShareNote 분양 =shareNotes.get(일련번호);//zero base
%>
    <li><%=일련번호+1 %> 
        <a href="/shareNote/<%=분양.getShare_no()%>">
           <%= 분양.getShare_title() %>
        </a>
        <a href="/member/<%=분양.getWriter().getMember_no()%>">
        <%=분양.getWriter().getMember_name() %> 
        </a>
        <%=분양.getShare_time()%> 
    </li>
<%} %>
</ul>
<button class="btn" onclick="location.href='/shareNote'">분양등록</button>
<button class="btn" onclick="location.href='/main'">메인</button>
</body>
</html>