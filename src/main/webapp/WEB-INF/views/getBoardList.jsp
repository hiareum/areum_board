<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AREUM BOARD 방명록</title>
</head>
<body>

	
	<div class="board_bg">

		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<h3 class="welcomeMsg">${userName}<spring:message code="message.board.list.welcomeMsg"/></h3>
	
		
		<div class="logout">
		<a href="logout.do" >Log-out</a>
		</div>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">

			<table class="list_tb"  cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<c:forEach items="${conditionMap }" var="option">
							<option value="${option.value }">${option.key }
						</c:forEach>							
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
					</td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table class="list_tb" border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th class="t_name" width="100">
				<spring:message	code="message.board.list.table.head.seq" /></th>
				<th class="t_name" width="200">
				<spring:message code="message.board.list.table.head.title" /></th>
				<th class="t_name" width="150">
				<%-- <spring:message code="message.board.list.table.head.content" /></th> <!-- 230425내용검색할때 안나와서 추가 -->
				<th bgcolor="orange" width="150"> --%>
				<spring:message code="message.board.list.table.head.writer" /></th>
				<th class="t_name" width="150">
				<spring:message code="message.board.list.table.head.regDate" /></th>
				<th class="t_name" width="100">
				<spring:message code="message.board.list.table.head.cnt" /></th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.seq }</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq }">
							${board.title }</a></td>
							<%-- <td>${board.content }</td> <!-- 230425내용검색할때 안나와서 추가 --> --%>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="newBoard.do"><spring:message code="message.board.list.link.insertBoard"/></a>
	</div>
	
	
</body>
</html>