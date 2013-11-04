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
			boolean valid = true;
			if (userid.length()<4 || userid.length()>20){
				valid = false;
				useridMessage = "使用者帳號長度不符合";
			}
			if (!pw1.equals(pw2)){
				valid = false;
				pwMessage = "密碼不符合";
			}
			if (email.indexOf("@")==-1){
				valid = false;
				emailMessage = "電子郵件格式錯誤";
			}
			if (valid){
				//1
				try {
					DriverManager.registerDriver(new Driver());
					//Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
						"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
					Statement stmt = conn.createStatement();
					String sql = "Insert into users(id, password, email) values ('"+userid+"','"+pw1+"','"+email+"')";
					System.out.println(sql);
					int rowCount = stmt.executeUpdate(sql);
					System.out.println(rowCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
