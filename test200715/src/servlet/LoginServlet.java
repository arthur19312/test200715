package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.UserBiz;
import biz.impl.UserBizImpl;
import entity.User;

public class LoginServlet extends HttpServlet {

	private UserBiz userBiz = new UserBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uName = request.getParameter("userName");
		String uPass = request.getParameter("userPsw");
		System.out.println(uName);
		System.out.println(uPass);

		User user = userBiz.findUser(uName);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		if(user != null && user.getUserPsw().equals(uPass)){
			HttpSession session = request.getSession(true);
			session.setAttribute("loginUser", user);
			out.println("µÇÂ½³É¹¦");
			response.sendRedirect("show.jsp");
		}else{
			out.println("µÇÂ¼Ê§°Ü");
			response.sendRedirect("login.jsp");
		}
	}
}