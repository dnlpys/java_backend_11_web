<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('js07_ajax..2');

	window.onload = function() {
		console.log('onload....');

	};//end onload

	function loadDoc() {
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = JSON.parse(this.responseText).result;
		};
		xhttp.open("GET", "js07_ajax.txt");
		xhttp.send();
	}
	
	function idCheck() {
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = JSON.parse(this.responseText).result;
		};
		
		let id = document.getElementById("id").value;
		console.log('id:',id);
		xhttp.open("GET", "json_idCheck.do?id="+id);
		xhttp.send();
	}
	
</script>
</head>
<body>
	<h1>js07_ajax.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<h1 id="h01">hello1</h1>
	<button type="button" onclick="loadDoc()">ID중복체크</button>
	<div id="demo">aaaaa</div>
	
	<hr>
	<form action="js06_event.jsp" id="form01">
		<input type="text" id="id" name="id" value="admin"><br>
		<button type="button" onclick="idCheck()">ID중복체크</button>
		<input type="submit">
	</form>
	
	
</body>
</html>