package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.PetDAO;
import model.UserDAO;
import model.UserDTO;
import model.VO;

public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[LoginService]");

		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		// 안드로이드에서 보낸 id,pw를 가져옴
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		ArrayList<String> petName=new ArrayList<String>();
		System.out.println("id : "+userId);
		System.out.println("pw : "+userPw);
		
		
		
		
		UserDAO dao = new UserDAO();
		UserDTO info = null;
		PetDAO pdao = new PetDAO();
		
		Gson gson = new Gson();
		
		// DB에서 조회한 결과값 반환
		info = dao.userLogin(userId, userPw);
		petName = pdao.findPet(userId);
		
		 
		// 펫 이름 조회
		VO v = new VO(info,petName);
		String j = gson.toJson(v);
		System.out.println(j);
		/*
		 * String jsonStr = gson.toJson(info); String jsonStr2 = gson.toJson(petName);
		 * System.out.println(jsonStr); System.out.println(jsonStr2);
		 */
		
		// 안드로이드쪽으로 응답데이터를 전송
		if (info != null) {
			out.print(j);
		} else {
			out.print(0);
			System.out.println("멍충아!!!!");
		}
	
	
	}

}
