package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PostMapper {

	// 게시글 기능
	// 게시글 개수 확인
	int postCount(@Param("code") int code, @Param("category") String category);

	// 게시글 목록 불러오기
	List<PostDTO> loadPost(@Param("code") int code, @Param("category") String category);

	// 게시글 확인
	int detailPostCount(@Param("code") int code, @Param("postnum") String postnum);

	// 게시글 상세보기
	PostDTO detailPost(@Param("code") int code, @Param("postnum") String postnum);

	// 게시글 작성하기
	int writePost(PostDTO post);

	// 게시글 수정하기
	int updatePost(PostDTO post);

	// 게시글 삭제하기
	int deletePost(PostDTO post);

	// 댓글 기능
	// 댓글 개수 확인
	int commentsCount(CommentDTO comment);

	// 댓글 목록 불러오기
	List<CommentDTO> loadComments(CommentDTO comment);

	// 댓글 작성하기
	int writeComment(CommentDTO comment);

	// 댓글 수정하기
	int updateComment(CommentDTO comment);

	// 댓글 삭제하기
	int deleteComment(CommentDTO comment);

	// 답글 기능
	// 답글 개수 확인
	int replesCount(RepleDTO reple);

	// 답글 목록 불러오기
	List<RepleDTO> loadReples(RepleDTO reple);

	// 답글 작성하기
	int writeReple(RepleDTO reple);

	// 답글 수정하기
	int updateReple(RepleDTO reple);

	// 답글 삭제하기
	int deleteReple(RepleDTO reple);

}
