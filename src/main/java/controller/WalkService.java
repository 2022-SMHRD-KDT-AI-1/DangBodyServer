package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;
import model.WalkDAO;
import model.WalkDTO;

public class WalkService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[WalkService]");
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String walkDate = request.getParameter("walk_date");
		String walkTime = request.getParameter("walk_time");
		String walkDistance = request.getParameter("walk_distance");
		String userId = request.getParameter("user_id");
		
		System.out.println("날짜 : "+walkDate);
		System.out.println("시간 : "+walkTime);
		System.out.println("거리 : "+walkDistance);
		
		
		WalkDAO dao = new WalkDAO();
		WalkDTO dto = new WalkDTO(walkTime,walkDistance,walkDate,userId);
		
		int rs = dao.recordWalk(dto);
		
		if(rs > 0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
		
		
		
	
	
	}

}
