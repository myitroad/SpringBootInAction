package com.vash.boot_demo.config;

import com.vash.boot_demo.dao.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/**
 * 覆盖Spring Boot自动配置的安全配置时，最重要的一个类是SpringBootWebSecurityConfiguration
 * 该类的注解中有
 * @Configuration
 * @EnableConfigurationProperties
 * @ConditionalOnClass({ EnableWebSecurity.class }) Classpath里必须要有@EnableWebSecurity注解
 * @ConditionalOnMissingBean(WebSecurityConfiguration.class)
 * 通过在SecurityConfig上添加@EnableWeb-Security注解，我们实际上间接创建了一个WebSecurityConfiguration Bean
 * @ConditionalOnWebApplication 说 明 这 必 须 是 个 Web 应 用 程 序
 * 其中onclass条件为classpath中要有@EnableWebSecurity注解
 *
 */
@EnableWebSecurity
@Profile("dev")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/reading").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                // TODO: 2020/1/2 登录页面
                .loginPage("/login")
                // TODO: 2020/1/2 登录失败页
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((name -> readerRepository.findByUsername(name)));
    }
}
