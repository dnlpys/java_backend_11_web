package test.com.aop;

public interface TestDAO {

	public int insert(TestVO vo);

	public void update(TestVO vo);

	public void delete(TestVO vo);

	public void select();

	public void search(TestVO vo);

}
