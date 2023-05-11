<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="insert.do">insert.do</a>
<a href="selectAll.do">selectAll.do</a>

<a href="login.do">login.do</a>
<a href="logout.do">logout.do</a>
</body>
</html>
