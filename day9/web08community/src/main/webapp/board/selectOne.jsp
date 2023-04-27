<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

	function selectAll(){
		console.log('selectAll()....');
		
		
	}

	function insertOK(){
		console.log('insertOK()....');
		$.ajax({
			url : "c_insertOK.do",
			data:{
				wnum:${param.wnum},
				content:$('#comm_content').val(),
				writer:'${user_id}'
			},
			method:'GET',//default get
// 			method:'POST',
			dataType:'json', //xml,text
			success : function(obj) {
				console.log('ajax...success:', obj);//{"result":1}
				if(obj.result==1) selectAll();
			},
			error:function(xhr,status,error){
				console.log('xhr.status:', xhr.status);
			}
		});
		
	}//end insertOK
	
	function updateOK(){
		console.log('updateOK()....');
		
		
	}//end updateOK
	
	function deleteOK(){
		console.log('deleteOK()....');
		
		
	}//end updateOK

</script>
</head>
<body onload="selectAll()">
	<h1>글정보</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>

	<table border="1">
		<tbody>
			<tr>
				<th>wnum</th><td>${vo2.wnum}</td>
			</tr>
			<tr>
				<th>title</th><td>${vo2.title}</td>
			</tr>
			<tr>
				<th>content</th>
				<td>
					<p id="content" style="width:100px;height:50px;">${vo2.content}</p>
				</td>
			</tr>
			<tr>
				<th>wdate</th><td>${vo2.wdate}</td>
			</tr>
			<tr>
				<th>writer</th><td>${vo2.writer}</td>
			</tr>
			<tr>
				<th>vcount</th><td>${vo2.vcount}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					<div id="b_up_del">
						<a href="b_update.do?wnum=${param.wnum}">글수정</a> 
						<a href="b_deleteOK.do?wnum=${param.wnum}">글삭제</a>
					</div> 
				</td>
			</tr>
		</tfoot>
	</table>
	<hr>
	<table border="1">
		<tr>
			<td>댓글</td>
			<td>내용</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="text" id="comm_content" value="댓글입니다."></td>
		</tr>
		<tr>
			<td></td>
			<td><button onclick="insertOK()">작성완료</button></td>
		</tr>
	</table>
	
	
	
	
<script type="text/javascript">
	if('${user_id}'==='${vo2.writer}'){
		$('#b_up_del').show();
	}else{
		$('#b_up_del').hide();
	}
</script>
</body>
</html>



