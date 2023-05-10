<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">


<!-- custom css -->
<link href="${contextPath}/resources/css/style.css" rel="stylesheet"
	type="text/css" media="screen">


<!-- title -->
<title><tiles:insertAttribute name="title" /></title>
<!-- title -->

</head>

<body class="bg-primary-subtle p-5">
	<div id="container"
		class="bg-white m-auto rounded p-5 position-relative">


		<!-- 언어선택 -->
	<%-- 	<div
			class="lanBox text-end position-absolute position-absolute top-0 end-0 language_box">
			<a href="?lang=en"
				class="lanE btn btn-light small btn-sm rounded-0 rounded-top"> <spring:message
					code="message.user.login.language.en" />
			</a> <a href="?lang=ko"
				class="lanK btn btn-light small btn-sm rounded-0 rounded-top"> <spring:message
					code="message.user.login.language.ko" />
			</a>
		</div>
		<!-- 언어선택 --> --%>


		<div id="header" class="text-center pb-4 mb-3">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer" class="text-center border-top pt-4 mt-5">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>




<script>

//언어 BTN STYLE지정
const lanBox = document.querySelector(".lanBox");
const lanE = document.querySelector(".lanE");
const lanK = document.querySelector(".lanK");

const url = new URL(window.location.href);

if (url.pathname.includes("getBoard.do")) {
	if (url.searchParams.has("lang")) {
		url.searchParams.set("lang", "ko");
		lanK.href = url.href;
		url.searchParams.set("lang", "en");
		lanE.href = url.href;
	} else {
		lanE.href = url.href + "&lang=en";
		lanK.href = url.href + "&lang=ko";
	}
}

</script>

</html>