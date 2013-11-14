package com.tom;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_MEMBER = "listMember.jsp";
	private static final String ADD_MEMBER = "member.jsp";
	
	
	
	private MemberDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        dao = new MemberDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listmember")){
			List<Member> members = dao.getAll();
			request.setAttribute("members", members);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher(LIST_MEMBER);
			dispatcher.forward(request, response);
		}
		if (action.equalsIgnoreCase("addmember")){
			if (request.getParameter("userid")!=null){
				// save
				String userid = request.getParameter("userid");
				String nickname = request.getParameter("nickname");
				String pw = request.getParameter("pw");
				String email = request.getParameter("email");
				Member m = new Member(userid, nickname, pw, email);
				dao.add(m);
				List<Member> members = dao.getAll();
				request.setAttribute("members", members);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(LIST_MEMBER);
					dispatcher.forward(request, response);
			}else{
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(ADD_MEMBER);
					dispatcher.forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
