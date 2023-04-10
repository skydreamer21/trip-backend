package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import model.AttractionDto;
import model.AttractionSearchDto;
import model.GugunDto;
import model.PageNav;
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
		} else if(action.equalsIgnoreCase("gugun")) {
			int sidoCode = Integer.parseInt(request.getParameter("sidoCode"));
			List<GugunDto> gugunDtos = attractionService.findGugunBySido(sidoCode);
			PrintWriter out = response.getWriter();
			out.write(gson.toJson(gugunDtos));
			out.flush();
		} else if(action.equalsIgnoreCase("search")) {
			int sidoCode = Integer.parseInt(request.getParameter("sidoCode"));
			int gugunCode = Integer.parseInt(request.getParameter("gugunCode"));
			int contentTypeId = Integer.parseInt(request.getParameter("contentTypeId"));
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			String keyword = request.getParameter("keyword");
			
			List<AttractionDto> attractionDtos = attractionService.findAttractions(
					sidoCode, gugunCode, contentTypeId, keyword, pageNo);
			PageNav pageNavInfo = attractionService.findPageNavInfo(
					sidoCode, gugunCode, contentTypeId, keyword, pageNo);
			
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("attractions", attractionDtos);
			responseData.put("pageNavInfo", pageNavInfo);
			
			PrintWriter out = response.getWriter();
			out.write(gson.toJson(responseData));
			out.flush();
		} else if (action.equalsIgnoreCase("searchInHome")) {
			int sidoCode = Integer.parseInt(request.getParameter("sidoCode"));
			int gugunCode = Integer.parseInt(request.getParameter("gugunCode"));
			int contentTypeId = Integer.parseInt(request.getParameter("contentTypeId"));
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			String keyword = request.getParameter("keyword");
			
			List<AttractionDto> attractionDtos = attractionService.findAttractions(sidoCode, gugunCode, contentTypeId, keyword, pageNo);
			PageNav pageNavInfo = attractionService.findPageNavInfo(
					sidoCode, gugunCode, contentTypeId, keyword, pageNo);
			AttractionSearchDto attractionSearchDto = new AttractionSearchDto(sidoCode, gugunCode, contentTypeId, keyword);
			request.setAttribute("searchFromHome", gson.toJson(attractionDtos));
			request.setAttribute("pageNavInfo", gson.toJson(pageNavInfo));
			request.setAttribute("searchInfo", gson.toJson(attractionSearchDto));
			RequestDispatcher rd = request.getRequestDispatcher("./attraction/attraction.jsp");
			rd.forward(request, response);
		}
		
	}
}
