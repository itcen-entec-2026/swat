package egovframework.let.main.web;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.let.cop.bbs.dto.request.BbsSearchRequestDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EgovMainApiControllerTest {

	@Test
	void test() {
		if (log.isDebugEnabled()) {
			log.debug("test");
		}

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/mainPage";

		String response = restTemplate.getForObject(url, String.class);

		if (log.isDebugEnabled()) {
			log.debug("response={}", response);
		}
	}

	@Test
	void test2() {
		if (log.isDebugEnabled()) {
			log.debug("test2");
		}

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/mainPage";

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (log.isDebugEnabled()) {
			log.debug("response={}", response);
			log.debug("getStatusCode={}", response.getStatusCode());
			log.debug("getBody={}", response.getBody());
		}
	}

	@Test
	void test3() {
		if (log.isDebugEnabled()) {
			log.debug("test3");
		}

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/mainPage";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		BbsSearchRequestDTO bbsSearchRequestDTO2 = new BbsSearchRequestDTO();
		bbsSearchRequestDTO2.setBbsId("BBSMSTR_AAAAAAAAAAAA");
//		String body = "{\"bbsId\":\"BBSMSTR_AAAAAAAAAAAA\"}";

		ObjectMapper objectMapper = new ObjectMapper();
		String body;
		try {
			body = objectMapper.writeValueAsString(bbsSearchRequestDTO2);
		} catch (JsonProcessingException e) {
			throw new BaseRuntimeException(e);
		}
		if (log.isDebugEnabled()) {
			log.debug("body={}", body);
		}

		HttpEntity<String> request = new HttpEntity<>(body, headers);

		String response = restTemplate.postForObject(url, request, String.class);

		if (log.isDebugEnabled()) {
			log.debug("response={}", response);
		}
	}

}
