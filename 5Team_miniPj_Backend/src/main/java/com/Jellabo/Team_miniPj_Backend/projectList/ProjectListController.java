package com.Jellabo.Team_miniPj_Backend.projectList;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectListController {

	private ProjectListServiceImpl pjlService;

	public ProjectListController(ProjectListServiceImpl pjlService) {
		this.pjlService = pjlService;
	}

//	@GetMapping("/myprojectslist")
//	public List<ProjectListDataDTO> loadProjectList(@RequestParam(value = "email") String email) {
//
//	}
//
//	@PostMapping("/createProjectProcess")
//	public int createProjectProcess(@RequestBody ProjectListDataDTO project) {
//
//	}
//
//	@PostMapping("/joinProjectProcess")
//	public int joinProjectProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
//
//	}
//
//	@PostMapping("/exitProjectProcess")
//	public int exitProjectProcess(@RequestParam(value = "code") int code, @RequestParam(value = "email") String email) {
//
//	}

}
