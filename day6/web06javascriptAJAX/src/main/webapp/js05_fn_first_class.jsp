<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('js05_fn_first_class..');
	
	//일급함수(함수를 리터럴로 사용)-무명함수를 사용
	//1. 함수를 변수에 할당 - 함수변수
	let fn01 = function(){
		console.log('test01()...');
	};
	
	fn01();
	
	let obj = {};
	obj.name = 'kim';
	obj.fn02 = function(){
		console.log('test02()...');
	};
	obj.fn02();
	
	
	
	//2. 함수를 리턴문에 할당
	function start(){
		console.log('start()...');
		let count = 0;
		return function(){
			console.log('return fn...');
			return 100 + ++count;
		};
	}
	console.log(start()());
	console.log(start()());
	console.log(start()());
	console.log('============');
	
	//클로져함수 - 함수가 리턴한 함수를 할당받은 변수
	let fn3 = start();
	console.log(fn3());
	console.log(fn3());
	console.log(fn3());
	
	
	console.log('============');
	//3. 함수를 콜할때 인자에 할당(매개변수로 전달)
	function stop(fn){
		console.log('stop()...')
		console.log(fn);
		fn();
	}
	
	
	//callback 구조-함수콜할때 인자로 전달된 함수가 콜된 함수내부에서 콜되는 구조
	stop(function(){
		console.log('arg fn...');
	});
	
	
	//설정된 시간마다 전달된 함수를 실행 - interval_id를 반환받을 수 있으며 clearInterval로 정지가능
// 	setInterval(무명함수,시간-밀리초);
	let interval_id = setInterval(function(){
		console.log('setInterval fn...');
	},1000);
	console.log('interval_id : ', interval_id);
	
	//설정된 시간 경과 후 전달된 함수를 1번만 실행
	//setTimeout(무명함수,시간-밀리초);
	setTimeout(function(){
		console.log('setTimeout fn...');
		clearInterval(interval_id);
		
		console.log('clearInterval..');
	},5000);
</script>
</head>
<body>
	<h1>js05_fn_first_class.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>