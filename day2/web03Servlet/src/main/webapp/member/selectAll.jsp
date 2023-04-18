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
	<h1>selectAll.jsp</h1>

	<form action="searchList.do" method="get">
		<select name="searchKey">
			<option value="name">name</option>
			<option value="tel">tel</option>
		</select>
		<input type="submit">
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
<%-- 		<c:forEach var="i" begin="1" end="10" step="1"> --%>
<!-- 			<tr> -->
<%-- 				<td>${i}</td> --%>
<!-- 				<td>admin</td> -->
<!-- 				<td>hi11</td> -->
<!-- 				<td>kim</td> -->
<!-- 				<td>011</td> -->
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.num}</td>
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