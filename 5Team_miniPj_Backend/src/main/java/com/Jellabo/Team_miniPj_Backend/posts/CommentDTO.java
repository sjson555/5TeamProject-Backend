package com.Jellabo.Team_miniPj_Backend.posts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
	private int code;
	private int postnum;
	private int commentnum;
	private String commentcontent;
	private String cowriteremail;
	private String nickname;
}
