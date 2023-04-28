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
	<h1>글쓰기 ${user_id}</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="b_insertOK.do" method="post">
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
					<td>${user_id}<input type="hidden" name="writer" value="${user_id}"></td>
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



