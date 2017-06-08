package kr.co.mycal.friend.mapper;

import java.util.List;

import kr.co.mycal.friend.vo.FriendVO;
import kr.co.mycal.friend.vo.UserVO;


public interface FriendMapper {
	public int addFriend (FriendVO friendid) throws Exception;
	public int deleteFriend (String friendid) throws Exception;
	public List<FriendVO> friendList (String userid) throws Exception;
	public String friendSearch (String userid) throws Exception;
	
	
	
}
