package com.Jellabo.Team_miniPj_Backend.users;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	private UserServiceImpl urService;

	public UserController(UserServiceImpl urService) {
		this.urService = urService;
	}

	// 회원가입 과정
	@PostMapping("/registerProcess")
	public int registerProcess(@RequestBody UserDTO user) {
		return urService.registerProcess(user);
	}

	// 로그인 과정
	@PostMapping("/loginProcess")
	public UserDTO loginProcess(@RequestBody UserDTO user) {
		return urService.loginProcess(user);
	}

}
