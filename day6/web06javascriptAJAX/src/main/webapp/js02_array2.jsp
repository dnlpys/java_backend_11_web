<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	console.log('start head script...');
	
	let infos = [[1,'kim1',11],[2,'kim2',12]];
	
</script>
</head>
<body>
	<h1>js02_array.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>

	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody id="rows">
			
			
		</tbody>
	</table>

	<script type="text/javascript">
		console.log('start body script...');
		
		let rows = document.querySelector('#rows');
		console.log(rows);
		let tr = '';
		
		for (let i = 0; i < infos.length; i++) {
// 			tr += '<tr><td>'+infos[i][0]+'</td><td>'+infos[i][1]+'</td><td>'+infos[i][2]+'</td></tr>';
			tr += `<tr>
					<td>\${infos[i][0]}</td>
					<td>\${infos[i][1]}</td>
					<td>\${infos[i][2]}</td>
				   </tr>`;
		}
		
		rows.innerHTML = tr;
		
	</script>
</body>
</html>