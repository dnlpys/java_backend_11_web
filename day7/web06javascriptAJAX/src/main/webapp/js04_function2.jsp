<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('function....');
	
	function test01(x={}){
		console.log('test01()....',x.name);
		for ( var key in x) {
			console.log(x[key]);
		}
	}
	test01();
	test01({name:'lee',age:33,tel:'010'});
	
	
	function test02(x=[]){
		console.log('test02()....',x[0], x.length);
		for ( var i in x) {
			console.log(x[i]);
		}
	}
	test02();
	test02([11,22,33]);
	
	function test03(arr=[],obj={}){
		console.log('test03()...',arr,obj)
	}
	test03();
	test03([44,55,66],{id:'admin',pw:'hi1212'});
	
	
	//모든 인자를 배열로 받을수 있는 매개변수 선언(...변수명)
	function test04(x,...args){
// 		console.log('test04()...',arguments)
		console.log('test04()...',args)
		console.log('test04()...',x,args)
	}
	
	test04(11);
	test04(11,22,33,44);
	test04(11,22,33,44,55,66,77);
	
	
	
</script>
</head>
<body>
	<h1>js04_function2.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>