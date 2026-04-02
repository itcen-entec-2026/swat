package egovframework;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 현재 디렉토리에서 모든 Java 파일 검색 → DAO 파일만 필터링 → 로그 출력 테스트 코드
 */
@Slf4j
class SwatTest {

	@Test
	void test() {
		final File directory = new File("./");
		final String[] extensions = { "java" };
		final boolean recursive = true;

		Collection<File> listFiles = FileUtils.listFiles(directory, extensions, recursive);

		if (log.isDebugEnabled()) {
			log.debug("listFiles={}", listFiles);
			log.debug("size={}", listFiles.size());
		}

		int i = 1;

		for (File listFile : listFiles) {
			String name = listFile.getName().toLowerCase();
			if (name.endsWith("dao.java")) {
				if (log.isDebugEnabled()) {
					log.debug("i={}", i);
					log.debug("listFile={}", listFile);
				}

				i++;
			} else {
				continue;
			}
		}
	}

}
