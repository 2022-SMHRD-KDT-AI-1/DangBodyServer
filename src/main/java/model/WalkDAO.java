package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WalkDAO {
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

		
		public int recordWalk(WalkDTO dto) {
			DBconn();
			
			String sql = "insert into t_walk(walk_time, walk_distance, walk_date, user_id, pet_seq) values(?,?,?,?,?)";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getWalk_time());
				psmt.setString(2, dto.getWalk_distance());
				psmt.setString(3, dto.getWalk_date());
				psmt.setString(4, dto.getUser_id());
				psmt.setInt(5, dto.getPet_seq());
				
				cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBclose();
			}
			
			return cnt;
			
		}
		
		public ArrayList<WalkDTO> showRecord(String userId){
			ArrayList<WalkDTO> info = new ArrayList<WalkDTO>();
			
			DBconn();
			
			String sql = "select walk_time, walk_distance, walk_date from t_walk where user_id = ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, userId);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
										
					String time = rs.getString("walk_time");
					String dis = rs.getString("walk_distance");
					String date = rs.getString("walk_date");
					
					info.add(new WalkDTO(time, dis, date));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBclose();
			}
			
			return info;
		}
}
