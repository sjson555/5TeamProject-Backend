package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jellabo.Team_miniPj_Backend.users.UserDTO;

@RestController
public class ProjectController {

	private ProjectServiceImpl pjService;

	public ProjectController(ProjectServiceImpl pjService) {
		this.pjService = pjService;
	}

	@PostMapping("/loadProjectInfo")
	public ProjectDataDTO loadProjectInfo(@RequestParam(value = "code") int code,
			@RequestParam(value = "email") String email) {
		 ProjectDataDTO res = pjService.loadProjectInfo(code, email);
		return res;

	}

	@PostMapping("/loadCategories")
	public List<String> loadCategories(int code) {
		List<String> categoryList = pjService.loadCategories(code);
		return categoryList;

	}

	@PostMapping("/createCategoryProcess")
	public int createCategoryProcess(@RequestBody CategoryDTO categoryData) {
		int res = pjService.createCategoryProcess(categoryData);
		return res;

	}

	@PostMapping("/deleteCategoryProcess")
	public int deleteCategoryProcess(@RequestBody CategoryDTO categoryData) {
		int res = pjService.deleteCategoryProcess(categoryData);
		return res;

	}

	@PostMapping("/loadUserList")
	public List<UserDTO> loadUserList(int code) {
		List<UserDTO> userList = pjService.loadUserList(code);
		return userList;

	}

	@PostMapping("/addUserProcess")
	public int addUserProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
		int res = pjService.addUserProcess(code, email);
		return res;

	}

	@PostMapping("/kickUserProcess")
	public int kickUserProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
		int res = pjService.kickUserProcess(code, email);
		return res;

	}

	@PostMapping("/resettingProjectProcess")
	public int resettingProjectProcess(@RequestBody ProjectDataDTO project) {
		int res = pjService.resettingProjectProcess(project);
		return res;

	}

//	@PostMapping("/deleteProjectProcess")
//	public int deleteProjectProcess(@RequestParam(value = "code") int code,
//			@RequestParam(value = "email") String email) {
//
//	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>("Error Occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
