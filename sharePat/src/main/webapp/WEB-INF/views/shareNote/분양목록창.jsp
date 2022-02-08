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
</head>
<body>
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
<button onclick="location.href='/shareNote'">분양등록</button>
<button onclick="location.href='/main'">메인</button>
</body>
</html>