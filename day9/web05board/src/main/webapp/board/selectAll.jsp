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
	<h1>글목록</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="searchList.do" method="get">
		<select name="searchKey">
			<option value="title">title</option>
			<option value="content">content</option>
		</select>
		<input type="text" name="searchWord" value="sp">
		<input type="submit" value="검색">
	</form>

	<table border="1">
	<thead>
		<tr>
			<th>wnum</th>
			<th>title</th>
			<th>writer</th>
			<th>wdate</th>
			<th>vcount</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>				
					<a href="selectOne.do?wnum=${vo.wnum}">${vo.wnum}</a>
				</td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.wdate}</td>
				<td>${vo.vcount}</td>
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



