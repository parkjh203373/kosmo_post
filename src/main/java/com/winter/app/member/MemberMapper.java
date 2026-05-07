package com.winter.app.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public abstract int update(MemberDTO memberDTO) throws Exception;
	
	public abstract int join(MemberDTO memberDTO) throws Exception;
	
	public abstract int addProfile(ProfileDTO profileDTO) throws Exception;
	
	public abstract MemberDTO detail(MemberDTO memberDTO) throws Exception;
	

}
