package com.Jellabo.Team_miniPj_Backend.projectList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Jellabo.Team_miniPj_Backend.CodeEmailDTO;

public interface ProjectListMapper {

	// 프로젝트 리스트 불러오기
	int projectsListCheck(String email);

	List<ProjectListDataDTO> loadProjectList(String email);

	// 프로젝트 생성
	List<Integer> codeList();

	void insertProject(ProjectListDataDTO project);

	void insertJoinedProject(@Param("code") int code, @Param("creatoremail") String creatoremail);

	void createPostsTable(String createPostQuery);

	void createCommentsTable(String createCommentsQuery);

	void createReplesTable(String createReplesQuery);

	int insertCategory(int code);

	// 프로젝트 참여
	int projectCodeCheck(int code);

	int projectJoinCheck(CodeEmailDTO data);

	int joinProjectProcess(CodeEmailDTO data);

	// 프로젝트 탈퇴
	int projectCreatorCheck(CodeEmailDTO data);

	int exitProjectProcess(CodeEmailDTO data);

}
