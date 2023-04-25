<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('function....3');
	
	function test01(){
		console.log('test01()....');
// 		return {};
		return {name:'yang',age:33};
	}
	let obj = test01();
	console.log(obj);
	
	
	function test02(){
		console.log('test02()....');
		return [11,22,33];
	}
	let arr = test02();
	console.log(arr);
	
	function test03(){
		console.log('test03()....');
		return [{model:'BMW',price:3000},{model:'OOOO',price:4000}]
	}
	
	//[{model:'BMW',price:3000},{model:'OOOO',price:4000}]
	let cars = test03();
	console.log(cars);
	console.log(cars[0].model);
	
	
	//js의 객체(배열)를 json형식의 문자열로 변환
	//[{"model":"BMW","price":3000},{"model":"OOOO","price":4000}]
	console.log(JSON.stringify(test03()));
	
	//json형식의 문자열을 js객체(배열)로 변환
	let str = '[{"model":"BMW","price":3000},{"model":"OOOO","price":4000}]';
	console.log(JSON.parse(str));
	console.log(JSON.parse(str)[0]);
	console.log(JSON.parse(str)[0].model);
	
	function test04(){
		console.log('test04()....')
		return {arr1:[11,22,33],arr2:[44,55,66,77],name:'kim'};
	}
	
	let obj_arr = test04();
	console.log(obj_arr);
	
	
	
	
</script>
</head>
<body>
	<h1>js04_function3.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>