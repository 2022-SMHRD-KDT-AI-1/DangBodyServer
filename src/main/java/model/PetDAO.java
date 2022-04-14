package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			String url = "jdbc:oracle:thin:@220.71.97.178:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
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

}
