package ru.denisenkodenis.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.denisenkodenis.filter.CORSFilter;

import javax.servlet.Filter;

/**
 * @author Denisenko Denis
 *
 * @note: WebConfig is an analogue of web.xml
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfig.class };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new CORSFilter() };
    }
}
