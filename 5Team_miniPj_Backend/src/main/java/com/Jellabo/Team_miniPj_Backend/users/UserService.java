package com.Jellabo.Team_miniPj_Backend.users;

public interface UserService {

	// 회원가입 기능
	int registerProcess(UserDTO user);

	// 로그인 기능
	UserDTO loginProcess(LoginDTO loginData);

}
