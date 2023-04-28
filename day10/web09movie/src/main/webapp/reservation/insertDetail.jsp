<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>


</head>
<body>
	<h1>영화예매</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<table border="1">
	<thead>
		<tr>
			<th>num</th>
		</tr>
	</thead>
	<tbody id="vo2">
		<form action="re_insertOK.do" method="get">
			<input type="datetime-local" name="movie_date">
			<input type="submit">
		</form>	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<a href="m_update.do?num=${param.num}">회원수정</a>
				<a href="m_deleteOK.do?num=${param.num}">회원삭제</a>
			</td>
		</tr>
	</tfoot>
	</table>
	
</body>
</html>