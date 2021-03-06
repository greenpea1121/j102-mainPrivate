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
	private static final String EDIT_MEMBER = "member_edit.jsp";

	private MemberDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		dao = new MemberDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = LIST_MEMBER;
		String action = request.getParameter("action");
		if (action == null) {
			forward = LIST_MEMBER;
		} else {
			if (action.equalsIgnoreCase("listmember")) {
				forward = LIST_MEMBER;
			}
			if (action.equalsIgnoreCase("addmember")) {
				if (request.getParameter("userid") != null) {
					// save
					String userid = request.getParameter("userid");
					String nickname = request.getParameter("nickname");
					String pw = request.getParameter("pw");
					String email = request.getParameter("email");
					Member m = new Member(userid, nickname, pw, email);
					dao.add(m);
					forward = LIST_MEMBER;
				} else {
					forward = ADD_MEMBER;
				}
			}
			if (action.equalsIgnoreCase("edit")) {
				Member m = dao.getMemberById(request.getParameter("userid"));
				request.setAttribute("m", m);
				forward = EDIT_MEMBER;
			}
		}
		List<Member> members = dao.getAll();
		request.setAttribute("members", members);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("edit")) {
			Member m = new Member(request.getParameter("userid"),
					request.getParameter("nickname"),
					request.getParameter("pw"), request.getParameter("email"));
			dao.update(m);
			List<Member> members = dao.getAll();
			request.setAttribute("members", members);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(LIST_MEMBER);
			dispatcher.forward(request, response);
		}
	}

}
