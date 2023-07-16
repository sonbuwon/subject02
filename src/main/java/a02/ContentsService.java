package a02;

import java.util.List;

public class ContentsService {

	private ContentsDAO dao;
	
	public ContentsService() {
		dao = new ContentsDAO();
	}
	
	public List<Contents> listAll() throws Exception {
		List<Contents> cList = dao.getAll();
		return cList;
	}
	
	public void register(Contents contents) throws Exception {
		dao.insertOne(contents);
	}
}
