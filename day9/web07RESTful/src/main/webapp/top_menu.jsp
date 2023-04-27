<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href="index.do">index.do</a>
<a href="insert.do">insert.do</a>
<a href="selectAll.do">selectAll.do</a>
<a href="login.do" id="login">login.do</a>
<a href="logout.do" id="logout">logout.do</a>
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
