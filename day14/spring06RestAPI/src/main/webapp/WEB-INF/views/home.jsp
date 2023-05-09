<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="json_test.do">json_test.do</a>
	<a href="json_vo.do">json_vo.do</a>
	<a href="json_vos.do">json_vos.do</a>
	<a href="json_map.do">json_map.do</a>
</body>
</html>
