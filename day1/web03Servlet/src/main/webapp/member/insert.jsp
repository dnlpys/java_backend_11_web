<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insert.jsp</h1>
	
	회원가입입력폼 만드세요. 전송방식:get
	id,pw,name,tel
	
	<form action="insertOK.do" method="get">
		id:<input type="text"><br>
		pw:<input type="text"><br>
		name:<input type="text"><br>
		tel:<input type="text"><br>
		<input type="submit">
	</form>
	
</body>
</html>