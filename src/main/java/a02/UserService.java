package a02;

import java.util.List;

public class UserService {

	private UsersDAO dao;
	
	public UserService() {
		dao = new UsersDAO();
	}
	
	// 홈페이지에 로그인
	public Users login(String uid, String upw) throws Exception {
		Users user = dao.getUser(uid, upw);
		return user;
	}
	
	// 해당 유저 삭제
	public void remove(String uid) throws Exception {
		dao.deleteUser(uid);
	}
	
	// 전체 유저 출력
	public List<Users> userAll() throws Exception {
		List<Users> uList = dao.getAll();
		return uList;
	}
}
