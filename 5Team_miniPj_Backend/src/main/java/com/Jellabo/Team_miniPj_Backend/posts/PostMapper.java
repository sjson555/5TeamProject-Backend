package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PostMapper {

	// 이 곳에 프로젝트 페이지 게시글에서 필요한 매퍼 메서드 구현
	public List<PostDTO> loadPost(@Param("code") int code, @Param("category") String category);
	public int loadPostCount(@Param("code") int code, @Param("category") String category);
	public PostDTO detailPost(@Param("code") int code, @Param("postnum") String postnum);
	public int detailPostCount(@Param("code") int code, @Param("postnum") String postnum);
	public int writePost(PostDTO post);
	public int updatePost(PostDTO post);
	public int deletePost(PostDTO post);
}
