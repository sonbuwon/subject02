package a02;

import java.util.List;

public class ContentsService {

	private ContentsDAO dao;
	
	public ContentsService() {
		dao = new ContentsDAO();
	}
	
	// 전체 목록 출력
	public List<Contents> listAll() throws Exception {
		List<Contents> cList = dao.getAll();
		return cList;
	}
	// 검색 목록 출력
	public List<Contents> searchList(String sc) throws Exception {
		List<Contents> sList = dao.searchLike(sc);
		return sList;
	}
	
	// 등록
	public void register(Contents contents) throws Exception {
		dao.insertOne(contents);
	}
	
	// 삭제
	public void remove(int id) throws Exception {
		dao.deleteOne(id);
	}
}
