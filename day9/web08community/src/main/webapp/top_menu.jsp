<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href="index.do">홈</a>

<a href="m_insert.do">회원가입</a>
<a href="b_insert.do">글쓰기</a>

<a href="m_selectAll.do">회원목록</a>
<a href="b_selectAll.do">글목록</a>


<a href="login.do" id="login">로그인</a>
<a href="logout.do" id="logout">로그아웃</a>
<hr>
<a href="json_idCheck.do?id=admin">json_idCheck.do?id=admin</a>
<a href="json_selectAll.do">json_selectAll.do</a>
<a href="json_selectOne.do?num=47">json_selectOne.do?num=47</a>
<hr>
<script type="text/javascript">
	if('${user_id}'===''){
		$('#login').show();
		$('#logout').hide();
	}else{
		$('#login').hide();
		$('#logout').show();
	}
</script>
