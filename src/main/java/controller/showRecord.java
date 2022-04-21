package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.WalkDAO;
import model.WalkDTO;

public class showRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("산책일지 보여주기");
		
		resp.setContentType("text/plain; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String userId = req.getParameter("user_id");
		//System.out.println(userId);
		
		Gson gson = new Gson();
		//WalkDTO dto = new WalkDTO();
		WalkDAO dao = new WalkDAO();
		
		ArrayList<WalkDTO> list = new ArrayList<WalkDTO>();
		list = dao.showRecord(userId);
		
		
		
		String jsonArr = gson.toJson(list); 
		out.print(jsonArr);
		
		
	}
}
