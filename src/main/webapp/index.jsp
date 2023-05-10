<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<style type="text/css">
@media ( max-width : 600px) {
	h1 {
		margin-bottom: 20px;
	}
	h3 {
		margin-top: 30px;
	}
}

/* 화면 너비가 600px 초과일 때 */
@media ( min-width : 601px) {
	h1 {
		margin-bottom: 30px;
	}
	h3 {
		margin-top: 50px;
	}
}
h1{color: white;
font-size: 50px;
}



a {
/* a 태그의 기본 색상 */
   text-decoration: none;
   display: inline-block;
  padding: 10px;
  background-color: #FAFAC0;;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-decoration: none;
  color: navy;
}

a:hover {
  color: navy; /* a 태그를 마우스로 hover할 때 색상 */
    background-color: yellow;
}

body {
	background-color: navy;
}

.container {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.content {
	text-align: center;
}
</style>
</head>
<body>
	<!-- http://localhost:8090/biz로 서버요청 시 가장 처음 보여주는 화면  -->
	<div class="container">
		<div class="content">
			<h1>AREUM 게시판 프로그램</h1>

			<h3>
				<a href="login.do">회원 로그인</a>
			</h3>

			<!-- 아래 링크는 활성화 되어있음  -->
			<!-- <br>
		<br> <a href="getBoardList.do">글 목록 바로가기</a>
		<a href="dataTransform.do">글 목록 변환 처리</a><br>
		<hr>  -->
		</div>
	</div>




</body>
</html>