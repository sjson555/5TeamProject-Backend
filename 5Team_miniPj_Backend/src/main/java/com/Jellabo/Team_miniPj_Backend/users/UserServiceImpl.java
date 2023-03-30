package com.Jellabo.Team_miniPj_Backend.users;

import org.springframework.stereotype.Service;

@Service("urService")
public class UserServiceImpl implements UserService {

	private UserMapper mapper;

	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}

	// 이 곳에 로그인/로그아웃 페이지에 필요한 서비스 메서드 구현

}
