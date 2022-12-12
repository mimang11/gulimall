package com.amm.gulimall.member.dao;

import com.amm.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author amm
 * @email 123@gmail.com
 * @date 2022-12-11 20:53:47
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
