<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>selectOne.jsp ${param.num}</h1>
	
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
	<tbody>
			<tr>
				<td>${vo2.num}</td>
				<td>${vo2.id}</td>
				<td>${vo2.pw}</td>
				<td>${vo2.name}</td>
				<td>${vo2.tel}</td>
			</tr>
	</tbody>
	</table>
	
</body>
</html>