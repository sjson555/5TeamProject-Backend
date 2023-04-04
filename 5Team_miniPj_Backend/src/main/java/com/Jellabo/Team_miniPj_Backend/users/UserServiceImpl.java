package com.Jellabo.Team_miniPj_Backend.users;

import org.springframework.stereotype.Service;

@Service("urService")
public class UserServiceImpl implements UserService {

	private UserMapper mapper;

	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}

	@Override // 회원가입 기능
	public int registerProcess(UserDTO userData) {
		int res;
		int emailCheck = mapper.emailCheck(userData.getEmail());

		// 이메일 중복
		if (emailCheck == 1) {
			res = 0;
		}
		// 회원가입 성공
		else {
			res = mapper.registerProcess(userData);
		}

		return res;
	}

	@Override // 로그인 기능
	public UserDTO loginProcess(LoginDTO loginData) {
		UserDTO res;
		int emailCheck = mapper.emailCheck(loginData.getEmail());

		// 존재하지 않는 이메일
		if (emailCheck == 0) {
			res = new UserDTO();
			res.setEmail("NoEmail");

		} else {
			int loginCheck = mapper.loginCheck(loginData);

			// 일치하지 않는 비밀번호
			if (loginCheck == 0) {
				res = new UserDTO();
				res.setEmail("NoPassword");

			}
			// 로그인 성공
			else {
				res = mapper.loginProcess(loginData);
			}
		}

		return res;
	}

}
