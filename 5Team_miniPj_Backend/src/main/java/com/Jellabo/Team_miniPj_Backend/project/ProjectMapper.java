package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import com.Jellabo.Team_miniPj_Backend.users.UserDTO;

//어노테이션 필요없습니다.
public interface ProjectMapper {
	
	
	// 이 곳에 프로젝트 페이지에서 필요한 매퍼 메서드 구현
	public ProjectDataDTO loadProjectInfo(int code, String email);

	public List<String> loadCategories(int code);

	public int createCategoryProcess(CategoryDTO categoryData);

	public int deleteCategoryProcess(CategoryDTO categoryData);

	public List<UserDTO> loadUserList(int code);

	public int addUserProcess(int code, String email);

	public int kickUserProcess(int code, String email);

	public int resettingProjectProcess(ProjectDataDTO project);
}
