package test.com.comments.model;

import java.util.List;

public interface CommentsDAO {

	public int insert(CommentsVO vo);

	public int update(CommentsVO vo);

	public int delete(CommentsVO vo);

	public List<CommentsVO> selectAll(CommentsVO vo);

}
