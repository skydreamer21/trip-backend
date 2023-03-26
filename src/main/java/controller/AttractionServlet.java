package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.SidoDto;
import service.AttractionServiceImpl;

/**
 * Servlet implementation class AttractionServlet
 */
@WebServlet("/attraction")
public class AttractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final AttractionServiceImpl attractionService = AttractionServiceImpl.getInstance();
	
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
		if(action.equalsIgnoreCase("sido")) {
			List<SidoDto> sidoDto = attractionService.readSido();
			PrintWriter out = response.getWriter();
			out.write(gson.toJson(sidoDto));
			out.flush();
		}
		
	}
}
