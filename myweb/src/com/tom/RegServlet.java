package com.tom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if (request.getParameter("userid")!=null){
			userid = request.getParameter("userid");
			pw1 = request.getParameter("pw1");
			pw2 = request.getParameter("pw2");
			email = request.getParameter("email");
			
			Member m = new Member(userid, pw1, pw2, email);
			if (m.validate()){
				// 註冊成功
				
				
			}else{
				// 註冊失敗
				
				
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
