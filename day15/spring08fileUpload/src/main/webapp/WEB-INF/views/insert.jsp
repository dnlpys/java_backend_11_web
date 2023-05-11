<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertOK.do" method="post" enctype="multipart/form-data">
		<table class="type11">
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="park"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="38"></td>
				</tr>
				<tr>
					<td>프로필사진</td>
					<td><input type="file" name="multipartFile"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="입력완료" class="myButton"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>