<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 변수
	console.log('Hello','js');
	console.log("Hello js");
	console.log(`Hello js`);//ES6, backtick
	
	var aaaa = 'lee';
	console.log(`Hello \${aaaa} js`);//ES6, backtick ,jsp와 EL과 구분하기위한 \${}표현법
	console.log(`Hello \${25*25} js`);//ES6, backtick ,jsp와 EL과 구분하기위한 \${}표현법
	
	
	//1.예약어 없는 변수선언
	str = "<h1>js01_variable.jsp</h1>";
	str = "aaaaaaa";
	console.log(str, typeof(str));
	
	//2.var 변수
	var str2 = "<h1>js01_variable.jsp</h1>";
	console.log(str2, typeof(str));
	var str2 = "bbb";
	console.log(str2, typeof(str));
	
	//3.let 변수
	//ES6 : 동일변수 사용불가 + 변수값 변경가능
	//블럭레벨 변수(지역변수)
	let name;//선언만 하면 undefined 타입
	console.log(name, typeof(name));
	
	name = 3.14;
	console.log(name, typeof(name));
	
	
	let name2 = 99;
	
	//4.const 상수
	//ES6 : 동일변수 사용불가 + 읽기전용(상수)
	//블럭레벨 변수(지역변수)
	const kor = 100;
// 	kor = 99;  //NO
	const kor2 = "국어";
	
	//리터럴 : 할당연산자를 통해 할당되는 모든것.
	//자바스크립트 변수의 타입은 할당된 리터럴에 의해 정해진다.
	
	let arr = [];//array(object)
	console.log(arr, typeof(arr));
	
	let obj = {};//object
	console.log(obj, typeof(obj));
	
	let fn = function(){};//function
	console.log(fn, typeof(fn));
	
	let a = null;//object
	console.log(a, typeof(a));
	
	let b;//undefined, 할당하지않은상태.
	console.log(b, typeof(b));
	
// 	console.log(bbb, typeof(bbb));//변수 선언없이 사용시, not defined 에러
	
	let tag = '<h1>js01_variable.jsp</h1>'
		tag +='<h1>js01_variable.jsp</h1>'
		tag +='<h1 class="h001">js01_variable.jsp</h1>';
	console.log(tag);
	
	let tag2 = `<h1>js01_variable.jsp</h1>
		<h1>js01_variable.jsp</h1>
		<h1>js01_variable.jsp</h1>`;
	
	console.log(tag2);
	
</script>
</head>
<body>
	<script type="text/javascript">
		console.log('start body.....');
	</script>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
	<div id="div001">id</div>
	
	
	<div class="div002">class</div>
	<div class="div002">class</div>
	<div class="div002">class</div>
	
	<p>p tag</p>
	<p>p tag</p>
	<p>p tag</p>
	
	
	<script type="text/javascript">
		console.log('end body.....');
		console.log(tag2);
		document.write('hello2');
// 		let div001 = document.getElementById('div001');
		let div001 = document.querySelector('#div001');
		console.log(div001);
		div001.innerHTML = tag2;
// 		div001.innerText = tag2;
		
// 		let div002 = document.getElementsByClassName('div002');
		let div002 = document.querySelectorAll('.div002');
		console.log(div002);
		
		div002[0].innerText = 'javascript....0';
		div002[1].innerText = 'javascript....1';
		div002[2].innerText = 'javascript....2';
		
// 		let ps = document.getElementsByTagName('p');
		let ps = document.querySelectorAll('p');
		console.log(ps);
		ps[0].innerHTML = '<span>p01</span>';
		ps[1].innerHTML = '<span>p02</span>';
		ps[2].innerHTML = '<span>p03</span>';
		
	</script>
</body>
</html>