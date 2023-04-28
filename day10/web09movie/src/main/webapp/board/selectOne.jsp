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

	function selectAll(cnum=0){
		console.log('selectAll()....cnum:',cnum);
		$.ajax({
			url : "c_selectAll.do",
			data:{
				wnum:${param.wnum}
			},
			method:'GET',//default get
// 			method:'POST',
			dataType:'json', //xml,text
			success : function(vos) {
				console.log('ajax...success:', vos);//[{},{}...]
				let tag_txt = '';
				
				$.each(vos,function(index,vo){
// 					console.log(vo);
					let tag_td = `<td>\${vo.content}</td>`;
					if(cnum==vo.cnum) tag_td = `<td><input type="text" value="수정글" id="input_content"><button onclick="updateOK(\${vo.cnum})">수정완료</button></td>`;
					let tag_div = ``;
					if('${user_id}'===vo.writer){
						tag_div = `<div>
							<button onclick="deleteOK(\${vo.cnum})">댓글삭제</button>
							<button onclick="selectAll(\${vo.cnum})">댓글수정</button>
						</div>`;
					}
					tag_txt += `
						<tr>
							<td>댓글번호</td>
							<td>내용</td>
							<td>작성자</td>
							<td>작성일자</td>
							<td></td>
						</tr>
						<tr>
							<td>\${vo.cnum}</td>
							\${tag_td}
							<td>\${vo.writer}</td>
							<td>\${vo.wdate}</td>
							<td>
								\${tag_div}
							</td>
						</tr>
					`;
				});
				
				$('#comm_list').html(tag_txt);
				
			},
			error:function(xhr,status,error){
				console.log('xhr.status:', xhr.status);
			}
		});
		
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
	
	function updateOK(cnum=0){
		console.log('updateOK()....',cnum);
		console.log($('#input_content').val());
		
		$.ajax({
			url : "c_updateOK.do",
			data:{
				cnum:cnum,
				content:$('#input_content').val()
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
		
	}//end updateOK
	
	function deleteOK(cnum=0){
		console.log('deleteOK()....',cnum);
		
		$.ajax({
			url : "c_deleteOK.do",
			data:{
				cnum:cnum
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
		
	}//end deleteOK

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
	<h3>댓글 작성</h3>
	<table border="1">
		<tr>
			<td>댓글</td>
			<td><input type="text" id="comm_content" value="댓글입니다."></td>
		</tr>
		<tr>
			<td></td>
			<td><button onclick="insertOK()">작성완료</button></td>
		</tr>
	</table>
	<hr>
	<h3>댓글 리스트</h3>
	<table border="1">
		<tbody id="comm_list">
		</tbody>
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



