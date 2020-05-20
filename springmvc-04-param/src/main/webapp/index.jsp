<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
	</head>
	<body>
		<h2>测试数组</h2>
		<form action="${pageContext.request.contextPath}/complex/array" method="post">
			爱好:
			<input type="checkbox" name="hobby" value="踢球">踢球
			<input type="checkbox" name="hobby" value="听歌">听歌
			<input type="checkbox" name="hobby" value="看书">看书
			<br>
			<input  type="submit" value="提交">
		</form>
		
		
		<h2>测试list传参</h2>
		<form action="${pageContext.request.contextPath}/complex/list" method="post">
			爱好:
			<input type="checkbox" name="hobbyList" value="踢球">踢球
			<input type="checkbox" name="hobbyList" value="听歌">听歌
			<input type="checkbox" name="hobbyList" value="看书">看书
			<br>
			<input  type="submit" value="提交">
		</form>
		
		<hr>
		<button id="testMap" type="button">测试map传参</button>
		
		<hr>
		<button onclick="jsonToMap()" type="button">测试json转传参</button>
		<hr>
		<button onclick="jsonToList()" type="button">测试json zhuan List传参</button>
		
		<hr>
		<button onclick="jsonToBean()" type="button">测试json 转 java bean传参</button>
		
		<script src="${pageContext.request.contextPath}/static/js/jquery.min.js" ></script>
		
		<script type="text/javascript">
			const path = "${pageContext.request.contextPath}"
			//测试map传参
			$(function(){
				$('#testMap').click(()=>{
					$.ajax({
						url:path+'/complex/map',
						type:"post",
						dataType:"text",
						data:"stuMap['id']=1&stuMap['name']=zhangsan",
						success:function(data){
							alert(data)
						}
					})
				})
			})
			function jsonToMap(){
				//这是js对象
				let obj = {id:1,name:"liepgng"}
				$.ajax({
					url:path+'/json/jsonToMap',
					type:'post',
					//将js对象转换成json字符串
					data:JSON.stringify(obj),
					dataType:'json',
					contentType:'application/json;charset=utf-8',
					success:function(data){
						alert(data.msg)
					}
				})	
			}
			//json转list
			function jsonToList(){
				let array = [{id:2,name:"etoak",age:30}]
				let user = {id:1,name:"et1911",age:33}
				array.push(user)
				
				$.ajax({
					url:path+"/json/jsonToList",
					type:'post',
					data:JSON.stringify(array),
					dataType:'json',
					contentType:'application/json;charset=utf-8',
					success:function(data){
						alert(data.code + "-" + data.msg)
					}
					
				})
			}
			
			function jsonToBean(){
				
				let obj = {
						id:1,
						name:"李彭刚",
						age:22,
						hobbyList:["看书","听歌"],
						stuMap:{id:2,score:200}
				}
				
				$.ajax({
					url: path + "/json/jsonToBean",
					type:'post',
					data:JSON.stringify(obj),
					contentType:'application/json;charset=utf-8',
					success:function(data){
						alert(data.code + ':'+ data.msg)
					}
				})
			}
			
			
			
			
				
			
			
			
		</script>
	</body>
</html>
