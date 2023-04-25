<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('js06_event..2');

	window.onload = function() {
		console.log('onload....');
		document.querySelector('#h01').innerHTML = 'function...';

		document.querySelector('#h01').onclick = function() {
			this.innerHTML = 'click...';
		};

		
		document.querySelector('#h02').onmouseover = function() {
			this.innerHTML = 'onmouseover...';
		};
		document.querySelector('#h02').onmouseout = function() {
			this.innerHTML = 'onmouseout...';
		};

		
// 		document.querySelector('#name').onkeydown = function() {
// 			document.querySelector('#h01').innerHTML = this.value;
// 		};
		document.querySelector('#name').onkeyup = function() {
			document.querySelector('#h01').innerHTML = this.value;
		};
		
		document.querySelector('#form01').onsubmit = function(event) {
			console.log('onsubmit...');
			event.preventDefault();//고유액션제거
			event.stopPropagation();//이벤트 번짐 방지(이벤트 버블링 제거)
		};
		
// 		document.querySelector('#hobby').onclick = function() {
// 			console.log('onclick...',this.checked);
// 		};
		document.querySelector('#hobby').onchange = function() {
			console.log('onchange...',this.checked);
		};
		
		document.querySelector('#searchKey').onchange = function() {
			console.log('select onchange...',
					this.options[this.selectedIndex].value);
			console.log('select onchange...',
					this.options[this.selectedIndex].text);
		};
		
		
	};//end onload
	
</script>
</head>
<body>
	<h1>js06_event2.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<h1 id="h01">hello1</h1>
	<h1 id="h02">hello2</h1>
	
	<form action="js06_event.jsp" id="form01">
		<input type="text" id="name" name="name" value="kim"><br>
		<input type="checkbox" id="hobby" name="hobby" value="hobby">baseball<br>
		<select id="searchKey" name="searchKey">
			<option value="name">NAME</option>
			<option value="age">AGE</option>
		</select>
		<input type="submit">
	</form>

</body>
</html>