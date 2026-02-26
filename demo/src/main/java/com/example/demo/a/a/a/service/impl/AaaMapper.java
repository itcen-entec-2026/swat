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
	 * 에이 에이 에이 등록
	 * 
	 * @param aaaVo
	 * @return
	 */
	int insertAaa(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 등록2
	 * 
	 * @param aaaVo
	 * @return
	 */
	int insert2Aaa(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 조회(단건)
	 * 
	 * @param aaaVo
	 * @return
	 */
	AaaVo selectAaa(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 조회(멀티건)
	 * 
	 * @param aaaVo
	 * @return
	 */
	List<AaaVo> selectAaaList(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 수정
	 * 
	 * @param aaaVo
	 * @return
	 */
	int updateAaa(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 삭제
	 * 
	 * @param aaaVo
	 * @return
	 */
	int deleteAaa(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 등록/수정
	 * 
	 * @param aaaVo
	 * @return
	 */
	int mergeAaa(AaaVo aaaVo);

	/**
	 * 에이 에이 에이 등록/수정/삭제
	 * 
	 * @param aaaVo
	 * @return
	 */
	int multiAaa(AaaVo aaaVo);

}
