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

</head>
<body>
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
	
	<script type="text/javascript">
	if('${user_id}'==='${vo2.writer}'){
		$('#b_up_del').show();
	}else{
		$('#b_up_del').hide();
	}
</script>
</body>
</html>



