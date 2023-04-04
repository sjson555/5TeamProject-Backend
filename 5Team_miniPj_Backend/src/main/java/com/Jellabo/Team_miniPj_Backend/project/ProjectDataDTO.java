package com.Jellabo.Team_miniPj_Backend.project;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDataDTO {
	private int code;
	private String title;
	private String description;
	private String nickname;
	private String creatoremail;
	private Date deadline;
}
