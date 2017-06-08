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
import kr.co.mycal.friend.vo.FriendVO;
@WebServlet("/friend/servlet/friendadd")
public class FriendAddServlet extends HttpServlet {
	private SqlSession sqlSession;
	private FriendMapper friendMapper;
	public FriendAddServlet(){
		sqlSession = CommonDB.getSqlSessionInstance();
		this.friendMapper = sqlSession.getMapper(FriendMapper.class);
		
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendVO friend = new FriendVO();
		friend.setId("user1");
		System.out.println(request.getSession());
		friend.setFriendId(request.getParameter("friendId"));
		try {
			int num = friendMapper.addFriend(friend);
			if(num == -1){
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		RequestDispatcher rd = request.getRequestDispatcher("/view/friend/friendadd.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect("/myCalendar/friend/servlet/friendlist");
		
		
	}
}
