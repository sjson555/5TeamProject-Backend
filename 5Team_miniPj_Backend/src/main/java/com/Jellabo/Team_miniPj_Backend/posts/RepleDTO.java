package com.Jellabo.Team_miniPj_Backend.posts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepleDTO {
	private int code;
	private int postnum;
	private int commentnum;
	private int replenum;
	private String replecontent;
	private String rewriteremail;
	private String nickname;
}
