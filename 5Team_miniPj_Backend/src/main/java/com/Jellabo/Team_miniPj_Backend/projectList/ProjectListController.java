package com.Jellabo.Team_miniPj_Backend.projectList;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectListController {

	private ProjectListServiceImpl pjlService;

	public ProjectListController(ProjectListServiceImpl pjlService) {
		this.pjlService = pjlService;
	}

	// 프로젝트 리스트 불러오기
	@GetMapping("/myprojectslist")
	public List<ProjectListDataDTO> loadProjectList(@RequestParam(value = "email") String email) {

	}

	// 프로젝트 생성
	@PostMapping("/createProjectProcess")
	public int createProjectProcess(@RequestBody ProjectListDataDTO project) {
		int res = pjlService.createProjectProcess(project);
		return res;
	}

	// 프로젝트 참여
	@PostMapping("/joinProjectProcess")
	public int joinProjectProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {

	}

	// 프로젝트 탈퇴
	@PostMapping("/exitProjectProcess")
	public int exitProjectProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {

	}

}
