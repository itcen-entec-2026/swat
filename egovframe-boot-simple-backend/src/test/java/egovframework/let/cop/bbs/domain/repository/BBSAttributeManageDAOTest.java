package egovframework.let.cop.bbs.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import egovframework.let.cop.bbs.domain.model.BoardMaster;
import egovframework.let.cop.bbs.domain.model.BoardMasterVO;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BBSAttributeManageDAOTest {

	@Autowired
	BBSAttributeManageDAO bbsAttributeManageDAO;

	@Test
	void deleteBBSMasterInf() throws BaseRuntimeException, Exception {
		// given
		BoardMaster boardMaster = new BoardMaster();
		boardMaster.setLastUpdusrId("TEST_USRCNFRM_000000");
		boardMaster.setBbsId("BBSMSTR_AAAAAAAAAAAA");

		// when
		int result = bbsAttributeManageDAO.deleteBBSMasterInf(boardMaster);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertThat(result).isGreaterThan(0);
	}

	@Test
	void insertBBSMasterInf() throws BaseRuntimeException, Exception {
		// given
		BoardMaster boardMaster = new BoardMaster();
		boardMaster.setPosblAtchFileSize("5242880");

		// when
		int result = bbsAttributeManageDAO.insertBBSMasterInf(boardMaster);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertThat(result).isGreaterThan(0);
	}

	@Test
	void selectBBSMasterInf() throws BaseRuntimeException, Exception {
		// given
		BoardMasterVO searchVO = new BoardMasterVO();
		searchVO.setBbsId("BBSMSTR_AAAAAAAAAAAA");

		// when
		BoardMasterVO result = bbsAttributeManageDAO.selectBBSMasterInf(searchVO);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
			log.debug("getBbsId={}", result.getBbsId());
			log.debug("getBbsTyCode={}", result.getBbsTyCode());
			log.debug("getBbsAttrbCode={}", result.getBbsAttrbCode());
			log.debug("getBbsNm={}", result.getBbsNm());
			log.debug("getBbsNm={}", result.getBbsIntrcn());
			log.debug("getBbsNm={}", result.getReplyPosblAt());
			log.debug("getBbsNm={}", result.getFileAtchPosblAt());
			log.debug("getBbsNm={}", result.getPosblAtchFileNumber());
			log.debug("getBbsNm={}", result.getPosblAtchFileSize());
			log.debug("getTmplatId={}", result.getTmplatId());
			log.debug("getFrstRegisterId={}", result.getFrstRegisterId());
			log.debug("getFrstRegisterNm={}", result.getFrstRegisterNm());
			log.debug("getFrstRegisterPnttm={}", result.getFrstRegisterPnttm());
			log.debug("getBbsTyCodeNm={}", result.getBbsTyCodeNm());
			log.debug("getBbsAttrbCodeNm={}", result.getBbsAttrbCodeNm());
			log.debug("getAuthFlag={}", result.getAuthFlag());
		}

		// then
		assertThat(result.getBbsId()).isEqualTo(searchVO.getBbsId());
	}

	@Test
	void selectBBSMasterInfs() throws BaseRuntimeException, Exception {
		// given
		BoardMasterVO vo = new BoardMasterVO();
		vo.setRecordCountPerPage(10);
		vo.setFirstIndex(0);

		// when
		List<BoardMasterVO> results = bbsAttributeManageDAO.selectBBSMasterInfs(vo);

		if (log.isDebugEnabled()) {
			log.debug("results={}", results);
			log.debug("size={}", results.size());
		}

		for (BoardMasterVO result : results) {
			if (log.isDebugEnabled()) {
				log.debug("result={}", result);
				log.debug("getBbsId={}", result.getBbsId());
				log.debug("getBbsTyCode={}", result.getBbsTyCode());
				log.debug("getBbsTyCodeNm={}", result.getBbsTyCodeNm());
				log.debug("getBbsAttrbCode={}", result.getBbsAttrbCode());
				log.debug("getBbsAttrbCodeNm={}", result.getBbsAttrbCodeNm());
				log.debug("getBbsNm={}", result.getBbsNm());
				log.debug("getTmplatId={}", result.getTmplatId());
				log.debug("getUseAt={}", result.getUseAt());
				log.debug("getFrstRegisterPnttm={}", result.getFrstRegisterPnttm());
			}
		}

		// then
		assertThat(results).isNotNull();
	}

	@Test
	void selectBBSMasterInfsCnt() throws BaseRuntimeException, Exception {
		// given
		BoardMasterVO vo = new BoardMasterVO();

		// when
		int result = bbsAttributeManageDAO.selectBBSMasterInfsCnt(vo);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertThat(result).isGreaterThan(0);
	}

	@Test
	void updateBBSMasterInf() throws BaseRuntimeException, Exception {
		// given
		BoardMaster boardMaster = new BoardMaster();
		boardMaster.setBbsNm("");
		boardMaster.setBbsIntrcn("");
		boardMaster.setFileAtchPosblAt("");
		boardMaster.setPosblAtchFileNumber(0);
		boardMaster.setPosblAtchFileSize("5242880");
		boardMaster.setTmplatId("");
		boardMaster.setLastUpdusrId("TEST_USRCNFRM_000000");
		boardMaster.setBbsId("BBSMSTR_AAAAAAAAAAAA");

		// when
		int result = bbsAttributeManageDAO.updateBBSMasterInf(boardMaster);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertThat(result).isGreaterThan(0);
	}

}
