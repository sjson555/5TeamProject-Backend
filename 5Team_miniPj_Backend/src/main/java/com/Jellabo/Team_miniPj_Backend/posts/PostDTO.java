package com.Jellabo.Team_miniPj_Backend.posts;

import java.sql.Date;
//import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	private int postnum;
	private int code;
	private String category;
	private String posttitle;
	private String postcontent;
	private String nickname;
	private String powriteremail;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date posteddate;
}
