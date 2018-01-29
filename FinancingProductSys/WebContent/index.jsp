<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
	<div id="all">
		<form action="" method="post" id="forms">
			产品代码:<input type="text" name="code" id="code" value=""/>
			风险评级:<select id="risk" name="risk">
				<option value="0">请选择</option>
				<option value="1">R1</option>
				<option value="2">R2</option>
				<option value="3">R3</option>
			</select>
			<input type="button" name="button" value="查询" id="btn"/>
			<a href="addProduct.jsp"  style='font-size:18px;'>新增理财信息</a>
		</form>

		<div id="allTable">
			<table border="2" id="table" style='width:500px;float:left'>
				
			</table>			
		</div>		
	</div>
</body>
</html>