<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

</head>
<body>
	<h1>index.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
	<h1>${user_id}</h1>
	<h1>${user_name}</h1>
	
</body>
</html>