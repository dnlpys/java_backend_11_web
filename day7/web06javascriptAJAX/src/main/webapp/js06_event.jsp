<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('js06_event..');

// 	window.onload = function() {
// 		console.log('onload....');
// 		document.querySelector('#h01').innerHTML = 'function...';

// 		document.querySelector('#h01').onclick = function() {
// 			// 			document.querySelector('#h01').innerHTML = 'click...';
// 			this.innerHTML = 'click...';
// 		};

// 	};
	
	function mainDisplay() {
		console.log('mainDisplay onload....');
		document.querySelector('#h01').innerHTML = 'function...';

	};
	
	function h1_click() {
		document.querySelector('#h01').innerHTML = 'h1_click...';
	};
	
	
</script>
</head>
<body onload="mainDisplay()">
	<h1>js06_event.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<h1 id="h01" onclick="h1_click()">hello</h1>

</body>
</html>