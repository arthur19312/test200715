package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.DealBiz;
import biz.impl.DealBizImpl;
import entity.Deal;
import entity.User;

public class PostServlet extends HttpServlet {

	private DealBiz dealBiz = new DealBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String productName = request.getParameter("productName");
		String buyTimeYear = request.getParameter("buyTimeYear");
		String buyTimeMonth = request.getParameter("buyTimeMonth");
		String price = request.getParameter("price");
		String newLevel = request.getParameter("newLevel");
		String introduce = request.getParameter("introduce");
		String contact = request.getParameter("contact");
		String contactPhone = request.getParameter("contactPhone");


		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("loginUser");//从session中取得登陆用户
		
		if(user != null){
			Deal deal = new Deal(productName,buyTimeYear,buyTimeMonth,price,newLevel
					,introduce,contact,contactPhone,user.getUserName());
			dealBiz.addDeal(deal);
			response.sendRedirect("show.jsp");
		}
		else{
		    response.sendRedirect("login.jsp");
		}
	}
}