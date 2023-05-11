package test.com.fileupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.fileupload.model.TestDAO;
import test.com.fileupload.model.TestVO;

@Service
public class TestService {

	@Autowired
	TestDAO dao;
	
	public int insert(TestVO vo) {
		return dao.insert(vo);
	}
	
	public List<TestVO> selectAll(){
		return dao.selectAll();
	}
	
}
