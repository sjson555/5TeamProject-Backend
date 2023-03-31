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

	// 현재 프로젝트 정보 불러오기
	@PostMapping("/loadProjectInfo")
	public ProjectDataDTO loadProjectInfo(@RequestParam(value = "code") int code,
			@RequestParam(value = "email") String email) {

	}

	// 현재 프로젝트 카테고리 불러오기
	@PostMapping("/loadCategories")
	public List<String> loadCategories(int code) {

	}

	// 카테고리 생성
	@PostMapping("/createCategoryProcess")
	public int createCategoryProcess(@RequestBody CategoryDTO categoryData) {

	}

	// 카테고리 삭제
	@PostMapping("/deleteCategoryProcess")
	public int deleteCategoryProcess(@RequestBody CategoryDTO categoryData) {

	}

	// 현재 프로젝트 참여자 목록 불러오기
	@PostMapping("/loadUserList")
	public UserDTO loadUserList(int code) {

	}

	// 유저 초대
	@PostMapping("/addUserProcess")
	public int addUserProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {

	}

	// 유저 추방
	@PostMapping("/kickUserProcess")
	public int kickUserProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {

	}

	// 현재 프로젝트 정보 수정
	@PostMapping("/resettingProjectProcess")
	public int resettingProjectProcess(@RequestBody ProjectDataDTO project) {

	}

	// 프로젝트 삭제
	@PostMapping("/deleteProjectProcess")
	public int deleteProjectProcess(@RequestBody ProjectDataDTO project) {
		int res = pjService.deleteProjectProcess(project);
		return res;
	}

}
