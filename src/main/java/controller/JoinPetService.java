package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetDTO;
import model.PetDAO;

public class JoinPetService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		System.out.println("[펫 등록!]");
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String petName = request.getParameter("pet_name");
		String petBirthy = request.getParameter("pet_birthy");
		String petBirthm = request.getParameter("pet_birthm");
		String petBirthd = request.getParameter("pet_birthd");
		String petYear = request.getParameter("pet_year");
		String petMonth = request.getParameter("pet_month");
		String petDay = request.getParameter("pet_day");
		String petGender = request.getParameter("pet_gender");
		String petNeutral = request.getParameter("pet_neutral");
		int petWeight = Integer.parseInt(request.getParameter("pet_weight"));
		String userId = request.getParameter("user_id");
		
		petBirthy = petBirthy.substring(0, petBirthy.length()-1);
		petBirthm = petBirthm.substring(0, petBirthm.length()-1);
		petBirthd = petBirthd.substring(0, petBirthd.length()-1);
		petYear = petYear.substring(0, petYear.length()-1);
		petMonth = petMonth.substring(0, petMonth.length()-1);
		petDay = petDay.substring(0, petDay.length()-1);
		
		String petBirth = petBirthy+"-"+petBirthm+"-"+petBirthd;
		String petDate = petYear+"-"+petMonth+"-"+petDay;
		
		PetDAO dao = new PetDAO();
		PetDTO dto = new PetDTO(petName, petBirth, petGender, petNeutral, petWeight, petDate, userId);
		
		int rs = dao.joinPet(dto);
		
		if(rs!=0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
		
		
	
	}

}
