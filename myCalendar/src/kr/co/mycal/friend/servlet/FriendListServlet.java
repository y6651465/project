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
@WebServlet("/friend/servlet/friendlist")
public class FriendListServlet extends HttpServlet {
	private SqlSession sqlSession;
	private FriendMapper friendMapper;
	public FriendListServlet(){
		sqlSession = CommonDB.getSqlSessionInstance();
		this.friendMapper = sqlSession.getMapper(FriendMapper.class);
		
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<FriendVO> list = null;
		try {
			list = friendMapper.friendList("user1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/view/friend/friendlist.jsp");
		rd.forward(request, response);
	}
	
}
