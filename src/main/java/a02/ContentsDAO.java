package a02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

	// 게시판에 글 추가
	public void addNews(Contents n) throws Exception {
		Connection conn = open();

		String sql = "insert into news(content, date) values(?,CURRENT_TIMESTAMP())";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setString(1, n.getContent());
			pstmt.executeUpdate();
		}
	}
}
