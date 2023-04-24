<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idCheck() {
		console.log('idCheck()....');
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			
			console.log(this.responseText);
			
			let msg = JSON.parse(this.responseText).result === 'OK'?'사용가능':'사용중'
			
			document.getElementById("demo").innerHTML = msg;
		};

		let id = document.getElementById("id").value;
		console.log('id:', id);
		xhttp.open("GET", "json_idCheck.do?id=" + id);
		xhttp.send();
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>


	<form action="insertOK.do" method="post">
		<table>
			<tr>
				<td><label for="id">id:</label></td>
				<td><input type="text" id="id" name="id" value="tester">
				<button type="button" onclick="idCheck()">ID중복체크</button>
					<span id="demo"></span></td>
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