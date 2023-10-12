package com.bozhilov.shiftscheduler.web.interceptors;

import com.bozhilov.shiftscheduler.web.annotations.PageTitle;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

@Component
public class PageTitleInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView == null){
            modelAndView = new ModelAndView();
        }else{
            if(handler instanceof HandlerMethod){
                PageTitle anotation = ((HandlerMethod) handler).getMethodAnnotation(PageTitle.class);
                if(anotation != null){
                    modelAndView.addObject("title", anotation.value());
                }
            }
        }
    }
}
