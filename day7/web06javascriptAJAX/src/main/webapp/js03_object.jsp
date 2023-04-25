<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//객체 초기화 방법1.
	let obj = {};
	console.log(obj);
	
	obj = {name:'kim',age:33,arr:[11,22,33]};
	obj.addr = 'seoul';
	obj['tel'] = '010';
	console.log(obj.id);//undefined
	console.log(obj['name']);//kim
	console.log(obj);
	console.log('==========================');
	
	for ( var key in obj) {
		console.log(obj[key]);
	}
	
	console.log('==========================');
	//객체 초기화 방법2.
	let obj2 =  new Object();
	obj2.name = 'lee';
	obj2.age = 44;
	console.log(obj2);
	console.log(obj2.name, obj2['name']);
	
	
	
	//객체 초기화 방법3.-사용자 정의 함수
	function Person(){}
	let obj3 = new Person();
	console.log(obj3);

	
	//객체 초기화 방법4.-사용자 정의 class : ES6
	class Student{}
	let obj4 = new Student();
	console.log(obj4);
	
</script>

</head>
<body>
	<h1>js03_object.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>