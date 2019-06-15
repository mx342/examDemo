package com.tianyou.exam.filter;


import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GateWayFilter implements Filter {




    @Override
    public void init(FilterConfig filterConfig) {


    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String app = req.getHeader("GW_APP");

        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {

    }

}
