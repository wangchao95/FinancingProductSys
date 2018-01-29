<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/addProfuct.js"></script>
<title>新增的页面</title>
</head>
<body>
	<div id="addProduct">
		<h2>新增理财信息</h2>
		  <form action="FinancingproductServlet?action=add" id='addProduct' method="post">	     
	      <p>
	        <label> 产品代码: </label>
	        <input name="code" type="text" class="opt_input" id="code" />
	      </p>
	      <p>
	        <label> 风险评级: </label>
	      	<select id="risk" name="risk">
				<option value="0">--请选择--</option>
				<option value="1">R1</option>
				<option value="2">R2</option>
				<option value="3">R3</option>			
			</select>
	      </p>
	      <p>
	        <label> 预期收益: </label>
	        <input name="income" type="text" id="income"/>
	      </p>
	      <p>
	        <label>发售起始日: </label>
	        <input name="saleStarting" type="text" id="saleStarting"/>
	      </p>
	       <p>
	        <label>发售截止日: </label>
	        <input name="saleEnd" type="text" id="saleEnd"/>
	      </p>
	       <p>
	        <label>产品到期日: </label>
	        <input name="end" type="text" id="end"/>
	      </p>
	      <input type="submit" value="保存" id="addProduct" class="opt_sub" />
	      <input type="reset" value="返回" class="back" />
	    </form>	
	</div>
</body>
</html>