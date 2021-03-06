package com.tom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useridMessage = null;
		String pwMessage = null;
		String emailMessage = null;
		String userid = null;
		String pw1 = null;
		String pw2 = null;
		String email = null;
		String answer = request.getParameter("answer");
		request.getSession().removeAttribute("CAP_WRONG");
		Captcha cap = (Captcha)request.getSession().getAttribute(Captcha.NAME);
		if (!cap.isCorrect(answer)){
			request.getSession().setAttribute("CAP_WRONG", "驗證碼錯誤");
			RequestDispatcher disp = request.getRequestDispatcher("reg2.jsp");
			disp.forward(request, response);
			return;
		}
		
		if (request.getParameter("userid")!=null){
			userid = request.getParameter("userid");
			String nickname = request.getParameter("nickname");
			pw1 = request.getParameter("pw1");
			pw2 = request.getParameter("pw2");
			email = request.getParameter("email");
			
			Member m = new Member(userid, nickname, pw1, pw2, email);
			HttpSession session = request.getSession();
			session.setAttribute("m", m);
			
			if (m.validate()){
				// 註冊成功 , Forward法
//				request.getRequestDispatcher("success.jsp")
//					.forward(request, response);
				// 註冊成功, Redirect法
				response.sendRedirect("success.jsp");
				
			}else{
				// 註冊失敗
				response.sendRedirect("reg2.jsp");
				
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
