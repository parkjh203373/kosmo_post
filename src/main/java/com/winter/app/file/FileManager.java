package com.winter.app.file;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Value("${app.upload.base}")
	private String path;
	
	public boolean fileDelete(String name, FileDTO fileDTO) throws Exception {
		File file = new File(path, name);
		file = new File(file, fileDTO.getFileName());
		
		return file.delete();
		
	}
	
	public String fileSave(String name, MultipartFile mf) throws Exception {
		//1. 어디에 저장할 것인가
		File file = new File(path, name);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 파일명을 뭘로 할 것인가
		String fileName = UUID.randomUUID().toString();
		
		//3. 파일 이름
		fileName = fileName + "_" + mf.getOriginalFilename();
		
		file = new File(file, fileName);
		//4. 저장
		//mf.transferTo(file);
		FileCopyUtils.copy(mf.getBytes(), file);
		
		return fileName;
		
		
	}

}
