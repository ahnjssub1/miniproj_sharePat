<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.stone.springmvc.story.common.*" %>
<% List<Story> storys= (List<Story>) request.getAttribute("storys"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스토리 목록</h1>
<ul>
<% for(int 일련번호=0;일련번호<storys.size();일련번호++){ 
	Story 스토리 =storys.get(일련번호);//zero base
%>
    <li><%=일련번호+1 %> 
        <a href="/story/<%=스토리.getStory_no()%>">
           <%= 스토리.getStory_title() %>
        </a>
        <a href="/member/<%=스토리.getWriter().getMember_no()%>">
        <%=스토리.getWriter().getMember_name() %> 
        </a>
        <%=스토리.getStory_time() %> 
    </li>
<%} %>
</ul>
<button onclick="location.href='/story'">스토리등록</button>
<button onclick="location.href='/main'">메인</button>
</body>
</html>
