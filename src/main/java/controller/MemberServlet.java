package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDto;
import service.IMemberService;
import service.MemberServiceImpl;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	IMemberService mservice = MemberServiceImpl.getInstance();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = "";
		String root = request.getContextPath();
		String action = request.getParameter("action");

		// 회원가입 페이지 이동
		if (action.equalsIgnoreCase("registry")) {
			path = root + "/member/registry.jsp";
			response.sendRedirect(path);
			return;
		}

		// 회원가입 창 -> 회원가입 버튼
		else if (action.equalsIgnoreCase("registryaf")) {
			path = "index.jsp";
			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			String email_id = request.getParameter("email_id");
			String email_domain = request.getParameter("email_domain");
			boolean isS = mservice.registry(new MemberDto(user_id, user_name, user_password, email_id, email_domain));

			if (isS) {
				out.write("<script>" + " alert('축하합니다!!');" + " alert('회원가입에 성공하였습니다!!');"
						+ " location.href='index.jsp';" + "</script>");
				out.close();

			} else {
				out.write("<script> " + " alert('회원가입에 실패했습니다.');" + " alert('이미 등록된 회원입니다.');"
						+ " location.href='index.jsp';" + "</script>");
				out.close();

			}

		}

		// 로그인 페이지 이동
		else if (action.equalsIgnoreCase("login")) {
			path = root + "/member/login.jsp";
			response.sendRedirect(path);
			return;
		}

		// 로그인 창 -> 로그인 버튼
		else if (action.equalsIgnoreCase("loginaf")) { // 2. if 분기
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			MemberDto login = mservice.login(new MemberDto(user_id, user_password));
			HttpSession session = request.getSession(); // 세션 저장
			if (login != null) { // 5
				session.setAttribute("login", login);
				out.write("<script>" + " alert('로그인에 성공하였습니다.');" + " location.href='index.jsp';" + "</script>");
				out.close();
			} else {
				session.invalidate();
				out.write("<script>" + " alert('로그인에 실패하였습니다.');" + " location.href='index.jsp';" + "</script>");
				out.close();
			}

		}

//		else if (action.equalsIgnoreCase("detail")) {
//			
//			MemberDto getCurSessionInfo = (MemberDto)session.getAttribute("login");
//			String user_id = getCurSessionInfo.getUser_id();
//
//			
//			path = root + "/member/detail.jsp";
//			response.sendRedirect(path);
//			
//			return;
//		}

		// 회원정보 조회-> 수정하기 버튼 누를 때 -> 수정 페이지로 이동
		else if (action.equalsIgnoreCase("update")) {
			path = root + "/member/update.jsp";
			response.sendRedirect(path);
			return;
		}

		// 회원정보 수정 페이지에서 수정하기 버튼 누를 때 ->회원 정보 페이지로 이동 
		else if (action.equalsIgnoreCase("updateaf")) {

			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			String email_id = request.getParameter("email_id");
			String email_domain = request.getParameter("email_domain");
			boolean isS = mservice.update(new MemberDto(user_id, user_name, user_password, email_id, email_domain));
			
			if (isS) { // 5
				out.write("<script>" + " alert('회원 정보가 정상적으로 수정되었습니다..'); alert('다시 로그인해주세요.');" + " location.href='index.jsp';" + "</script>");
				out.close();
			} else {
				out.write("<script>" + " alert('Error!!!!'); alert('회원 정보가 수정되지 않았습니다. 다시 시도해주세요.');" + " location.href='index.jsp';" + "</script>");
				out.close();
			}
		}

		else if (action.equalsIgnoreCase("logout")) { // 2. if 분기
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(root + "/member?action=login");
		}
	}
}
