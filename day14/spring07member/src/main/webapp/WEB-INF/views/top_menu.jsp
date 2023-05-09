<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
  <li> <a href="index.do">홈</a> </li>
  <li id="m_insert"> <a href="m_insert.do">회원가입</a> </li>
  <li id="m_selectAll"> <a href="m_selectAll.do">회원목록</a> </li>
  <li id="b_insert"> <a href="b_insert.do">글쓰기</a> </li>
  <li id="b_selectAll"> <a href="b_selectAll.do">글목록</a> </li>
  <li id="re_insert"> <a href="re_insert.do">영화예매</a> </li>
  <li id="re_selectAll"> <a href="re_selectAll.do?user_id=${user_id}">예매목록</a> </li>
  <li id="login"> <a href="login.do">로그인</a> </li>
  <li id="logout"> <a href="logout.do">로그아웃</a> </li>
</ul>
<hr>
<script type="text/javascript">
// 	if('${user_id}'===''){
// 		$('#login').show();
// 		$('#logout').hide();
// 		$('#m_selectAll').hide();
// 		$('#b_insert').hide();
// 		$('#b_selectAll').hide();
// 		$('#re_selectAll').hide();
// 	}else{
// 		$('#login').hide();
// 		$('#m_insert').hide();
// 		$('#logout').show();
// 		$('#m_selectAll').show();
// 		$('#b_insert').show();
// 		$('#b_selectAll').show();
// 		$('#re_selectAll').show();
// 	}
</script>
