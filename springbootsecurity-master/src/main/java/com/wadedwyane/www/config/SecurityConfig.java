package com.wadedwyane.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/", "/home")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .ignoringAntMatchers("/logout");*/

        //配置角色的权限
        http.authorizeRequests()
                //表示权限给与所有人
                .antMatchers("/resources", "/").permitAll()
                //表示这个路径下的资源,角色admin才能访问
                .antMatchers("/admin/**").hasRole("ADMIN")
                //表示地址/content/**开头的资源,可以给角色为ADMIN或者USER的使用
                .antMatchers("/content/**").access("hasRole('ADMIN') or hasRole('USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .ignoringAntMatchers("/logout");
    }

    @Autowired
    public void configurationGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .passwordEncoder((new BCryptPasswordEncoder()))
                .withUser("user").password(new BCryptPasswordEncoder()
                .encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder()
                .encode("admin")).roles("ADMIN", "USER");
    }

}
