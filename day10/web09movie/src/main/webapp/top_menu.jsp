<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href="index.do">홈</a>

<a href="m_insert.do" id="m_insert">회원가입</a>
<a href="m_selectAll.do" id="m_selectAll">회원목록</a>

<a href="b_insert.do" id="b_insert">글쓰기</a>
<a href="b_selectAll.do" id="b_selectAll">글목록</a>

<a href="re_insert.do" id="re_insert">영화예매</a>
<a href="re_selectAll.do" id="re_selectAll">예매목록</a>

<a href="login.do" id="login">로그인</a>
<a href="logout.do" id="logout">로그아웃</a>

<hr>
<script type="text/javascript">
	if('${user_id}'===''){
		$('#login').show();
		$('#logout').hide();
		$('#m_selectAll').hide();
		$('#b_insert').hide();
		$('#b_selectAll').hide();
		$('#re_selectAll').hide();
	}else{
		$('#login').hide();
		$('#m_insert').hide();
		$('#logout').show();
		$('#m_selectAll').show();
		$('#b_insert').show();
		$('#b_selectAll').show();
		$('#re_selectAll').show();
	}
</script>
