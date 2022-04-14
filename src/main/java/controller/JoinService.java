package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[JoinService]");
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userNick = request.getParameter("user_nick");
		String userName = request.getParameter("user_name");
		String userBirthy = request.getParameter("user_birthy");
		String userBirthm = request.getParameter("user_birthm");
		String userBirthd = request.getParameter("user_birthd");
		String userPhone = request.getParameter("user_phone");
		
		userBirthy = userBirthy.substring(0, userBirthy.length()-1);
		userBirthm = userBirthm.substring(0, userBirthm.length()-1);
		userBirthd = userBirthd.substring(0, userBirthd.length()-1);
		
		String userBirth = userBirthy+"-"+userBirthm+"-"+userBirthd;
		/* Date = Date.valueOf(userBirthS); */
		
		System.out.println("id : "+userId);
		System.out.println("pw : "+userPw);
		System.out.println("name : "+userName);
		System.out.println("nick : "+userNick);
		System.out.println("phone : "+userPhone);
		System.out.println("birth : "+userBirth);
		
		
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO(userId, userPw, userName, userNick, userPhone, userBirth);
		
		int rs = dao.userJoin(dto);
		
		if(rs != 0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
		
	
	}

}
