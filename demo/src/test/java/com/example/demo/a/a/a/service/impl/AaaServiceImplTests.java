package com.example.demo.a.a.a.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.a.a.a.service.AaaService;
import com.example.demo.a.a.a.service.AaaVo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AaaServiceImplTests {

	@Autowired
	AaaService aaaService;

	@Test
	void selectAaaList() {
		// given
		AaaVo aaaVo = new AaaVo();
		aaaVo.setCodeId("COM001");

		if (log.isDebugEnabled()) {
			log.debug("aaaVo={}", aaaVo);
			log.debug("getCodeId={}", aaaVo.getCodeId());
		}

		// when
		List<AaaVo> results = aaaService.selectAaaList(aaaVo);

		if (log.isDebugEnabled()) {
			log.debug("results={}", results);
			log.debug("aaaVo.getCodeId(), results.get(0).getCodeId()={}, {}", aaaVo.getCodeId(),
					results.get(0).getCodeId());
		}

		// then
		assertEquals(aaaVo.getCodeId(), results.get(0).getCodeId());
	}

}
