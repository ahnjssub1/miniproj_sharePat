<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header{
	 margin-top: -70px;
    padding-top: 70px;
  	left: 0;
	right: 0;
	text-align: center;
	color: white;
	background-color: #99A799;
	
}
main{
	position: fixed; 
	top: 4rem; 
	left: 0; 
	right: 0; 
	bottom: 0; 
	overflow: auto;
}
.notion-area{
	background-color : #FFFFCC;
	text-align : center;
	font-size: 23px;
}

.button-area{
	text-align : center;
	
}
.btn{
	margin-left: 8px;
    border:none;
    color: white;
    background-color: #406254;
    border-radius: 3px;
}
.name{
	text-align : center;
}
.form{
	text-align : center;
}
</style>
</head>
<body>
<header>
	<h1> 유기 동물 무료 분양 </h1>
</header>

<div  class="notion-area">
<p>아이디 또는 패스워드가 일치하지않습니다.</p>
</div>
<h1 class="name">로그인</h1>
<form action="/login" method="post" class="form">
ID<input type="text" name="member_id" /><br>
Password<input type="password" name="member_pw" /><br>
<nav class="button-area">
<input class="btn" type="submit" value="로그인" /></nav>
</form>
<nav class="button-area">
<button class="btn" onclick="location.href='/main'">메인</button></nav>

</body>
</html>