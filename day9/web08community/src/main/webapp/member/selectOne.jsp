<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script type="text/javascript">
// //1.javascript ajax
// 	window.onload = function(){
// 		console.log('selectOne()....');
// 		const xhttp = new XMLHttpRequest();
// 		xhttp.onload = function() {
// // 			console.log(this.responseText);//JSON.parse>>  display
// 			let vo2 = JSON.parse(this.responseText);
// 			console.log(vo2);
		
// 			let tag_vo = `
// 				<tr>
// 					<td>\${vo2.num}</td>
// 					<td>\${vo2.id}</td>
// 					<td>\${vo2.pw}</td>
// 					<td>\${vo2.name}</td>
// 					<td>\${vo2.tel}</td>
// 				</tr>
// 			`;
			
// 			document.getElementById("vo2").innerHTML = tag_vo;
// 		};
// 		xhttp.open("GET", "json_selectOne.do?num="+${param.num});
// 		xhttp.send();
// 	};//end selectOne

//2.jquery ajax
	$(function(){
		$.ajax({
			url : "json_selectOne.do",
			data:{num:${param.num}},
			method:'GET',//default get
// 			method:'POST',
			dataType:'json', //xml,text
			success : function(vo2) {
				console.log('ajax...success:', vo2);//{}
				let tag_vo = `
	 				<tr>
	 					<td>\${vo2.num}</td>
	 					<td>\${vo2.id}</td>
	 					<td>\${vo2.pw}</td>
	 					<td>\${vo2.name}</td>
	 					<td>\${vo2.tel}</td>
	 				</tr>
	 			`;
				
				$("#vo2").html(tag_vo);
			},
			error:function(xhr,status,error){
				console.log('xhr.status:', xhr.status);
// 				console.log('status:', status);
// 				console.log('error:', error);
			}
		});
	});

</script>
</head>
<body>
	<h1>회원정보</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<table border="1">
	<thead>
		<tr>
			<th>num</th>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>tel</th>
		</tr>
	</thead>
	<tbody id="vo2">
			
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<a href="update.do?num=${param.num}">회원수정</a>
				<a href="deleteOK.do?num=${param.num}">회원삭제</a>
			</td>
		</tr>
	</tfoot>
	</table>
	
</body>
</html>