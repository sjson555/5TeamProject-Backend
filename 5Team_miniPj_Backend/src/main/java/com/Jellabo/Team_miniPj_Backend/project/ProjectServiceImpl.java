package com.Jellabo.Team_miniPj_Backend.project;

import org.springframework.stereotype.Service;

@Service("pjService")
public class ProjectServiceImpl implements ProjectService {

	private ProjectMapper mapper;

	public ProjectServiceImpl(ProjectMapper mapper) {
		this.mapper = mapper;
	}

	// 이 곳에 프로젝트 페이지에서 필요한 매퍼 메서드 구현

}
