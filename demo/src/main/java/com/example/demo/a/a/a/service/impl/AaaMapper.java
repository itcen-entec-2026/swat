package com.example.demo.a.a.a.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.a.a.a.service.AaaVo;

/**
 * 
 */
@Mapper
public interface AaaMapper {

	/**
	 * 
	 * @param aaaVo
	 * @return
	 */
	public List<AaaVo> selectAaaList(AaaVo aaaVo);

}
