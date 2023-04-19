<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="insertOK.do" method="post">
	<table>
		<tr>
			<td><label for="id">id:</label></td>
			<td><input type="text" id="id" name="id" value="tester"></td>
		</tr>
		<tr>
			<td><label for="pw">pw:</label></td>
			<td><input type="password" id="pw" name="pw" value="hi11"></td>
		</tr>
		<tr>
			<td><label for="name">name:</label></td>
			<td><input type="text" id="name" name="name" value="yang양"></td>
		</tr>
		<tr>
			<td><label for="tel">tel:</label></td>
			<td><input type="text" id="tel" name="tel" value="011"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
	</form>

</body>
</html>