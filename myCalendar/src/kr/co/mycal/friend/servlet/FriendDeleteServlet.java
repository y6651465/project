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
@WebServlet("/friend/servlet/frienddelete")
public class FriendDeleteServlet extends HttpServlet {
	private SqlSession sqlSession;
	private FriendMapper friendMapper;
	public FriendDeleteServlet(){
		sqlSession = CommonDB.getSqlSessionInstance();
		this.friendMapper = sqlSession.getMapper(FriendMapper.class);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete = request.getParameter("friendid");
		try {
			friendMapper.deleteFriend(delete);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/view/friend/frienddelete.jsp");
//		rd.forward(request, response);
		response.sendRedirect("/myCalendar/friend/servlet/friendlist");
	}
	
}
