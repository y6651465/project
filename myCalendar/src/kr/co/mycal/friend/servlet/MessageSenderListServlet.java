package kr.co.mycal.friend.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.co.mycal.common.CommonDB;
import kr.co.mycal.friend.mapper.MessageMapper;
import kr.co.mycal.friend.vo.MessageVO;

@WebServlet("/friend/servlet/messagesenderlist")
public class MessageSenderListServlet extends HttpServlet {
	private SqlSession sqlSession;
	private MessageMapper messageMapper;
	public MessageSenderListServlet() {
		sqlSession = CommonDB.getSqlSessionInstance();
		this.messageMapper =  sqlSession.getMapper(MessageMapper.class);
	}
	@Override	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<MessageVO> listmessage = null;
		try {
			listmessage = messageMapper.senderMessage("user1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listmessage", listmessage);
		for (MessageVO messageVO : listmessage) {
			System.out.println(messageVO.getReceiver());
			System.out.println(messageVO.getContent());
			System.out.println(messageVO.getRegDate());
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/message/messagesenderlist.jsp");
		rd.forward(request, response);
		
		
	}
	
	
}
