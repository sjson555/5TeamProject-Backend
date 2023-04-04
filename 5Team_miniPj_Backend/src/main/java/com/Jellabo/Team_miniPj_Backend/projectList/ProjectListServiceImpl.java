package com.Jellabo.Team_miniPj_Backend.projectList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Jellabo.Team_miniPj_Backend.CodeEmailDTO;

@Service("pjlService")
public class ProjectListServiceImpl implements ProjectListService {

	private ProjectListMapper mapper;

	public ProjectListServiceImpl(ProjectListMapper mapper) {
		this.mapper = mapper;
	}

	@Override // 프로젝트 리스트 불러오기
	public List<ProjectListDataDTO> loadProjectList(String email) {
		List<ProjectListDataDTO> res = null;
		int count = mapper.projectsListCheck(email);

		if (count != 0) {
			res = mapper.loadProjectList(email);
		}

		return res;
	}

	@Override // 프로젝트 생성
	public int createProjectProcess(ProjectListDataDTO project) {
		// 프로젝트 code 리스트 불러오기
		List<Integer> codeList = mapper.codeList();

		// 프로젝트 code 난수 생성
		int code;
		loop: while (true) {
			code = (int) (Math.random() * 10000000);

			if (code == 0) {
				continue loop;
			}

			for (Integer num : codeList) {
				if (code == num) {
					continue loop;
				}
			}

			project.setCode(code);
			break;
		}

		// 프로젝트 데이터 저장
		mapper.insertProject(project);

		// 참여 프로젝트 목록에 저장
		mapper.insertJoinedProject(code, project.getCreatoremail());

		String sqlQuery1 = "", sqlQuery2 = "", sqlQuery3 = "";

		// posts[code] 테이블 생성
		sqlQuery1 += "CREATE TABLE posts" + code + " (";
		sqlQuery1 += "	postnum  		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,";
		sqlQuery1 += "	category 		VARCHAR(15) NOT NULL,";
		sqlQuery1 += "	posttitle 		VARCHAR(40) NOT NULL,";
		sqlQuery1 += "	postcontent 	VARCHAR(5000) NOT NULL,";
		sqlQuery1 += "	powriteremail 	VARCHAR(40) NOT NULL,";
		sqlQuery1 += "	posteddate 		DATETIME DEFAULT CURRENT_TIMESTAMP,";
		sqlQuery1 += "	FOREIGN KEY(powriteremail) REFERENCES users(email) ON DELETE CASCADE ON UPDATE CASCADE";
		sqlQuery1 += ");";
		mapper.createPostsTable(sqlQuery1);

		// comments[code] 테이블 생성
		sqlQuery2 += "CREATE TABLE comments" + code + " (";
		sqlQuery2 += "	commentnum 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,";
		sqlQuery2 += "	postnum 		INT NOT NULL,";
		sqlQuery2 += "	commentcontent 	VARCHAR(200) NOT NULL,";
		sqlQuery2 += "	cowriteremail 	VARCHAR(40) NOT NULL,";
		sqlQuery2 += "	FOREIGN KEY(postnum) REFERENCES posts" + code + "(postnum) ON DELETE CASCADE,";
		sqlQuery2 += "	FOREIGN KEY(cowriteremail) REFERENCES users(email) ON DELETE CASCADE ON UPDATE CASCADE";
		sqlQuery2 += ");";
		mapper.createCommentsTable(sqlQuery2);

		// reples[code] 테이블 생성
		sqlQuery3 += "CREATE TABLE reples" + code + " (";
		sqlQuery3 += "	replenum 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,";
		sqlQuery3 += "	postnum 		INT NOT NULL,";
		sqlQuery3 += "	commentnum 		INT NOT NULL,";
		sqlQuery3 += "	replecontent 	VARCHAR(200) NOT NULL,";
		sqlQuery3 += "	rewriteremail 	VARCHAR(40) NOT NULL,";
		sqlQuery3 += "	FOREIGN KEY(postnum) REFERENCES posts" + code + "(postnum) ON DELETE CASCADE,";
		sqlQuery3 += "	FOREIGN KEY(commentnum) REFERENCES comments" + code + "(commentnum) ON DELETE CASCADE,";
		sqlQuery3 += "	FOREIGN KEY(rewriteremail) REFERENCES users(email) ON DELETE CASCADE ON UPDATE CASCADE";
		sqlQuery3 += ");";
		mapper.createReplesTable(sqlQuery3);

		// 필수 카테고리 추가
		int res = mapper.insertCategory(code);

		return res;
	}

	@Override // 프로젝트 참여
	public int joinProjectProcess(CodeEmailDTO codeEmailData) {
		int res = mapper.projectCodeCheck(codeEmailData.getCode());

		// 실재 프로젝트 여부 확인
		if (res == 0) {
			res = -1;
		} else {
			res = mapper.projectJoinCheck(codeEmailData);

			// 프로젝트 참여 중 여부 확인
			if (res == 1) {
				res = 0;
			} else {
				res = mapper.joinProjectProcess(codeEmailData);
			}
		}

		return res;
	}

	@Override // 프로젝트 탈퇴
	public int exitProjectProcess(CodeEmailDTO codeEmailData) {
		int res = mapper.projectCreatorCheck(codeEmailData);

		// 프로젝트 관리자 여부 확인
		if (res == 1) {
			res = 0;
		} else {
			res = mapper.exitProjectProcess(codeEmailData);
		}

		return res;
	}

}
