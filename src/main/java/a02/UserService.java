package a02;

public class UserService {

	private UsersDAO dao;
	
	public UserService() {
		dao = new UsersDAO();
	}
	
	public Users login(String uid, String upw) throws Exception {
		Users user = dao.getUser(uid, upw);
		return user;
	}
}
