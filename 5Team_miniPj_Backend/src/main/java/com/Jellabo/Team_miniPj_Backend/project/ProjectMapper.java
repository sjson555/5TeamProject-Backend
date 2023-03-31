package com.Jellabo.Team_miniPj_Backend.project;

//어노테이션 필요없습니다.
public interface ProjectMapper {

	// 프로젝트 삭제
	int isCreator(ProjectDataDTO project);

	void dropReplesTable(String value);

	void dropCommentsTable(String value);

	void dropPostsTable(String value);

	void deleteCategory(int code);

	void deleteJoinedProject(int code);

	int deleteProject(int code);
	// 프로젝트 삭제

}
