<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
		
	<div class="board_bg">
		
		<h1><spring:message code="message.user.login.title"/></h1>
<a href="login.do?lang=en" class="lang_bt">
	<spring:message code="message.user.login.language.en"/></a>
<a href="login.do?lang=ko" class="lang_bt">
	<spring:message code="message.user.login.language.ko"/></a>
	
		
	
		<form action="login.do" method="post">
			<table class="list_tb login_tb" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td class="t_name"><spring:message code="message.user.login.id"/></td>
					<td><input type="text" name="id" value="${user.id }"/></td>
				</tr>
				<tr>
					<td class="t_name"><spring:message code="message.user.login.password"/></td>
					<td><input type="password" name="password" value="${user.password }" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="<spring:message code="message.user.login.loginBtn"/>" /></td>
		
			</table>
		</form>
	
</div>
</body>
</html>