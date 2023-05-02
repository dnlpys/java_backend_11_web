package test.com.reservation.model;

import java.util.List;

import test.com.member.model.MemberVO;

public interface ReservationDAO {

	public int insert(ReservationVO vo);

	public int update(ReservationVO vo);

	public int delete(ReservationVO vo);

	public ReservationVO selectOne(ReservationVO vo);

	public List<ReservationVO> selectAll(ReservationVO vo);

}
