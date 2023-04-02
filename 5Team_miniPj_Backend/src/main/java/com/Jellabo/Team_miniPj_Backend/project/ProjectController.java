package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import org.springframework.http.*;
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
	public ProjectDataDTO loadProjectInfo(@RequestBody ProjectDataDTO projectData) {
		return pjService.loadProjectInfo(projectData.getCode(), projectData.getEmail());
	}

	// 현재 프로젝트 카테고리 불러오기
	@PostMapping("/loadCategories")
	public List<String> loadCategories(@RequestBody CategoryDTO code) {
		return pjService.loadCategories(code.getCode());
	}

	// 카테고리 생성
	@PostMapping("/createCategoryProcess")
	public int createCategoryProcess(@RequestBody CategoryDTO categoryData) {
		return pjService.createCategoryProcess(categoryData);
	}

	// 카테고리 삭제
	@PostMapping("/deleteCategoryProcess")
	public int deleteCategoryProcess(@RequestBody CategoryDTO categoryData) {
		return pjService.deleteCategoryProcess(categoryData);
	}

	// 현재 프로젝트 참여자 목록 불러오기
	@PostMapping("/loadUserList")
	public List<UserDTO> loadUserList(@RequestBody ProjectDataDTO code) {
		return pjService.loadUserList(code.getCode());
	}

	// 멤버 초대
	@PostMapping("/addUserProcess")
	public int addUserProcess(@RequestBody ProjectDataDTO data) {
		return pjService.addUserProcess(data.getCode(), data.getEmail());
	}

	// 멤버 추방
	@PostMapping("/kickUserProcess")
	public int kickUserProcess(@RequestBody ProjectDataDTO data) {
		return pjService.kickUserProcess(data.getCode(), data.getEmail());
	}

	// 현재 프로젝트 정보 수정
	@PostMapping("/resettingProjectProcess")
	public int resettingProjectProcess(@RequestBody ProjectDataDTO project) {
		return pjService.resettingProjectProcess(project);
	}

	// 프로젝트 삭제
	@PostMapping("/deleteProjectProcess")
	public int deleteProjectProcess(@RequestBody ProjectDataDTO project) {
		return pjService.deleteProjectProcess(project);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>("Error Occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
