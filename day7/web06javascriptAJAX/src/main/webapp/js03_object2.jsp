<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//객체 초기화 방법1.
	let vo = {
		num : 1,
		id : 'admin1',
		pw : 'hi111',
		name : 'kim1',
		tel : '011'
	};
	console.log(vo);
	let vos = [];//5개~,1,2,3,4,5

	for (var i = 0; i < 5; i++) {
		vos.push({
			num : i + 1,
			id : 'admin' + (i + 1),
			pw : 'hi111' + (i + 1),
			name : 'kim1' + (i + 1),
			tel : '011' + (i + 1)
		});
	}
	console.log(vos);
</script>
</head>
<body>
	<h1>js03_object2.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>tel</th>
			</tr>
		</thead>
		<tbody id="rows">
		</tbody>
	</table>
	<script type="text/javascript">
	let rows = document.querySelector('#rows');
	console.log(rows);
	let tr = '';
	// \${}
	for (let i = 0; i < vos.length; i++) {
		tr += `<tr>
				<td>\${vos[i].num}</td>
				<td>\${vos[i].id}</td>
				<td>\${vos[i].pw}</td>
				<td>\${vos[i].name}</td>
				<td>\${vos[i].tel}</td>
			   </tr>`;
	}
	
	rows.innerHTML = tr;
	</script>
</body>
</html>