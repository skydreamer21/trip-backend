package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.BoardDto;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardController")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final BoardServiceImpl boardService = BoardServiceImpl.getInstance();
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String root = request.getContextPath();
		
		Gson gson = new Gson();
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("boardwrite")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("login") == null) {
				request.setAttribute("msg", "로그인을 먼저 해주세요");
				RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("./board/boardwrite.jsp");
			}
			
		} else if (action.equalsIgnoreCase("boardwriteaf")){
			String userId = request.getParameter("userId");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			boolean isS = boardService.write(new BoardDto(userId, title, content));
			if (isS) {
				response.sendRedirect("./boardController?action=boardlist");
			} else {
				request.setAttribute("msg", "글 쓰기 실패했습니다.");
				RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
				rd.forward(request, response);
			}
		} else if(action.equalsIgnoreCase("boardlist")) {
			List<BoardDto> posts = boardService.findAllPosts();
			request.setAttribute("boards", posts);
			RequestDispatcher rd = request.getRequestDispatcher("./board/boardlist.jsp");
			rd.forward(request, response);
		} else if(action.equalsIgnoreCase("detail")) {
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			BoardDto post = boardService.findPost(articleNo);
			request.setAttribute("board", post);
			RequestDispatcher rd = request.getRequestDispatcher("./board/boardDetail.jsp");
			rd.forward(request, response);
		} else if(action.equalsIgnoreCase("updateBoard")) {
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			BoardDto post = boardService.findPost(articleNo);
			request.setAttribute("board", post);
			RequestDispatcher rd = request.getRequestDispatcher("./board/boardwrite.jsp");
			rd.forward(request, response);
		} else if(action.equalsIgnoreCase("boardUpdateaf")) {
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			String userId = request.getParameter("userId");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			boolean isS = boardService.updateBoard(new BoardDto(articleNo, userId, title, content));
			if (isS) {
				response.sendRedirect("./boardController?action=boardlist");
			} else {
				request.setAttribute("msg", "글 수정에 실패했습니다.");
				RequestDispatcher rd = request.getRequestDispatcher("./boardController?action=detail&articleNo="+articleNo);
				rd.forward(request, response);
			}
		} else if (action.equalsIgnoreCase("delete")) {
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			boolean isS = boardService.removeBoard(articleNo);
			if (isS) {
				response.sendRedirect("./boardController?action=boardlist");
			} else {
				request.setAttribute("msg", "글 삭제에 실패했습니다.");
				RequestDispatcher rd = request.getRequestDispatcher("./boardController?action=detail&articleNo="+articleNo);
				rd.forward(request, response);
			}
		}
		
		
	}

}
