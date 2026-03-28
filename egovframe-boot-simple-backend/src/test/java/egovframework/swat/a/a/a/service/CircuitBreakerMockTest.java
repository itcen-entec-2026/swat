//package egovframework.swat.a.a.a.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
///**
// * 4. Mock 기반 테스트 (외부 API 시뮬레이션)
// */
//@SpringBootTest
//class CircuitBreakerMockTest {
//
//	@MockBean
//	private ExternalApiClient client;
//
//	@Autowired
//	private ApiService apiService;
//
//	@Test
//	void circuitBreaker_외부API_실패_테스트() {
//
//		when(client.call()).thenThrow(new RuntimeException());
//
//		String result = apiService.callExternal();
//
//		assertEquals("fallback", result);
//	}
//}
