package com.Springmvc.lc.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LCAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] configClasses= {LCAppConfig.class};
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		String[] mappings= {"/"};
		return mappings;
	}

}
