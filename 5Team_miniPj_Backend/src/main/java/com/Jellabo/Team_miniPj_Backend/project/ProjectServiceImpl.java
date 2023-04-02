package com.Jellabo.Team_miniPj_Backend.project;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Jellabo.Team_miniPj_Backend.users.UserDTO;

@Service("pjService")
public class ProjectServiceImpl implements ProjectService {

	private ProjectMapper mapper;

	public ProjectServiceImpl(ProjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override // 현재 프로젝트 정보 불러오기
	public ProjectDataDTO loadProjectInfo(int code, String email) {
		ProjectDataDTO res;
		int count1 = mapper.projectCodeCheck(code);

		if (count1 == 0) {
			res = new ProjectDataDTO();
			res.setCode(-1);
		} else {
			int count2 = mapper.projectJoinCheck(code, email);

			if (count2 == 0) {
				res = new ProjectDataDTO();
				res.setCode(0);
			} else {
				res = mapper.loadProjectInfo(code, email);
			}
		}

		return res;
	}

	@Override // 현재 프로젝트 카테고리 불러오기
	public List<String> loadCategories(int code) {
		return mapper.loadCategories(code);
	}

	@Override // 카테고리 생성
	public int createCategoryProcess(CategoryDTO categoryData) {
		return mapper.createCategoryProcess(categoryData);
	}

	@Override // 카테고리 삭제
	public int deleteCategoryProcess(CategoryDTO categoryData) {
		String category = categoryData.getCategory();
		if (category.equals("★ 개요") || category.equals("공지사항")) {
			return 0;
		} else {
			mapper.deleteCategoryPost(categoryData); // 해당 카테고리 게시글 삭제
			return mapper.deleteCategoryProcess(categoryData); // 카테고리 삭제
		}
	}

	@Override // 현재 프로젝트 참여자 목록 불러오기
	public List<UserDTO> loadUserList(int code) {
		return mapper.loadUserList(code);
	}

	@Override // 멤버 추가
	public int addUserProcess(int code, String email) {
		int result;
		int res = mapper.emailCheck(email);

		if (res == 0) {
			result = -1;
		} else {
			res = mapper.addUserProcess(code, email);
			if (res == 0) {
				result = 0;
			} else {
				result = 1;
			}
		}

		return result;
	}

	@Override // 멤버 추방
	public int kickUserProcess(int code, String email) {
		return mapper.kickUserProcess(code, email);
	}

	@Override // 현재 프로젝트 정보 수정
	public int resettingProjectProcess(ProjectDataDTO projectData) {
		return mapper.resettingProjectProcess(projectData);
	}

	@Override // 프로젝트 삭제
	public int deleteProjectProcess(ProjectDataDTO projectData) {
		// 프로젝트 관리자인지 확인(0 or 1)
		int res = mapper.isCreator(projectData);

		if (res == 1) {
			String sqlQuery1 = "", sqlQuery2 = "", sqlQuery3 = "";

			// 해당 프로젝트의 답글 테이블 삭제
			sqlQuery1 += "DROP TABLE reples" + projectData.getCode() + ";";
			mapper.dropReplesTable(sqlQuery1);

			// 해당 프로젝트의 댓글 테이블 삭제
			sqlQuery2 += "DROP TABLE comments" + projectData.getCode() + ";";
			mapper.dropCommentsTable(sqlQuery2);

			// 해당 프로젝트의 게시글 테이블 삭제
			sqlQuery3 += "DROP TABLE posts" + projectData.getCode() + ";";
			mapper.dropPostsTable(sqlQuery3);

			// 해당 프로젝트의 카테고리 삭제
			mapper.deleteCategory(projectData.getCode());

			// 해당 프로젝트의 참여자 목록 삭제
			mapper.deleteJoinedProject(projectData.getCode());

			// 해당 프로젝트 삭제
			mapper.deleteProject(projectData.getCode());
		}

		return res;
	}

}
