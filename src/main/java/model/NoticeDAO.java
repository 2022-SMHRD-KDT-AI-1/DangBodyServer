package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDAO {
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
		
		public int insertNotice(NoticeDTO dto) {
			
			DBconn();
			
			String sql = "insert into t_notice(notice_title, notice_st_dt, notice_check, user_id) values(?, TO_DATE(?,'yyyy-mm-dd'), 'N', ?)";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getNotice_title());
				psmt.setString(2, dto.getDate());
				psmt.setString(3, dto.getUser_id());
				
				cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBclose();				
			}
			
			return cnt;			
		}
		
		public ArrayList<NoticeDTO> showNotice(String user_id){
			ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
			DBconn();
			String sql = "select * from t_notice where user_id=? order by notice_seq desc";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, user_id);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
										
					String title = rs.getString("notice_title");
					String n_date = rs.getString("notice_st_dt");
					
					
					list.add(new NoticeDTO(user_id,title,n_date));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBclose();
			}
			
			return list;			
		}
}
