package com.mcommerce.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

public class MyZuulResponseFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() { return "post"; }

    @Override
    public int filterOrder() { return 1; }

    @Override
    public boolean shouldFilter() { return false; }
    // set to true when testing TP5

    @Override
    public Object run() {
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        response.setStatus(400);
        log.info("*** MyZuulReponseFilter : CODE HTTP {} ****", response.getStatus());
        return null;
    }
}
