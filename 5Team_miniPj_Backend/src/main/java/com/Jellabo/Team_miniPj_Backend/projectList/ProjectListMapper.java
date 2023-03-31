package com.Jellabo.Team_miniPj_Backend.projectList;

import java.util.List;

// 어노테이션 필요없습니다.
public interface ProjectListMapper {

	// 프로젝트 생성
	List<Integer> codeList();

	void insertProject(ProjectListDataDTO project);

	void insertJoinedProject(ProjectListDataDTO project);

	void createPostsTable(String value);

	void createCommentsTable(String value);

	void createReplesTable(String value);

	int insertCategory(int code);
	// 프로젝트 생성

}
