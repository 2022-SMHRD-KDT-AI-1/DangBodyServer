package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import model.CommunityDAO;


public class CommunityService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FPATH = "/images/";
//   private static final String SPATH = "/storage/";
	private static final String IMGNAME = ".jpg"; 
	private static final String linux_path = "/home/ubuntu/project/dangbody/images/";
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("user_id");
		String content = request.getParameter("content");
		String base64 = request.getParameter("image");
		String target_path="";  
		
		byte decode[] = Base64.decodeBase64(base64);
		FileOutputStream fos;
		try {
//			target_path = getServletContext().getRealPath("images/") + userId+IMGNAME;
			target_path = linux_path +  userId+IMGNAME;

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
		System.out.println("DONE");
		
		CommunityDAO dao = new CommunityDAO();
		
		int rs = dao.insertCommunity(userId, content, target_path);
		
		if(rs > 0 ) {
			out.print("true");
		}else {
			out.print("false");
		}
		 

	}
}
