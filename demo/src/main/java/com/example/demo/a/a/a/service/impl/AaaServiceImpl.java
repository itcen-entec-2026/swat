package com.example.demo.a.a.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.a.a.a.service.AaaService;
import com.example.demo.a.a.a.service.AaaVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 에이 에이 에이 ServiceImpl
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AaaServiceImpl implements AaaService {

	private final AaaMapper aaaMapper;

	@Override
	public List<AaaVo> selectAaaList(AaaVo aaaVo) {
		if (log.isDebugEnabled()) {
			log.debug("aaaVo={}", aaaVo);
			log.debug("getCodeId={}", aaaVo.getCodeId());
		}

		return aaaMapper.selectAaaList(aaaVo);
	}

}
