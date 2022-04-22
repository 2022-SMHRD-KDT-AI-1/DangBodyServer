package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.NoticeDAO;
import model.NoticeDTO;

public class showNoticeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("일정 보여주기");
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("user_id");
		System.out.println(userId);
		
		Gson gson = new Gson();
		NoticeDAO dao = new NoticeDAO();
		
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		list = dao.showNotice(userId);
		System.out.println(list);
		
		
		String jsonArr = gson.toJson(list); 
		out.print(jsonArr);
	}

}
