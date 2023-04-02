package com.Jellabo.Team_miniPj_Backend.users;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	// 회원가입/로그인 공통 기능
	int emailCheck(@Param("email") String email);

	// 회원가입 기능
	int registerProcess(UserDTO user);

	// 로그인 기능
	int loginCheck(UserDTO user);

	UserDTO loginProcess(UserDTO user);

}
