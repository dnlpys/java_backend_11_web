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
	<h1>글수정</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="updateOK.do" method="post">
		<table border="1">
			<tbody>
				<tr>
					<th>wnum</th>
					<td>${vo2.wnum}<input type="hidden" name="wnum" value="${vo2.wnum}"></td>
				</tr>
				<tr>
					<th>title</th>
					<td><input type="text" name="title" value="${vo2.title}"></td>
				</tr>
				<tr>
					<th>content</th>
					<td><textarea name="content" rows="10" cols="20">${vo2.content}</textarea></td>
				</tr>
				<tr>
					<th>wdate</th>
					<td>${vo2.wdate}</td>
				</tr>
				<tr>
					<th>writer</th>
					<td>${vo2.writer}</td>
				</tr>
				<tr>
					<th>vcount</th>
					<td>${vo2.vcount}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<input type="submit" value="수정완료">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>



