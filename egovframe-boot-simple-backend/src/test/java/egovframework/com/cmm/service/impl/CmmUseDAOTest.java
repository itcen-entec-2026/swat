package egovframework.com.cmm.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class CmmUseDAOTest {

	@Autowired
	CmmUseDAO cmmUseDAO;

	@Test
	void selectCmmCodeDetail() throws BaseRuntimeException, Exception {
		// given
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");
//		vo.setCodeId("COM003");

		// when
		List<CmmnDetailCode> results = cmmUseDAO.selectCmmCodeDetail(vo);

		if (log.isDebugEnabled()) {
			log.debug("results={}", results);
			log.debug("size={}", results.size());
		}

		for (CmmnDetailCode result : results) {
			if (log.isDebugEnabled()) {
				log.debug("result={}", result);
				log.debug("getCodeId={}", result.getCodeId());
				log.debug("getCode={}", result.getCode());
				log.debug("getCodeNm={}", result.getCodeNm());
				log.debug("getCodeDc={}", result.getCodeDc());
			}
		}

		// then
		assertThat(results).isNotNull();
	}

}
