package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Jellabo.Team_miniPj_Backend.users.UserDTO;

@Service("pjService")
public class ProjectServiceImpl implements ProjectService {

	private ProjectMapper mapper;

	public ProjectServiceImpl(ProjectMapper mapper) {
		this.mapper = mapper;
	}

	// 프로젝트 정보 불러오기
	@Override
	public ProjectDataDTO loadProjectInfo(int code, String email) {
		return mapper.loadProjectInfo(code, email);
	}

	// 카테고리 목록 불러오기
	@Override
	public List<String> loadCategories(int code) {
		return mapper.loadCategories(code);
	}

	// 카테고리 생성
	@Override
	public int createCategoryProcess(CategoryDTO categoryData) {
		return mapper.createCategoryProcess(categoryData);
	}

	// 카테고리 삭제
	@Override
	public int deleteCategoryProcess(CategoryDTO categoryData) {
		return mapper.deleteCategoryProcess(categoryData);
	}

	// 참여자 목록 불러오기
	@Override
	public List<UserDTO> loadUserList(int code) {
		return mapper.loadUserList(code);
	}

	// 참여자 초대
	@Override
	public int addUserProcess(int code, String email) {
		return mapper.addUserProcess(code, email);
	}

	// 참여자 강퇴
	@Override
	public int kickUserProcess(int code, String email) {
		return mapper.kickUserProcess(code, email);
	}

	// 프로젝트 수정
	@Override
	public int resettingProjectProcess(ProjectDataDTO project) {
		return mapper.resettingProjectProcess(project);
	}

}
