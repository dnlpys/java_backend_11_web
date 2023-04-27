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
//1.javascript ajax
// 	window.onload = function(){
// 		console.log('selectAll()....');
// 		const xhttp = new XMLHttpRequest();
// 		xhttp.onload = function() {
// // 			console.log(this.responseText);//JSON.parse>> loop>> display
// 			let arr = JSON.parse(this.responseText);
// // 			console.log(arr);
			
// 			let tag_vos = '';
// 			for ( let i in arr) {
// 				let vo = arr[i];
// 				console.log(vo.num,vo.id,vo.pw,vo.name,vo.tel);
// 				tag_vos += `
// 					<tr>
// 					<td>				
// 						<a href="selectOne.do?num=\${vo.num}">\${vo.num}</a>
// 					</td>
// 					<td>\${vo.id}</td>
// 					<td>\${vo.pw}</td>
// 					<td>\${vo.name}</td>
// 					<td>\${vo.tel}</td>
// 				</tr>
// 				`;
// 			}
// 			document.getElementById("vos").innerHTML = tag_vos;
// 		};
// 		xhttp.open("GET", "json_selectAll.do");
// 		xhttp.send();
// 	};//end selectAll
	
	//2.jquery ajax
	$(function(){
		$.ajax({
			url : "json_selectAll.do",
// 			data:{},
			method:'GET',//default get
// 			method:'POST',
			dataType:'json', //xml,text
			success : function(arr) {
				console.log('ajax...success:', arr);//{}
				
	 			let tag_vos = '';
// 	 			for ( let i in arr) {
// 	 				let vo = arr[i];
// 	 				console.log(vo.num,vo.id,vo.pw,vo.name,vo.tel);
// 	 				tag_vos += `
// 	 					<tr>
// 	 					<td>				
// 	 						<a href="selectOne.do?num=\${vo.num}">\${vo.num}</a>
// 	 					</td>
// 	 					<td>\${vo.id}</td>
// 	 					<td>\${vo.pw}</td>
// 	 					<td>\${vo.name}</td>
// 	 					<td>\${vo.tel}</td>
// 	 				</tr>
// 	 				`;
// 	 			}
	 			
	 			$.each(arr,function(index,vo){
	 				console.log(index,vo);
	 				console.log(vo.num,vo.id,vo.pw,vo.name,vo.tel);
	 				tag_vos += `
	 					<tr>
	 					<td>				
	 						<a href="selectOne.do?num=\${vo.num}">\${vo.num}</a>
	 					</td>
	 					<td>\${vo.id}</td>
	 					<td>\${vo.pw}</td>
	 					<td>\${vo.name}</td>
	 					<td>\${vo.tel}</td>
	 				</tr>
	 				`;
	 			});
				
				$("#vos").html(tag_vos);
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
	<h1>회원목록 ${user_id} ${user_name}</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	
	<form action="searchList.do" method="get">
		<select name="searchKey">
			<option value="name">name</option>
			<option value="tel">tel</option>
		</select>
		<input type="text" name="searchWord" value="ki">
		<input type="submit" value="검색">
	</form>

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
	<tbody id="vos">
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">1 2 3 4 5</td>
		</tr>
	</tfoot>
	</table>
	

</body>
</html>



