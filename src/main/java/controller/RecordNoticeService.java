package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NoticeDAO;
import model.NoticeDTO;

public class RecordNoticeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[일정 저장하기]");
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String noticeTitle = request.getParameter("notice_title");
		String noticeDate = request.getParameter("notice_date");
		String noticeTime = request.getParameter("notice_time");
		String noticeDateFinal = noticeDate;
		String userId = request.getParameter("user_id");
		
		
		System.out.println("아이디 : "+userId);
		System.out.println("일정제목 : "+noticeTitle);
		System.out.println("일정날짜 : "+noticeDate);
		System.out.println("일정시간 : "+noticeTime);
		
		
				
		
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = new NoticeDTO(userId,noticeTitle,noticeDateFinal);
		
		int rs = dao.insertNotice(dto);
		
		if(rs > 0) {
			out.print(1);
		}else {
			out.print(0);
		}
	}

}
