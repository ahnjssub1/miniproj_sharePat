<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function id를중복검사하다(){
	document.querySelector("#member_id").value="";
	window.open("/id","","width=500,height=300");
}
function 회원등록하다(){

	let member_id=document.querySelector("#member_id").value;
	if(member_id.trim()==""){
		alert("아이디는 필수입력입니다.");
		return false;
	}
	let member_pw=document.querySelector("#member_pw").value;
	if(member_pw.trim()==""){
		alert("패스워드는 필수입력입니다.");
		return false;
	}
	let member_name=document.querySelector("#member_name").value;
	if(member_name.trim()==""){
		alert("성명은 필수입력입니다.");
		return false;
	}
	let email1 = document.querySelector("#email1").value;
	let email2 = document.querySelector("#email2").value;
	let member_email = document.querySelector("#member_email");
	member_email.value=email1+"@"+email2;
	return true;
}
function id를받다(member_id){
	document.querySelector("#member_id").value=member_id;
}
</script>
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
.assignform{
	position: absolute;
	left: 32%;
	text-align : left;
}
#tit{
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
<header>
	<h1> 유기 동물 무료 분양 </h1>
</header>
<div class="assignform">
<h1 id="tit">회원등록</h1>
<form onsubmit="return 회원등록하다()" action="/assign" method="post" class="form"> 

ID* <input type="text" name="member_id" id="member_id" placeholder="myid1"/>
     <input type="button" class="btn" onclick="id를중복검사하다()" value="중복검사"/><br><br>
PassWord* <input type="password" name="member_pw" id="member_pw" placeholder="testpassword1"/><br><br>
성명* <input type="text" name="member_name" id="member_name" placeholder="testname1"/><br><br>
E-mail <input type="text" id="email1" placeholder="email1"/>@
      <select id="email2">
	    <option value="naver.com">navar.com</option>
	    <option value="daum.net">daum.net</option>
	    <option value="gmail.com">gmail.com</option>
	    <option value="직접">직접입력</option>
	  </select>
	  <input type="hidden" name="member_email" id="member_email"/><br><br>
전화번호 <input type="text" name="member_phone" id="member_phone" placeholder="010011112222"/><br><br>
      <br>
<input type="submit" class="btn" value="등록"/>
</form>
</div>
</body>
</html>
