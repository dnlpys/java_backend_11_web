<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	//배열초기화 방법1.
	let arr = [5];
	//배열의 요소는 모든 타입 가능
// 	let arr = [11,22,'kim',null,false,undefined,[1,2,3],{name:'lee'},function(){}];
	
	console.log(arr,arr.length);
	
	arr = [11,22,33];
	console.log(arr,arr.length);
	
	console.log(arr[0]);
	console.log(arr[1]);
	console.log(arr[2]);
	console.log(arr['2']);
	console.log('=====================');
	
	for (let i = 0; i < arr.length; i++) {
		if(arr[i]%2==0) console.log(arr[i]); //짝수 데이터만 출력
// 		if(i%2==0) console.log(arr[i]); //짝수번째 방 데이터만 출력
	}
	console.log('=====================');
	for ( let i in arr) {
		console.log(i,arr[i]);//주의:i변수는 string
	}
	
	console.log('=====================');
	
	let multi_arr = [[11,22,33],[44,55,66,77]];
	
	for (let x = 0; x < multi_arr.length; x++) {
		for (let i = 0; i < multi_arr[x].length; i++) {
			console.log(multi_arr[x][i]); 
		}
	}
	console.log('=====================');
	for ( let x in multi_arr) {
		for ( let i in multi_arr[x]) {
			console.log(x,i,multi_arr[x][i]);
		}
	}
	console.log('=====================');
	
	let datas = ['aaa','bbb','ccc','ddd'];
	console.log(datas);
	
	//item 추가 - 가장마지막
	datas.push('eee');	
	datas.push('fff','xxx','yyy');	
	console.log(datas);
	
	//item 뽑기 및 제거 -  - 가장마지막
	console.log(datas.pop()); //yyy
	console.log(datas.pop()); //xxx
	console.log(datas);

	//item 추가 - 가장앞
	datas.unshift(111);
	datas.unshift(222,333,444);
	console.log(datas);
	
	//item 뽑기 및 제거 -  - 가장앞
	console.log(datas.shift());//222
	console.log(datas.shift());//333
	console.log(datas);
	
	//배열초기화 방법2.
	let ds = new Array();//[]
	console.log(ds, ds.length);
	
	ds = new Array(5);//[빈*5]
	console.log(ds, ds.length);
	for (var i = 0; i < ds.length; i++) {
		console.log(ds[i]);
	}
	
	ds = new Array(5,5,5);//[5,5,5]
	console.log(ds, ds.length);
	for (var i = 0; i < ds.length; i++) {
		console.log(ds[i]);
	}
	
	//주의사항: 배열의 인덱스가 자유롭다.(왜? 인덱스가 속성형식을 갖기때문)
	ds = [11,22,33];//11,22,33, , , , , , , ,99
	ds[10] = 99;
	console.log(ds[10],ds.length);
	for (var i = 0; i < ds.length; i++) {
		console.log(ds[i]);
	}
	
	
	console.log("=====");
	var cnt;//undefined
	console.log(cnt + 1,typeof(cnt + 1),0/0);//NaN
	
	console.log(typeof(Infinity),10/0,-10/0);//Infinity,-Infinity
	
	
</script>
</head>
<body>
	<h1>js02_array.jsp</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
</body>
</html>