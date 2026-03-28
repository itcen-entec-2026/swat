package egovframework.swat.a.a.a.service;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. 테스트 대상 코드 (예제)
 */
@Service
@Slf4j
public class ExternalService {

	@CircuitBreaker(name = "testCircuit", fallbackMethod = "fallback")
	public String call() {
		if (log.isDebugEnabled()) {
			log.debug("call");
		}

		throw new RuntimeException("API 실패");
//		return null;
	}

	public String fallback(Exception e) {
		if (log.isDebugEnabled()) {
			log.debug("fallback");
//			log.debug("e={}", e);
		}

		return "fallback";
	}
}