package egovframework.swat.a.a.a.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;

/**
 * 3. Circuit 상태 변화 테스트 (중요 ⭐)
 */
@SpringBootTest
@Slf4j
class CircuitBreakerStateTest {

	@Autowired
	private ExternalService externalService;

	@Autowired
	private CircuitBreakerRegistry registry;

	@Test
	void circuitBreaker_OPEN_상태_확인() {

		CircuitBreaker cb = registry.circuitBreaker("testCircuit");

		// 실패 유도
//		for (int i = 0; i < 1; i++) {
//		for (int i = 0; i < 4; i++) {

//		for (int i = 0; i < 5; i++) {
		for (int i = 0; i < 10; i++) {
			if (log.isDebugEnabled()) {
				log.debug("i={}", i);
			}

			try {
				externalService.call();
			} catch (Exception ignored) {
			}
		}

		// 상태 확인
		assertEquals(CircuitBreaker.State.OPEN, cb.getState());
//		assertEquals(CircuitBreaker.State.CLOSED, cb.getState());
	}

	/**
	 * 6. HALF-OPEN 테스트 (고급 ⭐⭐⭐)
	 * 
	 * @throws InterruptedException
	 */
	@Test
	void circuitBreaker_HALF_OPEN_전이_테스트() throws InterruptedException {

		CircuitBreaker cb = registry.circuitBreaker("testCircuit");

		// OPEN 만들기
		for (int i = 0; i < 5; i++) {
			if (log.isDebugEnabled()) {
				log.debug("i={}", i);
			}

			try {
				externalService.call();
			} catch (Exception ignored) {
			}
		}

		assertEquals(CircuitBreaker.State.OPEN, cb.getState());

		// 대기 (OPEN → HALF-OPEN)
		Thread.sleep(1500);
//		Thread.sleep(2500);
//		Thread.sleep(9500);

		// OPEN → HALF_OPEN은 시간 + 호출이 있어야 전이된다
		externalService.call();

		assertEquals(CircuitBreaker.State.HALF_OPEN, cb.getState());
	}

}
