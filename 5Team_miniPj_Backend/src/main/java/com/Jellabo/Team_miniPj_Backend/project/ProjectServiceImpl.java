package com.Jellabo.Team_miniPj_Backend.project;

import org.springframework.stereotype.Service;

@Service("pjService")
public class ProjectServiceImpl implements ProjectService {

	private ProjectMapper mapper;

	public ProjectServiceImpl(ProjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override // 프로젝트 삭제
	public int deleteProjectProcess(ProjectDataDTO project) {
		// 프로젝트 생성자인지 확인(0 or 1)
		int res = mapper.isCreator(project);

		if (res == 1) {
			String sqlQuery1 = "", sqlQuery2 = "", sqlQuery3 = "";

			// 해당 프로젝트의 답글 테이블 삭제
			sqlQuery1 += "DROP TABLE reples" + project.getCode() + ";";
			mapper.dropReplesTable(sqlQuery1);

			// 해당 프로젝트의 댓글 테이블 삭제
			sqlQuery2 += "DROP TABLE comments" + project.getCode() + ";";
			mapper.dropCommentsTable(sqlQuery2);

			// 해당 프로젝트의 게시글 테이블 삭제
			sqlQuery3 += "DROP TABLE posts" + project.getCode() + ";";
			mapper.dropPostsTable(sqlQuery3);

			// 해당 프로젝트의 카테고리 삭제
			mapper.deleteCategory(project.getCode());

			// 해당 프로젝트의 참여자 목록 삭제
			mapper.deleteJoinedProject(project.getCode());

			// 해당 프로젝트 삭제
			mapper.deleteProject(project.getCode());
		}

		return res;
	}

}
