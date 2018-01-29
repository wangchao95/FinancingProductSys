jQuery.noConflict();   
jQuery(document).ready(function($){
	function showInfo(name,sex,pageIndex){			
		var  code=$("#code").val();
		var risk=$("#risk").val();
		var data="";
		if(code!=null&&code!=""){
			data+="code="+code;
		}
		//判断
		if(risk!=null&&risk!="0"){
			data+="&risk="+risk;
		}		
		//请求
		$.getJSON("FinancingproductServlet?action=Prolist",data,function(data){			
			//回调函数
			var product;  //获得信息
			var $table=$("#table");	
			$table.html("");  //先清空页面
			$table.append($("<tr><td>产品代码</td><td>风险评级</td><td>预期收益</td><td>发售起始日</td><td>发售截止日</td><td>产品到期时间</td></tr>"));
			for(var i=0;i<data[1].length;i++){
				product=data[1][i];
				$table.append($(											
				"<tr><td>"+product.id+"</td><td>"+product.risk+"</td><td>"+product.income+"</td><td>"+product.saleStarting+"</td><td>"+product.saleEnd+"</td><td>"+product.end+"</td></tr>"));	
				
			}
		})
	}	
	showInfo();   //加载时先初始化一些数据
	
	$("#btn").click(function(){
		showInfo();
	});
});