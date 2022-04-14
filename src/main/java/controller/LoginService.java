package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.UserDAO;
import model.UserDTO;

public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[LoginService]");

		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();

		// 안드로이드에서 보낸 id,pw를 가져옴
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		System.out.println("id : "+userId);
		System.out.println("pw : "+userPw);
		
		UserDAO dao = new UserDAO();
		UserDTO info = null;

		Gson gson = new Gson();
		
		// DB에서 조회한 결과값 반환
		info = dao.userLogin(userId, userPw);
		
		String jsonStr = gson.toJson(info);
		// 안드로이드쪽으로 응답데이터를 전송
		if (info != null) {
			out.print(jsonStr);
		} else {
			out.print(0);
			System.out.println("멍충아!!!!");
		}
	
	
	}

}
