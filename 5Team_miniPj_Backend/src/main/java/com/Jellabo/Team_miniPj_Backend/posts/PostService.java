package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PostService {

	// 이 곳에 프로젝트 페이지 게시글에서 필요한 서비스 메서드 구현
	public List<PostDTO> loadPost(int code, String category);
	public int loadPostCount(int code, String category);
	public PostDTO detailPost(int code, String postnum);
	public int detailPostCount(int code, String postnum);
	public int writePost(PostDTO post);
	public int updatePost(PostDTO post);
	public int deletePost(PostDTO post);
}
