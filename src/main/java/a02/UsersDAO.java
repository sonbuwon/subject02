package a02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bwdb";

	// 데이터베이스 연결
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
	
	// 아이디, 비밀번호에 해당하는 유저 가져오기
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
			
			if(rs.next()) {
				user.setUid(rs.getString("uid"));
				user.setUpw(rs.getString("upw"));
				user.setUname(rs.getString("uname"));
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		return user;
	}
	
	// 유저 추가
	public void insertUser(Users us) throws Exception{
		Connection conn = open();
		
		String sql = "insert into board_user(uid, upw, uname) values(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, us.getUid());
		pstmt.setString(2, us.getUpw());
		pstmt.setString(3, us.getUname());
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}
	
	// 유저 삭제
	public void deleteUser(String uid) throws Exception {
		Connection conn = open();
		String sql = "delete from board_user where uid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
	
	// 유저 전체 출력
	public List<Users> getAll() throws Exception {
		Connection conn = open();
		List<Users> uss = new ArrayList<>();
		
		String sql = "select uid, upw, uname from board_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Users us = new Users();
				us.setUid(rs.getString("uid"));
				us.setUpw(rs.getString("upw"));
				us.setUname(rs.getString("uname"));
				uss.add(us);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		return uss;
	}
}
