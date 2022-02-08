<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function 그림파일읽어출력하기(이벤트) {
		var fileInput=이벤트.target;
		//change이벤트.target(대상)은 <input type="file" name="profileFile" id="profileFile"/>
	    var 선택된그림파일관리객체 = fileInput.files[0]; 
	    var 선택된그림size = 선택된그림파일관리객체.size;
	     /*
	    if(선택된그림size > 1024*10){
	    	alert("10K 요량초과!");
	    	fileInput.value="";
	    	return ;
	    }
	     */
	    if (!선택된그림파일관리객체.type.match('image.*')) {
	       alert("욱! 그림이 아니예요!");
	       fileInput.value="";
	       return ;
	    }
	    var 파일리더 = new FileReader();
	         파일리더.onload = function(선택된그림파일관리객체) {
	  	  var imgProfile=document.getElementById("story_profile");    	  
	  	  imgProfile.src=선택된그림파일관리객체.currentTarget.result;
	    };      
	    파일리더.readAsDataURL(선택된그림파일관리객체);
	    return ;
	}
	document.querySelector("#story_profileFile").addEventListener("change", 그림파일읽어출력하기, false);
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스토리 등록</h1>
<form action="/story" enctype="multipart/form-data"  method="post">
 제목<input type="text" name="story_title" /> <br>
 사진 <img id="story_profile" src="/img/no_image.jpg" width="200" height="300"/><br>
     <input type="file" name="story_profileFile" id="story_profileFile"/><br> 
 
 내용<textarea cols="25" rows="5" name="story_contents" ></textarea><br>
 <input type="submit" value="등록" />
</form>
<button onclick="location.href='/main'">메인</button>
<button onclick="location.href='/member'">이전</button>

</body>
</html>