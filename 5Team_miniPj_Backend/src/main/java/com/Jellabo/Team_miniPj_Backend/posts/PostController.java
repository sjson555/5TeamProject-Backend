package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

	private PostServiceImpl poService;

	public PostController(PostServiceImpl poService) {
		this.poService = poService;
	}

	// 게시글
	// 게시글 목록 불러오기
	@GetMapping("/project/{code}/{category}")
	public List<PostDTO> loadPost(@PathVariable("code") String code, @PathVariable("category") String category) {
		int codeNum = Integer.parseInt(code);
		return poService.loadPost(codeNum, category);
	}

	// 게시글 상세보기
	@GetMapping("/project/{code}/{category}/{postnum}")
	public PostDTO detailPost(@PathVariable("code") String code, @PathVariable("postnum") String postnum) {
		int codeNum = Integer.parseInt(code);
		return poService.detailPost(codeNum, postnum);
	}

	// 게시글 작성하기
	@PostMapping("/writePost")
	public int writePost(@RequestBody PostDTO post) {
		return poService.writePost(post);

	}

	// 게시글 수정하기
	@PostMapping("/updatePost")
	public int updatePost(@RequestBody PostDTO post) {
		return poService.updatePost(post);
	}

	// 게시글 삭제하기
	@PostMapping("/deletePost")
	public int deletePost(@RequestBody PostDTO post) {
		return poService.deletePost(post);
	}

	// 댓글
	// 댓글 불러오기
	@PostMapping("/loadComments")
	public List<CommentDTO> loadComments(@RequestBody CommentDTO comment) {
		return poService.loadComments(comment);
	}

	// 댓글 작성하기
	@PostMapping("/writeComment")
	public int writeComment(@RequestBody CommentDTO comment) {
		return poService.writeComment(comment);
	}

	// 댓글 수정하기
	@PostMapping("/updateComment")
	public int updateComment(@RequestBody CommentDTO comment) {
		return poService.updateComment(comment);
	}

	// 댓글 삭제하기
	@PostMapping("/deleteComment")
	public int deleteComment(@RequestBody CommentDTO comment) {
		return poService.deleteComment(comment);
	}

	// 답글(대댓글)
	// 답글 불러오기
	@PostMapping("/loadReples")
	public List<RepleDTO> loadReples(@RequestBody RepleDTO reple) {
		return poService.loadReples(reple);
	}

	// 답글 작성하기
	@PostMapping("/writeReple")
	public int writeReple(@RequestBody RepleDTO reple) {
		return poService.writeReple(reple);
	}

	// 답글 수정하기
	@PostMapping("/updateReple")
	public int updateReple(@RequestBody RepleDTO reple) {
		return poService.updateReple(reple);
	}

	// 답글 삭제하기
	@PostMapping("/deleteReple")
	public int deleteReple(@RequestBody RepleDTO reple) {
		return poService.deleteReple(reple);
	}

}
