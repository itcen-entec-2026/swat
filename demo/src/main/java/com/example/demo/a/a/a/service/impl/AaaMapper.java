package com.example.demo.a.a.a.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.a.a.a.service.AaaVo;

/**
 * 에이 에이 에이 Mapper
 */
@Mapper
public interface AaaMapper {

	/**
	 * 에이 에이 에이 조회(멀티건)
	 * 
	 * @param aaaVo
	 * @return
	 */
	public List<AaaVo> selectAaaList(AaaVo aaaVo);

}
