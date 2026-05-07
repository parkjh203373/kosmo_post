package com.winter.app.configs;

import java.util.Locale;

import org.apache.catalina.valves.JsonAccessLogValve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class MessageMappingConfig implements WebMvcConfigurer {
	
	//사용자가 원하는 언어 설정을 받아서 변환하는 클래스
	//session. cookie
	
	@Bean
	LocaleResolver localeResolver() {
		//1. Session
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		
		//2. Cookie
		CookieLocaleResolver resolver2 = new CookieLocaleResolver();
		resolver2.setDefaultLocale(Locale.KOREAN);
		
		return resolver2;
	}
	
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");
		
		return changeInterceptor;
	}

}
