package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.file.FileManager;

@Service
public class MemberServiceimpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.member}")
	private String name;
	
	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		
		return memberMapper.update(memberDTO);
	}
	
	//사용자 정의 검증 메서드
	public boolean doubleCheck(MemberDTO memberDTO, BindingResult bindingResult) throws Exception {
		//false 면 검증 통과, true 면 검증 실패
		boolean result = false;
		
		//annotation 으로 검증한 결과 담기
		result = bindingResult.hasErrors();
		
		//password 일치 검증
		if(!memberDTO.getPassword().equals(memberDTO.getPasswordCheck())) {
			bindingResult.rejectValue("passwordCheck", "member.passwordCheck.notEqual");
			result = true;
		}
		
		//ID 중복 검사
		MemberDTO m = memberMapper.detail(memberDTO);
		
		if(m != null) {
			result = true;
			bindingResult.rejectValue("username", "member.username.equal");;
		}
		
		return result;
	}
	
	@Override
	public int join(MemberDTO memberDTO, MultipartFile file) throws Exception {
		//DB에 저장
		int result = memberMapper.join(memberDTO);
		
		//profile 이미지를 하드디스크에 저장
		if(file != null && !file.isEmpty()) {
			String fileName = fileManager.fileSave(name, file);
			
			//저장된 정보 DB에 저장
			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setFileName(fileName);
			profileDTO.setOriName(file.getOriginalFilename());
			profileDTO.setUsername(memberDTO.getUsername());
			
			result = memberMapper.addProfile(profileDTO);
		}
		
		return result;
	}
	
	@Override
	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		MemberDTO check = memberMapper.detail(memberDTO);
		
		if(check!=null) {
			if(check.getPassword().equals(memberDTO.getPassword())) {
				return check;
			}
			
		}
		
		return null;
	}

	@Override
	public MemberDTO idCheck(MemberDTO memberDTO) throws Exception {
		
		return memberMapper.detail(memberDTO);
	}
	
	

}
