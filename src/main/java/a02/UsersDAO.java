package a02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

public class UsersDAO {
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
	
	public Users getUser(String uid, String upw) throws Exception {
		Connection conn = open();
		
		Users user = new Users();
		String sql = "select uid, upw, uname from board_user where uid=? and upw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try {
			System.out.println(pstmt);
			
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			user.setUid(rs.getString("uid"));
			user.setUpw(rs.getString("upw"));
			user.setUname(rs.getString("uname"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		return user;
	}
	
}
