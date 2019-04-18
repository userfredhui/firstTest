package com.springBootDemo.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * created by lipenghui on 2019/4/11
 **/
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
    resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
    resp.setContentType("application/json;charset=utf-8");
//    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();
    out.write("{\"code\":\"403\",\"message\":\"权限不足，请联系管理员！\"}");
    out.flush();
    out.close();
  }
}