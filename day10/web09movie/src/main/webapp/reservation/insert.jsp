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
	$(function(){
		$.ajax({
			url : "mv_selectAll.do",
// 			data:{},
			method:'GET',//default get
// 			method:'POST',
			dataType:'json', //xml,text
			success : function(arr) {
				console.log('ajax...success:', arr);//{}
				
	 			let tag_vos = '';
	 			
	 			$.each(arr,function(index,vo){
	 				console.log(index,vo);
	 				tag_vos += `
	 					<tr>
	 					<td>\${vo.num}</td>
	 					<td>\${vo.title}</td>
	 					<td>\${vo.price}</td>
	 					<td>\${vo.producer}</td>
	 					<td>				
 						<a href="re_selectOne.do?num=\${vo.num}">예약하기</a>
 					</td>
	 				</tr>
	 				`;
	 			});
				
				$("#vos").html(tag_vos);
			},
			error:function(xhr,status,error){
				console.log('xhr.status:', xhr.status);
			}
		});//end $.ajax()...
	});//end onload...
	
	
	
	
</script>
</head>
<body>
	<h1>영화목록 ${user_id}</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
		
	<table border="1">
	<thead>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>producer</th>
			<th>price</th>
			<th></th>
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



