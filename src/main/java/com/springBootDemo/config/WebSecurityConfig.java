package com.springBootDemo.config;

import com.springBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created by lipenghui on 2019/4/11
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  UserService userService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
      @Override
      public String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
      }

      @Override
      public boolean matches(CharSequence charSequence, String s) {
        return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
      }
    });
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/admin/category/all").authenticated()
            .antMatchers("/admin/**","/reg").hasRole("超级管理员")// /admin/**的URL都需要有超级管理员角色
            .anyRequest().authenticated() //其他的路径都是登录后即可访问
            .and().formLogin().loginPage("/login_page").successHandler(new AuthenticationSuccessHandler() {
      @Override
      public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"code\":\"0\",\"message\":\"登录成功\"}");
        out.flush();
        out.close();
      }
    })
            .failureHandler(new AuthenticationFailureHandler() {
              @Override
              public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write("{\"code\":\"1\",\"message\":\"登录失败\"}");
                out.flush();
                out.close();
              }
            }).loginProcessingUrl("/login")
            .usernameParameter("username").passwordParameter("password").permitAll()
            .and().logout().permitAll().and().csrf().disable().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
  }

  @Bean
  AccessDeniedHandler getAccessDeniedHandler() {
    return new AuthenticationAccessDeniedHandler();
  }
}
