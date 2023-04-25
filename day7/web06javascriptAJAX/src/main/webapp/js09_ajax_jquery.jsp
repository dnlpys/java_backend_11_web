<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
	console.log('js09_ajax_jquery.jsp');

	$(function() {
		console.log('onload....');

	});

	function loadDoc() {

		$.ajax({
			url : "js07_ajax.txt",
			success : function(result) {
				console.log('ajax...success:', result);//{"result":"OK"}
				$("#demo").html(JSON.parse(result).result);
			}
		});

	}

	function idCheck() {
		console.log('idCheck....');
		console.log('id:',$("#id").val());
		$.ajax({
			url : "json_idCheck.do",
			data:{id:$("#id").val()},
			method:'GET',//default get
// 			method:'POST',
			dataType:'json',
			success : function(response) {
				console.log('ajax...success:', response);//{"result":"OK"}
				$("#demo").html(response.result);
			},
			error:function(xhr,status,error){
				console.log('xhr.status:', xhr.status);
// 				console.log('status:', status);
// 				console.log('error:', error);
			}
		});
	}
</script>
</head>
<body>
	<h1>js09_ajax_jquery.jsp</h1>
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