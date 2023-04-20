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
				<a href="update.do?wnum=${param.wnum}">글수정</a> 
				<a href="deleteOK.do?wnum=${param.wnum}">글삭제</a> 
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>



