<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//함수 정의시에 함수명이 같은것이 여러개가 있어도 오류가 아니다
	//가장 마지막정의된것으로 덮어쓴다.
	//함수호출(콜)할때 정의부보다 먼저 콜하는 것이 가능하다.
	//1.x,x
	test01();
	function test01(){
		console.log('test01()...1');
	}
	test01();
	function test01(){
		console.log('test01()...2');
	}
	test01();
	
	//2.o,x
	//ES6 : 매개변수의 기본값을 할당해줄수 있다.
	function test02(x=0,y){
		console.log('test02()...',x,y);
	}
	//함수의 콜은 매개변수의 유무와 상관없고 함수명+()
	test02(100);
	test02();
	test02(11,22);
	
	//3.x,o
	function test03(){
		console.log('test03()...')
		return 11;
	}
	let result = test03();
	console.log('result:',result);
	
	//4.o,o
	function test04(x=0,y='kim'){
		console.log('test04()...',x,y);
		return 'yang';
	}
	result = test04(99);
	console.log('result:',result);
</script>
</head>
<body>
	<h1>js04_function.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>