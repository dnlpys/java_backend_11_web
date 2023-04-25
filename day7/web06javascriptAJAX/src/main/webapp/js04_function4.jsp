<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('function....4');
	
	//함수를 함수로 사용
	function test01(){
		console.log('test01()...');
	}
	
	test01();// 일반적인 함수콜
	
	//함수를 객체로 활용하기.-리턴문 없이 사용, 식별자는 대명사
	function Person(){
		console.log('Person()...');
		this.tel = '010';
		this.fn = function(){
			console.log('fn()....');
		};
	}
	
	let obj = new Object();
	
	//new 연산자로 콜
	let p = new Person();
	p.name = 'kim';
	console.log('p.name:',p.name);
	console.log('p.tel:',p.tel);
	p.fn();
	
	
	
</script>
</head>
<body>
	<h1>js04_function4.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>