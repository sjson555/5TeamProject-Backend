package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("poService")
public class PostServiceImpl implements PostService {

	private PostMapper mapper;

	public PostServiceImpl(PostMapper mapper) {
		this.mapper = mapper;
	}

	// 게시글 기능
	@Override // 게시글 목록 불러오기
	public List<PostDTO> loadPost(int code, String category) {
		List<PostDTO> postList;
		int count = mapper.postCount(code, category);

		if (count == 0) {
			postList = null;
		} else {
			postList = mapper.loadPost(code, category);
		}

		return postList;
	}

	@Override // 게시글 상세보기
	public PostDTO detailPost(int code, String postnum) {
		PostDTO post;
		int count = mapper.detailPostCount(code, postnum);

		if (count == 0) {
			post = null;
		} else {
			post = mapper.detailPost(code, postnum);
		}

		return post;
	}

	@Override // 게시글 작성하기
	public int writePost(PostDTO post) {
		return mapper.writePost(post);
	}

	@Override // 게시글 수정하기
	public int updatePost(PostDTO post) {
		return mapper.updatePost(post);
	}

	@Override // 게시글 삭제하기
	public int deletePost(PostDTO post) {
		return mapper.deletePost(post);
	}

	// 댓글 기능
	@Override // 댓글 목록 불러오기
	public List<CommentDTO> loadComments(CommentDTO comment) {
		List<CommentDTO> res;
		int count = mapper.commentsCount(comment);

		if (count == 0) {
			res = null;
		} else {
			res = mapper.loadComments(comment);
		}

		return res;
	}

	@Override // 댓글 작성하기
	public int writeComment(CommentDTO comment) {
		return mapper.writeComment(comment);
	}

	@Override // 댓글 수정하기
	public int updateComment(CommentDTO comment) {
		return mapper.updateComment(comment);
	}

	@Override // 댓글 삭제하기
	public int deleteComment(CommentDTO comment) {
		return mapper.deleteComment(comment);
	}

	// 답글 기능
	@Override // 답글 목록 불러오기
	public List<RepleDTO> loadReples(RepleDTO reple) {
		List<RepleDTO> res;
		int count = mapper.replesCount(reple);

		if (count == 0) {
			res = null;
		} else {
			res = mapper.loadReples(reple);
		}

		return res;
	}

	@Override // 답글 작성하기
	public int writeReple(RepleDTO reple) {
		return mapper.writeReple(reple);
	}

	@Override // 답글 수정하기
	public int updateReple(RepleDTO reple) {
		return mapper.updateReple(reple);
	}

	@Override // 답글 삭제하기
	public int deleteReple(RepleDTO reple) {
		return mapper.deleteReple(reple);
	}

}
