package kr.co.mycal.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.co.mycal.common.MyAppSqlConfig;
import kr.co.mycal.user.mapper.LoginMapper;
import kr.co.mycal.user.vo.LoginDTO;
import kr.co.mycal.user.vo.UserVO;

@WebServlet("/user/Login")
public class LoginServlet extends HttpServlet{
	private SqlSession sqlSession = null;
	private LoginMapper loginMapper = null;
	
	public LoginServlet() {
		sqlSession = MyAppSqlConfig.getSqlSessionInstance();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
	}

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginDTO vo = new LoginDTO();
		vo.setId(id);
		vo.setPassword(password);
		
		try {
			LoginDTO user = loginMapper.showLogin(vo);
			if(user != null ){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "Main");
				
			}
		else {
			request.setAttribute(
					"error", 
					"�α��� ������ �ùٸ��� �ʽ��ϴ�."
			);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/view/user/???");
			rd.forward(request, response);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
