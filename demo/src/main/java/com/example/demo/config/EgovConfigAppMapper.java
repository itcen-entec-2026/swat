package com.example.demo.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class EgovConfigAppMapper {

	@Bean
	SqlSessionFactoryBean sqlSession(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setConfigLocation(pathMatchingResourcePatternResolver
				.getResource("classpath:/com/example/mapper/config/mapper-config.xml"));

		sqlSessionFactoryBean.setMapperLocations(
				pathMatchingResourcePatternResolver.getResources("classpath:/com/example/mapper/demo/**/*_mysql.xml"));

		return sqlSessionFactoryBean;
	}

	@Bean
	SqlSessionTemplate egovSqlSessionTemplate(SqlSessionFactory sqlSession) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSession);
		return sqlSessionTemplate;
	}

}
