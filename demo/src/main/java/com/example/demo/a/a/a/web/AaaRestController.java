package com.example.demo.a.a.a.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.a.a.a.service.AaaService;
import com.example.demo.a.a.a.service.AaaVo;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 에이 에이 에이 RestController
 */
@RestController
@RequestMapping("/api/v1/aaa")
@RequiredArgsConstructor
@Slf4j
public class AaaRestController {

	private final AaaService aaaService;

	private final HikariDataSource hikariDataSource;

	/**
	 * 에이 에이 에이 조회(멀티건)
	 * 
	 * @param aaaVo
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<AaaVo>> selectAaaList(AaaVo aaaVo) {
		if (log.isInfoEnabled()) {
			log.info("aaaVo={}", aaaVo);
			log.info("getCodeId={}", aaaVo.getCodeId());

			log.info("hikariDataSource={}", hikariDataSource);
			log.info("getMaximumPoolSize={}", hikariDataSource.getMaximumPoolSize());
		}

		if (ObjectUtils.isEmpty(aaaVo.getCodeId())) {
//			aaaVo.setCodeId("COM001");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		return ResponseEntity.ok(aaaService.selectAaaList(aaaVo));
	}

}
