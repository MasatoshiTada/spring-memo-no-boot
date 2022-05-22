package com.example.springmemo.web.config;

import com.example.springmemo.persistence.config.DataSourceConfig;
import com.example.springmemo.persistence.config.JdbcTemplateConfig;
import com.example.springmemo.rest.config.RestConfig;
import com.example.springmemo.service.config.TransactionConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DataSourceConfig.class, JdbcTemplateConfig.class,
                TransactionConfig.class, MvcConfig.class, RestConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}
