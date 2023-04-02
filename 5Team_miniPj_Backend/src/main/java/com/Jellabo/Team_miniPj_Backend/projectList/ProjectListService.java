package com.Jellabo.Team_miniPj_Backend.projectList;

import java.util.List;

public interface ProjectListService {

	// 프로젝트 리스트 불러오기
	List<ProjectListDataDTO> loadProjectList(String email);

	// 프로젝트 생성
	int createProjectProcess(ProjectListDataDTO project);

	// 프로젝트 참여
	int joinProjectProcess(ProjectListDataDTO project);

	// 프로젝트 탈퇴
	int exitProjectProcess(ProjectListDataDTO project);

}
