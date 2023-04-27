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
	<h1>글쓰기</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="insertOK.do" method="post">
		<table border="1">
			<tbody>
				<tr>
					<th>title</th>
					<td><input type="text" name="title" value="jsp&servlet"></td>
				</tr>
				<tr>
					<th>content</th>
					<td><textarea name="content" rows="10" cols="20">Good JSP & Servlet</textarea></td>
				</tr>
				<tr>
					<th>writer</th>
					<td><input type="text" name="writer" value="tester"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<input type="submit" value="작성완료">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>



