package kr.co.mycal.user.mapper;

import kr.co.mycal.user.vo.FileVO;
import kr.co.mycal.user.vo.UserInterestVO;
import kr.co.mycal.user.vo.UserVO;

public interface UserMapper {
	
	public int insertUser(UserVO user) throws Exception;
	public int updateUser(UserVO user) throws Exception;
	public int deleteUser(String id) throws Exception;
	public UserVO showUser(String id) throws Exception;
	public void insertInterest(UserInterestVO userInterest) throws Exception;
	public int updateInterest(UserInterestVO userInterest) throws Exception;
	
}









