package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ComDTO;

public class CommunityDAO {
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
	

	public int insertCommunity(String id, String content, String path) {
		DBconn();
		
		String sql = "insert into t_community(article_content, article_file, article_date, likes, user_id) values(?, ?, sysdate, 0, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setString(2, path);
			psmt.setString(3, id);
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		return cnt;
		
	}
	
	public ArrayList<ComDTO> showCommunity(){
		ArrayList<ComDTO> list = new ArrayList<ComDTO>();
		
		DBconn();
		String sql = "select c.article_seq, c.article_content, c.article_file, c.article_date, c.likes, u.user_nick from t_community c, t_user u where c.user_id = u.user_id order by article_seq desc";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt(1);
				String content = rs.getString(2);
				String file = rs.getString(3);
				String date = rs.getString(4);
				int likes = rs.getInt(5);
				String userNick=rs.getString(6);
				
				
				
				ComDTO cvo = new ComDTO(seq, content, file, date, likes, userNick);
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		return list;
	}
	
	public int updateLikes(int seq) {
		DBconn();
		
		String sql = "update t_community set likes = likes+1 where article_seq = ?"; 

		try {
			psmt = conn.prepareStatement(sql);		
			psmt.setInt(1, seq);
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}
		
		return cnt;
	}
}
