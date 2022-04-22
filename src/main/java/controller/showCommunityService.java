package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.CommunityDAO;
//import model.CommunityDTO;

public class showCommunityService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("커뮤니티 보여주기");
		
		response.setContentType("text/plain; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		CommunityDAO dao = new CommunityDAO();
		
		ArrayList<ComVO> list = new ArrayList<ComVO>();
		list = dao.showCommunity();
		
		
		String jsonArr = gson.toJson(list); 
		out.print(jsonArr);	
		
		
	}
}
