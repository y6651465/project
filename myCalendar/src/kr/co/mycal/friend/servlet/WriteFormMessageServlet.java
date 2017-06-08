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
import kr.co.mycal.friend.mapper.FriendMapper;
import kr.co.mycal.friend.vo.FriendVO;

@WebServlet("/friend/servlet/message/WriteForm")
public class WriteFormMessageServlet extends HttpServlet {
	private SqlSession sqlSession;
	private FriendMapper friendMapper;
	public WriteFormMessageServlet(){
		sqlSession = CommonDB.getSqlSessionInstance();
		friendMapper = sqlSession.getMapper(FriendMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String friendwrite = null;
		
		try {
			friendwrite = request.getParameter("userId");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("friendwrite", friendwrite);
		RequestDispatcher rd = request.getRequestDispatcher("/view/message/writeFormMessage.jsp");
		rd.forward(request, response);
	}
	
}
