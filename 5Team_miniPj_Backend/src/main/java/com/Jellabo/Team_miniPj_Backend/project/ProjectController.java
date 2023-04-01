package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.Jellabo.Team_miniPj_Backend.users.UserDTO;

@RestController
public class ProjectController {

	private ProjectServiceImpl pjService;

	public ProjectController(ProjectServiceImpl pjService) {
		this.pjService = pjService;
	}

//	@PostMapping("/loadProjectInfo")
//	public ProjectDataDTO loadProjectInfo(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
//
//	}
//
//	@PostMapping("/loadCategories")
//	public List<String> loadCategories(int code) {
//
//	}
//
//	@PostMapping("/createCategoryProcess")
//	public int createCategoryProcess(@RequestBody CategoryDTO categoryData) {
//
//	}
//
//	@PostMapping("/deleteCategoryProcess")
//	public int deleteCategoryProcess(@RequestBody CategoryDTO categoryData) {
//
//	}
//
//	@PostMapping("/loadUserList")
//	public UserDTO loadUserList(int code) {
//
//	}
//
//	@PostMapping("/addUserProcess")
//	public int addUserProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
//
//	}
//
//	@PostMapping("/kickUserProcess")
//	public int kickUserProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
//
//	}
//
//	@PostMapping("/resettingProjectProcess")
//	public int resettingProjectProcess(@RequestBody ProjectDataDTO project) {
//
//	}
//
//	@PostMapping("/deleteProjectProcess")
//	public int deleteProjectProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
//
//	}

}
