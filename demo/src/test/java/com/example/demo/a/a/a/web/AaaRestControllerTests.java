package com.example.demo.a.a.a.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.a.a.a.service.AaaVo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class AaaRestControllerTests {

	@Autowired
	MockMvc mvc;

	@Test
	void selectAaaList() throws Exception {
		// given
		AaaVo aaaVo = new AaaVo();
		aaaVo.setCodeId("COM001");

		if (log.isDebugEnabled()) {
			log.debug("aaaVo={}", aaaVo);
			log.debug("getCodeId={}", aaaVo.getCodeId());
		}

		mvc.perform(

				get("/api/v1/aaa")

						.queryParam("codeId", aaaVo.getCodeId())

		)

				.andDo(print())

				.andExpect(status().isOk())

				.andExpect(jsonPath("$[0].codeId").value(aaaVo.getCodeId()))

				.andExpect(jsonPath("$[1].codeId").value(aaaVo.getCodeId()))

		;
	}

	@Test
	void selectAaaList2() throws Exception {
		mvc.perform(

				get("/api/v1/aaa")

		)

				.andExpect(status().isBadRequest())

				.andDo(print())

		;
	}

}
