package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserDTO;

public class UserDAO {

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

	public UserDTO userLogin(String userId, String userPw) {
		UserDTO info = null;
		DBconn();
		
		String sql = "select * from t_user where user_id=? and user_pw=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String user_id = rs.getString("user_id");
				String user_pw = rs.getString("user_pw");
				String user_nick = rs.getString("user_nick");
				String user_name = rs.getString("user_name");
				String user_phone = rs.getString("user_phone");
				String user_joindate = rs.getString("user_joindate");
				String user_birthdate = rs.getString("user_birthdate");
				String user_type = rs.getString("user_nick");
				String family_id = rs.getString("family_id");
				
				info = new UserDTO(user_id, user_pw, user_name, user_nick, user_phone, user_birthdate, user_joindate, user_type, family_id);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		
		return info;
	}
	
	
	// 회원가입
	public int userJoin(UserDTO dto) {
		
		DBconn();
		
		String sql = "INSERT INTO T_USER(user_id, user_pw, user_name, user_nick, user_phone, user_birthdate, user_joindate, user_type, family_id)"
				+ "VALUES(?, ?, ?, ?, ?, ?, sysdate, 'N', NULL)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());
			psmt.setString(3, dto.getUser_name());
			psmt.setString(4, dto.getUser_nick());
			psmt.setString(5, dto.getUser_phone());
			psmt.setString(6, dto.getUser_birthdate());
			
			cnt=psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		return cnt;

	}
	
	// 가족 등록
	public int joinFamily(String user_id, String family_id) {
		DBconn();
		
		String sql = "update t_user set family_id =? where user_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, family_id);
			psmt.setString(2, user_id);
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		return cnt;
	}

}
