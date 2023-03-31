package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDto;
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
		HttpSession session = request.getSession();

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
			
			if (login != null) { // 
				if (login.isAvailable()) {// 이용 가능한 유저라면
					
					session.setAttribute("login", login);
					out.write("<script>" + " alert('로그인에 성공하였습니다.');" + " location.href='index.jsp';" + "</script>");
					out.close();
				}
				else { // 탈퇴한 사용자라면 
					session.invalidate();
					out.write("<script>" + " alert('탈퇴한 계정입니다.');" + " location.href='index.jsp';" + "</script>");
					out.close();
				}
			} else { // 계정이 없다면
				session.invalidate();
				out.write("<script>" + " alert('입력한 정보가 올바르지 않습니다. 다시 확인해주세요');" + " location.href='index.jsp';" + "</script>");
				out.close();
			}

		}

		//회원 정보 조회 -> 로그인 안했으면 못드감
		else if (action.equalsIgnoreCase("detail")) {
			
			path = root + "/member/detail.jsp";
			MemberDto login = (MemberDto) session.getAttribute("login");
			if (login == null) {
				out.write("<script>" + " alert('로그인을 해주세요...'); " + " location.href='index.jsp';" + "</script>");
				out.close();
			}
			response.sendRedirect(path);
			return;
		}

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
				session.invalidate();
				out.close();
			} else {
				out.write("<script>" + " alert('Error!!!!'); alert('회원 정보가 수정되지 않았습니다. 다시 시도해주세요.');" + " location.href='index.jsp';" + "</script>");
				out.close();
			}
		}

		else if (action.equalsIgnoreCase("logout")) { // 2. if 분기
			session.invalidate();
			response.sendRedirect(root + "/index.jsp");
		}
		
		else if (action.equalsIgnoreCase("delete")) {
			String user_id = request.getParameter("user_id");
			MemberDto user;
			if (user_id == null) {
				user = (MemberDto) session.getAttribute("login");
			} else {
				user = (MemberDto) mservice.findMemberById(user_id);
			}
			
			
			if (user != null) { // 로그인 되어있다면
				boolean isS = mservice.resign(user);
				if(isS) {
					out.write("<script>" + " alert('회원탈퇴 되었습니다.'); " + " location.href='index.jsp';" + "</script>");
					session.invalidate();
					out.close();
				}
				else {
					out.write("<script>" + " alert('회원탈퇴 실패!! 이유: 모름'); " + " location.href='index.jsp';" + "</script>");
					out.close();
				}
			}
			else { //로그인 안되어있으면
				out.write("<script>" + " alert('회원탈퇴 실패!! 이유 : 로그인하세요.'); " + " location.href='index.jsp';" + "</script>");
				out.close();
				
			}
		}
		
		else if (action.equalsIgnoreCase("memberList")) {
			List<MemberDto> members = mservice.findAllMembers();
			request.setAttribute("members", members);
			RequestDispatcher rd = request.getRequestDispatcher("./member/memberlist.jsp");
			rd.forward(request, response);
		}
	}
}
