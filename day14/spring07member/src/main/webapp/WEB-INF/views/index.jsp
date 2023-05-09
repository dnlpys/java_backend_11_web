<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:include page="css.jsp"></jsp:include>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
// 	localStorage.setItem('name','kim');
// 	sessionStorage.setItem('tel','010');
</script>
</head>
<body>
	<h1>index.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
	<h1>${user_id}</h1>
	<h1>${user_name}</h1>
	<h1>${cookie.user_name.value}</h1>
	
</body>
</html>