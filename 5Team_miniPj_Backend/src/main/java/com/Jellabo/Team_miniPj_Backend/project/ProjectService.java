package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import com.Jellabo.Team_miniPj_Backend.users.UserDTO;

public interface ProjectService {

	// 프로젝트 정보 불러오기
	public ProjectDataDTO loadProjectInfo(int code, String email);

	// 카테고리 목록 불러오기
	public List<String> loadCategories(int code);

	// 카테고리 생성
	public int createCategoryProcess(CategoryDTO categoryData);

	// 카테고리 삭제
	public int deleteCategoryProcess(CategoryDTO categoryData);

	// 참여자 목록 불러오기
	public List<UserDTO> loadUserList(int code);

	// 참여자 초대
	public int addUserProcess(int code, String email);

	// 참여자 강퇴
	public int kickUserProcess(int code, String email);

	// 프로젝트 초기화
	public int resettingProjectProcess(ProjectDataDTO project);

}
