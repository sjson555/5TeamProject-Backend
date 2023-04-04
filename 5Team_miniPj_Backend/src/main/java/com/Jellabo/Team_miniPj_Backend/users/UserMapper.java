package com.Jellabo.Team_miniPj_Backend.users;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	// 회원가입/로그인 공통 기능
	int emailCheck(String email);

	// 회원가입 기능
	int registerProcess(UserDTO user);

	// 로그인 기능
	int loginCheck(LoginDTO loginData);

	UserDTO loginProcess(LoginDTO loginData);

}
