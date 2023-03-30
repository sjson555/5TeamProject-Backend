package com.Jellabo.Team_miniPj_Backend.projectList;

import org.springframework.stereotype.Service;

@Service("pjlService")
public class ProjectListServiceImpl implements ProjectListService {

	private ProjectListMapper mapper;

	public ProjectListServiceImpl(ProjectListMapper mapper) {
		this.mapper = mapper;
	}

	// 이 곳에 프로젝트 리스트 페이지에서 필요한 서비스 메서드 구현

}
