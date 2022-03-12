<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //boolean 사용가능= true;//(boolean)request.getAttribute("usable");
    Boolean 사용가능= (Boolean)request.getAttribute("usable");
    String member_id=(String)request.getAttribute("member_id");
%>    
<!DOCTYPE html>
<html>
<head>
<script>
function id사용하다(){
	var member_id=document.querySelector("#member_id").value;
	opener.id를받다(member_id);
	close();
}
</script>
<style type="text/css">
.idch{
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="idch">
<h1>아이디 중복 검사</h1>
<form action="/id" method="post"> 
ID<input type="text" name="member_id" id="member_id" value="<%=(member_id==null)?"":member_id%>"/>
  <input type="submit" class="btn" value="검사"/>
<br>
</form>
<% if(사용가능!=null){
if(사용가능){ %>
	사용 가능한 id입니다. <input type="button" class="btn" onclick="id사용하다()" value="사용"/>
<%}else{ %>
    이미 사용 중 입니다.
<%} 
}%>
<br><input type="button" class="btn" value="취소"/>
</div>
</body>
</html>