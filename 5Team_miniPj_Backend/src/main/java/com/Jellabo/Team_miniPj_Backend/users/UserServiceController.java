package com.Jellabo.Team_miniPj_Backend.users;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserServiceController {
	
	private UserServiceImpl urService;
	
	public UserServiceController(UserServiceImpl urService) {
		this.urService = urService;
	}
	
	@PostMapping("/registerProcess")
	public int registerProcess(UserDTO users) {
		return 1;
		
	}
	
	@PostMapping("/loginProcess")
	public UserDTO loginProcess(@RequestBody String email, @RequestBody String password) {
		
	}
	
}
