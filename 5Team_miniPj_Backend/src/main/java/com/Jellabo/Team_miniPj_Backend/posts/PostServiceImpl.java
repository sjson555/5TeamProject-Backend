package com.Jellabo.Team_miniPj_Backend.posts;

import org.springframework.stereotype.Service;

@Service("poService")
public class PostServiceImpl implements PostService {

	private PostMapper mapper;

	public PostServiceImpl(PostMapper mapper) {
		this.mapper = mapper;
	}

	// 이 곳에 프로젝트 페이지 게시글에서 필요한 서비스 메서드 구현
}
