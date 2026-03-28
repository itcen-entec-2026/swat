package egovframework.swat.a.a.a.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 2. 기본 단위 테스트 (fallback 검증)
 */
@SpringBootTest
class CircuitBreakerTest {

	@Autowired
	private ExternalService externalService;

	@Test
	void circuitBreaker_fallback_호출_테스트() {
		String result = externalService.call();

		assertEquals("fallback", result);
	}
}
