package kr.co.mycal.friend.mapper;

import java.util.List;

import kr.co.mycal.friend.vo.MessageVO;


public interface MessageMapper {
	// 받은 쪽지함
	public List<MessageVO> readsendMessage (String userid) throws Exception;
	// 보낸 쪽지함
	public List<MessageVO> senderMessage (String userid) throws Exception;
	// 쪽지 쓰기
	public void writeMessage (MessageVO message) throws Exception;
}
