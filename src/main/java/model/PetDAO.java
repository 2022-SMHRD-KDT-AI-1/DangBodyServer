package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetDAO {

	// 전역변수로 선언
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	
	// DB연결 메소드
	public void DBconn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "ai1_pjs_oracle";
			String dbpw = "smhrd123";
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// DB Close 메소드
	public void DBclose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public int joinPet(PetDTO dto) {
		DBconn();
		
		String sql = "insert into t_pet(pet_name, pet_birthdate, pet_gender, pet_neutral, pet_weight, pet_date, user_id) values(?,TO_DATE(?,'yyyy-mm-dd'),?,?,?,TO_DATE(?,'yyyy-mm-dd'),?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPet_name());
			psmt.setString(2, dto.getPet_birthdate());
			psmt.setString(3, dto.getPet_gender());
			psmt.setString(4, dto.getPet_neutral());
			psmt.setInt(5, dto.getPet_weight());
			psmt.setString(6, dto.getPet_date());
			psmt.setString(7, dto.getUser_id());
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		return cnt;
		
	}
	
	public ArrayList<String> findPet(String user_id) {
		ArrayList<String> names = new ArrayList<String>();
		
		DBconn();
		String sql = "select pet_name from t_pet where user_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString(1);
				
				names.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		return names; 
	}

}
