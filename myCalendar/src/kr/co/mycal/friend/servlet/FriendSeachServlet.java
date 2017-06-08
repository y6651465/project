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
import kr.co.mycal.friend.mapper.FriendMapper;
@WebServlet("/friend/servlet/friendreceiverseach")
public class FriendSeachServlet extends HttpServlet{
	private SqlSession sqlSession;
	private FriendMapper friendMapper;
	public FriendSeachServlet (){
		sqlSession = CommonDB.getSqlSessionInstance();
		friendMapper = sqlSession.getMapper(FriendMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		try {
			 id = friendMapper.friendSearch("user2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/view/friend/friendSearch.jsp");
		rd.forward(request, response);
	}
	
}
