package com.winter.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.winter.app.interceptors.LoginCheckInterceptor;
import com.winter.app.interceptors.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
	
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//적용할 Interceptor 적용
		//member 로 시작하는 모든 URL, login, join
		//qna list를 제외한 나머지들은 회원만 가능
		registry.addInterceptor(loginCheckInterceptor)
				.addPathPatterns("/member/*", "/qna/*") //Interceptor를 사용할 URL 패턴 작성, addPathPatterns는 여러번 사용 가능
				.excludePathPatterns("/member/login", "/member/join", "/qna/list"); //Interceptor를 제외할 URL 패턴 작성, excludePathPatterns는 여러번 사용 가능
		
		registry.addInterceptor(writerCheckInterceptor)
				.addPathPatterns("/notice/update", "/qna/update");
		
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**");
		
	}

}
