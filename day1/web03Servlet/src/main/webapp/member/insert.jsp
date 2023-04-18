<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//코딩부-스크립트릿 태그
String name = "kim22222";
request.setAttribute("name", name);

List<Integer> sus = new ArrayList<>();
sus.add(10000);
sus.add(20000);
sus.add(30000);
request.setAttribute("sus", sus);

// for (Integer x : sus) {
// 	System.out.println(x);
// 	out.println(x);
// }

String id = request.getParameter("id");
String pw = request.getParameter("pw");
System.out.println(id);
System.out.println(pw);
// out.println(id);
// out.println(pw);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var name = 'lee';
</script>
</head>
<body>
	<h1>insert.jsp</h1>
	<h1>${param.id} ${param.pw}</h1>
	JSTL-core
	<c:forEach var="x" items="${sus}">
		<c:if test="${x==10000}">
			<h1>${x}</h1>
		</c:if>
		<c:choose>
			<c:when test="${x==10000}">일만</c:when>
			<c:when test="${x==20000}">이만</c:when>
			<c:otherwise>삼만</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:set var="su" value="89"></c:set>
	<h1>${su}</h1>
	<c:choose>
		<c:when test="${su>=90}">A</c:when>
		<c:when test="${su>=80}">B</c:when>
		<c:otherwise>C</c:otherwise>
	</c:choose>
	<hr>

	<%=name%>
	<%=request.getAttribute("name")%>
	<hr>
	EL(표현언어) - ${name}



	<hr>
	회원가입입력폼 만드세요. 전송방식:get id,pw,name,tel

	<form action="insertOK.do" method="get">
		id:<input type="text" name="id" value="tester"><br> 
		pw:<input type="text" name="id" value="tester"><br>
		name:<input type="text" name="id" value="tester"><br> 
		tel:<input type="text" name="id" value="tester"><br>
		<input type="submit">
	</form>

</body>
</html>