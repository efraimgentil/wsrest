package br.com.efraimgentil.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ SpringConfig.class, DatabaseConfig.class, SpringDataConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return  new Class<?>[]{ SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/*" };
	}

	
}
