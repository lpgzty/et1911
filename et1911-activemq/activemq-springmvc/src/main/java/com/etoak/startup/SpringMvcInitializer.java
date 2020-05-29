package com.etoak.startup;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.etoak.config.RootConfig;
import com.etoak.config.SpringMvcConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] { RootConfig.class};
	}

	/**
	 * spring mvc 地址
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//DispatcherServlet拦截地址                                                                                                                                                                                   
		return new String[] {"/"};
	}

}
