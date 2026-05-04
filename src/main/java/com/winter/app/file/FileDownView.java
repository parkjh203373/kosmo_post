package com.winter.app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownView extends AbstractView {
	
	@Value("${app.upload.base}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		Iterator<String> it = model.keySet().iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		FileDTO fileDTO = (FileDTO)model.get("fileDTO");
		String name = (String)model.get("name");
		
		File file = new File(base, name);
		file = new File(file, fileDTO.getFileName());
		
		response.setCharacterEncoding("UTF-8");
		
		response.setContentLengthLong(file.length());
		
		String oriName = fileDTO.getOriName();
		oriName = URLEncoder.encode(oriName, "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		//파일 읽어 오는 준비
		FileInputStream fi = new FileInputStream(file);
		//Client 로 내보내는 준비
		OutputStream os = response.getOutputStream();
		
		//전송
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}

}
