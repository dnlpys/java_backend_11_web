package test.com.aop;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TestDAOimpl implements TestDAO {

	@Override
	public int insert(TestVO vo) {
		log.info("insert()...");
		return 1;

	}

	@Override
	public void update(TestVO vo) {
		log.info("update()...");

	}

	@Override
	public void delete(TestVO vo) {
		log.info("delete()...");

	}

	@Override
	public void select() {
		log.info("select()...");

	}

	@Override
	public void search(TestVO vo) {
		log.info("search()...");

	}

}
