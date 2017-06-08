package kr.co.mycal.user.mapper;

import kr.co.mycal.user.vo.LoginDTO;

public interface LoginMapper {
	
	public LoginDTO showLogin(LoginDTO user) throws Exception;
}
