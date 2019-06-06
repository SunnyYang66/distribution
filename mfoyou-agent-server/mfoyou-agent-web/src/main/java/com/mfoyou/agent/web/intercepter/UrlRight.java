package com.mfoyou.agent.web.intercepter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface UrlRight {
	
	//0所有可访问1登陆后可访问2基础访问3标准访问
	public UserRight[] value() default {UserRight.ADMINACCESS};

}
