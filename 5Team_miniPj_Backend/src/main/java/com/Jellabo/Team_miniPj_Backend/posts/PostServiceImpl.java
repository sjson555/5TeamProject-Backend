package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("poService")
public class PostServiceImpl implements PostService {

	private PostMapper mapper;

	public PostServiceImpl(PostMapper mapper) {
		this.mapper = mapper;
	}

	// 이 곳에 프로젝트 페이지 게시글에서 필요한 서비스 메서드 구현
	
	//카테고리 별 게시글 불러오기
	@Override
	public List<PostDTO> loadPost(int code, String category) {
		List<PostDTO> post = mapper.loadPost(code, category);
		return post;
	}
	
	@Override
	public int loadPostCount(int code, String category) {
		int res = mapper.loadPostCount(code, category);
		return res;
	}
	
	// 글 상세보기
	@Override
	public PostDTO detailPost(int code, String postnum) {
		PostDTO post = mapper.detailPost(code, postnum);
		return post;
	}
	
	@Override
	public int detailPostCount(int code, String postnum) {
		int res = mapper.detailPostCount(code, postnum);
		return res;
	}
	
	
	// 글 작성하기
	@Override
	public int writePost(PostDTO post) {
		System.out.println("writePost : " + post);
		int res = mapper.writePost(post);
		return res;
	}
	
	// 글 수정하기
	@Override
	public int updatePost(PostDTO post) {
		System.out.println("updatePost : " + post);
		int res = mapper.updatePost(post);
		return res;
	}
	
	// 글 삭제하기
	@Override
	public int deletePost(PostDTO post) {
		System.out.println("deletePost : " + post);
		int res = mapper.deletePost(post);
		return res;
	}
}
