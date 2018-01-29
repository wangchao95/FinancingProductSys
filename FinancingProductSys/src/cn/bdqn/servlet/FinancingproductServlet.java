package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.bdqn.entity.FinancingProduct;
import cn.bdqn.service.FinancingProductService;
import cn.bdqn.service.impl.FinancingProductServiceImpl;

public class FinancingproductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		String action=request.getParameter("action");		
		FinancingProductService financingProductService=new FinancingProductServiceImpl();  //鍒涘缓瀹炰綋
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();   //鑾峰緱涓�涓猳ut杈撳嚭鐨勫璞�
		String path=request.getContextPath();      //鑾峰緱涓婁笅鏂囪矾寰�
		HttpSession session=request.getSession();   //鑾峰緱璇锋眰鐨剆ession瀵硅薄		
		FinancingProduct pro=new FinancingProduct();
		if(action.equals("Prolist")) {			
			String id=request.getParameter("code");
			int risk=request.getParameter("risk")==null?0:Integer.parseInt(request.getParameter("risk"));
			List<FinancingProduct> proList=financingProductService.getProductByIdAndRisk(id, risk);
			//request.setAttribute("list", list);  //浼犻�掑埌鍙︿竴涓〉闈�
			//杞寲涓篔SON鏁版嵁
			String newsJSON=JSON.toJSONStringWithDateFormat(proList, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
			//缁檍s椤甸潰浼犺緭鏁版嵁
			out.print("[{\"risk\":\""+risk+"\"},"+newsJSON+"]");
		}else if(action.equals("add")) {
			//娣诲姞浜у搧鐨勬柟娉�			
			pro.setId(request.getParameter("code"));
			pro.setRisk(Integer.parseInt(request.getParameter("risk")));
			pro.setIncome(request.getParameter("income"));
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
			try {				
				pro.setSaleStarting(df.parse(request.getParameter("saleStarting")));
			} catch (ParseException e1) {			
				e1.printStackTrace();
			}			
			try {
				pro.setSaleEnd(df.parse(request.getParameter("saleEnd")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pro.setEnd(df.parse(request.getParameter("end")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			int count=financingProductService.addProduct(pro);
			if(count>0){		
				out.println("<script type=\"text/javascript\">");
	   			out.println("alert(\"褰撳墠浜у搧鍒涘缓鎴愬姛锛�,锛乗");
	   			out.println("location.href=/index.jsp");   //鍦╦s浠ｇ爜涓疄鐜拌繑鍥炲垪琛�	   			
	   			out.println("</script>");
			}else{
				out.println("<script type=\"text/javascript\">");
	   			out.println("alert(\"褰撳墠浜у搧鍒涘缓澶辫触锛�,璇烽噸鏂板垱寤猴紒\");");	
	   			out.println("location.href=/addProduct.jsp");   //鍦╦s浠ｇ爜涓疄鐜拌繑鍥炲垪琛�
	   			out.println("</script>");
			}
		}
	}
	
}
