package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

public interface PostService {

	// 게시글 기능
	// 게시글 목록 불러오기
	List<PostDTO> loadPost(int code, String category);

	// 게시글 상세보기
	PostDTO detailPost(int code, String postnum);

	// 게시글 작성하기
	int writePost(PostDTO postData);

	// 게시글 수정하기
	int updatePost(PostDTO postData);

	// 게시글 삭제하기
	int deletePost(PostDTO postData);

	// 댓글 기능
	// 댓글 목록 불러오기
	List<CommentDTO> loadComments(CommentDTO comment);

	// 댓글 작성하기
	int writeComment(CommentDTO comment);

	// 댓글 수정하기
	int updateComment(CommentDTO comment);

	// 댓글 삭제하기
	int deleteComment(CommentDTO comment);

	// 답글 기능
	// 답글 목록 불러오기
	List<RepleDTO> loadReples(RepleDTO reple);

	// 답글 작성하기
	int writeReple(RepleDTO reple);

	// 답글 수정하기
	int updateReple(RepleDTO reple);

	// 답글 삭제하기
	int deleteReple(RepleDTO reple);

}
