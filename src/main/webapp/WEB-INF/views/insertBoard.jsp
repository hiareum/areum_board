<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>새글등록</title>
</head>
<body>
	<div class="board_bg">
		<h1>AREUM BOARD 소통</h1>
		<div class="logout">
		<a href="logout.do" >Log-out</a>
		</div>

		<!-- 230425 글등록이 안되어  enctype="multipart/form-data"추가 했더니 글등록이 되었다!!! -->
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table class="list_tb" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td class="t_name">제목</td>
					<td align="left"><input type="text" name="title" /></td>
				</tr>
				<tr>
				<!-- 작성자 readonly, 사용자이름으로 자동저장 -->
					<td class="t_name">작성자</td>
					<td align="left"><input type="text" value="${userName }"  name="writer" size="10" readonly /></td>
				</tr>
				<tr>
					<td class="t_name">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<!-- 추후 만들 예정 -->
				<!--  <tr>
					<td bgcolor="orange" width="70">업로드</td><td align="left">
					<input type="file" name="uploadFile"/></td>
				</tr> -->
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value=" 새글 등록 " /></td>
				</tr>
			</table>
		</form>
	
		<a href="getBoardList.do">글 목록 가기</a>
	</div>
</body>
</html>