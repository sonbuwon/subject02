package a02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ContentsDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bwdb";

	// Database connection
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "buwon", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 요구사항 추가
	public void insertOne(Contents n) throws Exception {
		Connection conn = open();
		String sql = "insert into contents(content, date) values(?, CURRENT_TIMESTAMP())";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, n.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}

	// 요구사항 삭제
	public void deleteOne(int id) throws Exception {
		Connection conn = open();
		String sql = "delete from contents where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
	
	// 요구사항 수정
	public void updateOne(Contents n) throws Exception {
		Connection conn = open();
		String sql = "update contents set content=?, date=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, n.getContent());
			pstmt.setString(2, n.getDate());
			pstmt.setInt(3, n.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		
	}
	
	// 요구사항 전체 출력
	public List<Contents> getAll() throws Exception {
		Connection conn = open();
		List<Contents> css = new ArrayList<>();
		
		String sql = "select id, content, date from contents";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Contents cs = new Contents();
				cs.setId(rs.getInt("id"));
				cs.setContent(rs.getString("content"));
				cs.setDate(rs.getString("date"));
				css.add(cs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		return css;
	}
	
	// 요구사항 검색
	public List<Contents> searchLike(String sc) throws Exception {
		Connection conn = open();
		List<Contents> css = new ArrayList<>();
		
		// Like 바인딩 하는 문법을 주의해서
		String sql = "select id, content, date from contents where content like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			System.out.println(pstmt);
			// 봐야한다
			pstmt.setString(1, "%" + sc + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Contents cs = new Contents();
				cs.setId(rs.getInt("id"));
				cs.setContent(rs.getString("content"));
				cs.setDate(rs.getString("date"));
				css.add(cs);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		return css;
	}
}
