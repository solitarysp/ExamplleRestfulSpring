package com.higgusp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//class config ConfigDispatcherServlet, đây là class khởi tạo ứng dụng.
//mặc định khi chạy ứng sẽ khi start sẽ chạy class này
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // get root config của ứng dụng
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ConfigurationApp.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    //servlet mapping
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //Override từ cha bộ bộ lọc, ở đây là 1 list bộ lọc, mỗi lần request sẽ qua list bộ lọc này.
    @Override
    protected Filter[] getServletFilters() {
        Filter[] singleton = {new CORSFilter()};
        return singleton;
    }
}
