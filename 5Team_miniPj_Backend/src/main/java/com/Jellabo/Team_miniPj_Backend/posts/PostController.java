package com.Jellabo.Team_miniPj_Backend.posts;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	private PostServiceImpl poService;

	public PostController(PostServiceImpl poService) {
		this.poService = poService;
	}

	// 게시글
	// 게시글 목록 불러오기
	@GetMapping("/project/{code}/{category}/loadPost")
	public List<PostDTO> loadPost(@PathVariable("code") int code, @PathVariable("category") String category) {
		int res = poService.loadPostCount(code, category);
		System.out.println("code : " + code);
		System.out.println("category : " + category);
		System.out.println("res : " + res);
		
		if (res != 0) {
			List<PostDTO> post = poService.loadPost(code, category);
			System.out.println("post : " + post);
			return post;
		}
		
		return null;
	}

	// 게시글 상세보기
	@GetMapping("/project/{code}/{category}/{postnum}")
	public PostDTO detailPost(@PathVariable("code") int code, @PathVariable("postnum") String postnum) {
		int res = poService.detailPostCount(code, postnum);
		System.out.println("code : " + code);
		System.out.println("postnum : " + postnum);
		System.out.println("res : " + res);
		
		if (res != 0) {
			PostDTO post = poService.detailPost(code, postnum);
			System.out.println("post : " + post);
			return post;
		}
		
		return null;
	}

	// 게시글 작성하기
	@PostMapping("/writePost")
	public int writePost(@RequestBody PostDTO post) {
		int res = poService.writePost(post);
		return res;

	}

	// 게시글 수정하기
	@PostMapping("/updatePost")
	public int updatePost(@RequestBody PostDTO post) {
		int res = poService.updatePost(post);
		return res;
	}

	// 게시글 삭제하기
	@PostMapping("/deletePost")
	public int deletePost(@RequestBody PostDTO post) {
		int res = poService.deletePost(post);
		return res;
	}

//	// 댓글
//	// 댓글 불러오기
//	@PostMapping("/loadComments")
//	public List<CommentDTO> loadComments(@RequestBody CommentDTO comment) {
//
//	}
//
//	// 댓글 작성하기
//	@PostMapping("/writeComment")
//	public int writeComment(@RequestBody CommentDTO comment) {
//
//	}
//
//	// 댓글 수정하기
//	@PostMapping("/updateComment")
//	public int updateComment(@RequestBody CommentDTO comment) {
//
//	}
//
//	// 댓글 삭제하기
//	@PostMapping("/deleteComment")
//	public int deleteComment(@RequestBody CommentDTO comment) {
//
//	}
//
//	// 답글(대댓글)
//	// 답글 불러오기
//	@PostMapping("/loadReples")
//	public List<RepleDTO> loadReples(@RequestBody RepleDTO reple) {
//
//	}
//
//	// 답글 작성하기
//	@PostMapping("/writeReple")
//	public int writeReple(@RequestBody RepleDTO reple) {
//
//	}
//
//	// 답글 수정하기
//	@PostMapping("/updateReple")
//	public int updateReple(@RequestBody RepleDTO reple) {
//
//	}
//
//	// 답글 삭제하기
//	@PostMapping("/deleteReple")
//	public int deleteReple(@RequestBody RepleDTO reple) {
//
//	}

}
