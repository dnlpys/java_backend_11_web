package test.com.fileupload.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TestDAOimpl implements TestDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(TestVO vo) {
		log.info("insert()...{}",vo);
		int flag = 0;
		
		try {
			flag = sqlSession.insert("INSERT",vo);
		} catch (Exception e) {
		}
		
		return flag;
	}

	@Override
	public List<TestVO> selectAll() {
		log.info("selectAll()....");
		
		List<TestVO> vos = sqlSession.selectList("SELECT_ALL");
				
		
		return vos;
	}

}
