package com.Jellabo.Team_miniPj_Backend.projectList;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListDataDTO {
	private int code;
	private String title;
	private String description;
	private String creatoremail;
	private Date deadline;
}
