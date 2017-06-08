package kr.co.mycal.friend.servlet;

import java.io.IOException;

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

@WebServlet("/friend/servlet/writemessage")
public class WriteMessageServlet extends HttpServlet{
	private SqlSession sqlsession;
	private MessageMapper messageMapper;
	public WriteMessageServlet(){
		sqlsession = CommonDB.getSqlSessionInstance();
		this.messageMapper = sqlsession.getMapper(MessageMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageVO messagevo = new MessageVO();
		messagevo.setReceiver(request.getParameter("userId"));
		messagevo.setContent(request.getParameter("content"));
		messagevo.setSender("user1");
		try {
			messageMapper.writeMessage(messagevo);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/message/writeMessage.jsp");
		rd.forward(request, response);
	
	}

}
