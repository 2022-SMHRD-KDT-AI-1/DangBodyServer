package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import model.CommunityDAO;


public class CommunityService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//리눅스 서버저장경로
	private static final String linux_path = "/home/ubuntu/project/dangbody/images/";
	
	//데이터베이스 이미지저장경로
	private static final String aws_path = "http://3.128.27.19:8080/";
	private static final String saveDir_path = "images/";
	private static final String IMGNAME = ".jpg"; 
			
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("user_id");
		String content = request.getParameter("content");
		String base64 = request.getParameter("image");
		String target_path="";  
		String uuid = UUID.randomUUID().toString();
		
		byte decode[] = Base64.decodeBase64(base64);
		FileOutputStream fos;
		try {
//			target_path = getServletContext().getRealPath("images/") + userId+IMGNAME;
			target_path = linux_path +userId+uuid+IMGNAME;

			System.out.println(target_path);
			File target = new File(target_path);
			target.createNewFile();
			System.out.println(target.exists());
			fos = new FileOutputStream(target);
			fos.write(decode);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DONE");
		
		CommunityDAO dao = new CommunityDAO();
		
		int rs = dao.insertCommunity(userId, content, aws_path+saveDir_path+userId+uuid+IMGNAME);
		
		if(rs > 0 ) {
			out.print("true");
		}else {
			out.print("false");
		}
		 

	}
}
