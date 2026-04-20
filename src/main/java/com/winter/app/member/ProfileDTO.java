package com.winter.app.member;

import com.winter.app.file.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProfileDTO extends FileDTO{
	
	private String username;

}
