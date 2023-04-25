<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update.jsp</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	
	<form action="updateOK.do" method="post">
	<table>
		<tr>
			<td><label for="num">num:</label></td>
			<td>${vo2.num}<input type="hidden" id="num" name="num" value="${vo2.num}"></td>
		</tr>
		<tr>
			<td><label for="id">id:</label></td>
			<td>${vo2.id}</td>
		</tr>
		<tr>
			<td><label for="pw">pw:</label></td>
			<td><input type="password" id="pw" name="pw" value="${vo2.pw}"></td>
		</tr>
		<tr>
			<td><label for="name">name:</label></td>
			<td><input type="text" id="name" name="name" value="${vo2.name}"></td>
		</tr>
		<tr>
			<td><label for="tel">tel:</label></td>
			<td><input type="text" id="tel" name="tel" value="${vo2.tel}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
	</form>

</body>
</html>