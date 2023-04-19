<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>

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
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>				
					<a href="selectOne.do?num=${vo.num}">${vo.num}</a>
				</td>
				<td>${vo.id}</td>
				<td>${vo.pw}</td>
				<td>${vo.name}</td>
				<td>${vo.tel}</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">1 2 3 4 5</td>
		</tr>
	</tfoot>
	</table>
</body>
</html>



