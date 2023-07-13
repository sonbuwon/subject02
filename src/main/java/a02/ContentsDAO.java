package a02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ContentsDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

	// Database connection
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 게시판에 요구사항 추가
	public void addContent(Contents n) throws Exception {
		Connection conn = open();

		String sql = "insert into contents(content, date) values(?,CURRENT_TIMESTAMP())";
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

	public List<Contents> getAll() throws Exception {
		Connection conn = open();
		List<Contents> css = new ArrayList<>();
		
		String sql = "select content, date from contents";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Contents cs = new Contents();
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
