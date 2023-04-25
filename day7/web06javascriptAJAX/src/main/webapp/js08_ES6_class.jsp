<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('js08_ES6_class.jsp');
	
	class Person{
		age = 33;
		constructor(){
			console.log('Person constructor()');
		}
		sleep(){
			console.log('Person sleep()');
		}
	}
	
	class Student extends Person{
		kor = 99;//public
		tel = '02';
		#tel = '010';//private ES2022
		static name = 'Hong';
		
		constructor(){
			super();//상속시 반드시 표기.생략불가
			console.log('Student constructor()');
		}
		
		study(){
			console.log('study()...');
			this.#yaja();
		}
		#yaja(){
			console.log('#yaja()...');
		}
		
		static eat(){
			console.log('static eat()...');
		}
		static #drink(){
			console.log('static #drink()...');
		}
		
	}//end class
	
	console.log('static name:',Student.name);
	Student.eat();
	
	let st = new Student();
	console.log('st.kor:',st.kor);
	console.log('st.tel:',st.tel);
// 	console.log('st.#tel:',st.#tel);//error private
	st.study();
// 	st.#yaja(); // error private
	st.sleep();//extends Person
	console.log('st.age:',st.age);//extends Person
	
</script>
</head>
<body>
	<h1>js08_ES6_class.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>