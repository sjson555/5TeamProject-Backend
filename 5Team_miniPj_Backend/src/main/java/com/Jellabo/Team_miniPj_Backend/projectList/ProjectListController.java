package com.Jellabo.Team_miniPj_Backend.projectList;

import java.io.Console;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.Jellabo.Team_miniPj_Backend.CodeEmailDTO;

@RestController
public class ProjectListController {

	private ProjectListServiceImpl pjlService;

	public ProjectListController(ProjectListServiceImpl pjlService) {
		this.pjlService = pjlService;
	}

	// 프로젝트 리스트 불러오기
	@GetMapping("/myprojectslist")
	public List<ProjectListDataDTO> loadProjectList(@RequestParam(value = "email") String email) {
		return pjlService.loadProjectList(email);
	}

	// 프로젝트 생성
	@PostMapping("/createProjectProcess")
	public int createProjectProcess(@RequestBody ProjectListDataDTO project) {
		return pjlService.createProjectProcess(project);
	}

	// 프로젝트 참여
	@PostMapping("/joinProjectProcess")
	public int joinProjectProcess(@RequestBody CodeEmailDTO codeEmailData) {
		return pjlService.joinProjectProcess(codeEmailData);
	}

	// 프로젝트 탈퇴
	@PostMapping("/exitProjectProcess")
	public int exitProjectProcess(@RequestBody CodeEmailDTO codeEmailData) {
		return pjlService.exitProjectProcess(codeEmailData);
	}

}
