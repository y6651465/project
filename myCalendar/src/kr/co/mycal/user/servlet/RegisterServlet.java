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

@WebServlet("/user/Register")
public class RegisterServlet extends HttpServlet{
	private SqlSession sqlSession = null;
	private UserMapper userMapper = null;
	
	public RegisterServlet() {
		sqlSession = MyAppSqlConfig.getSqlSessionInstance();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		UserVO user = new UserVO();
		
		user.setId(request.getParameter("id"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setGender(Integer.parseInt(request.getParameter("gender")));
		
		//email 주소 합치기
		String emailId = request.getParameter("emailId");
		String emailAddr = request.getParameter("emailAddr");
		String email = emailId + "@" + emailAddr;
		user.setEmail(email);  
		
		//birth 년 월 일 합치기
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		if(birthmonth.length() < 2){
			birthmonth = 0 + birthmonth ;
		}
		String birthdate = request.getParameter("birthdate");
		if(birthdate.length() < 2){
			birthdate = 0 + birthdate ;
		}
		String birth = birthyear + birthmonth + birthdate;
		user.setBirth(birth);
		
		user.setNotice(Integer.parseInt(request.getParameter("notice")));
		
		try {
			userMapper.insertUser(user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/user/register.jsp");
		rd.forward(request, response);
		
	}

}
