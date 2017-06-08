package kr.co.mycal.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.co.mycal.common.MyAppSqlConfig;
import kr.co.mycal.user.mapper.UserMapper;
import kr.co.mycal.user.vo.UserVO;

@WebServlet("/user/Modify")
public class ModifyUserServlet extends HttpServlet{
	private SqlSession sqlSession = null;
	private UserMapper userMapper = null;
	
	public ModifyUserServlet() {
		sqlSession = MyAppSqlConfig.getSqlSessionInstance();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		UserVO user = new UserVO();
		
		try {
			user = userMapper.showUser("WooSinKim");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/user/modifyUser.jsp");
		rd.forward(request, response);
		
	}

}









