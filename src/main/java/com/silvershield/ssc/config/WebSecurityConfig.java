package com.silvershield.ssc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService authUserDetailsService){
        super();
        this.userDetailsService = authUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/", "/login**", "/error**", "/api/v1/users/register", "/api/v1/users/confirm-registration/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .logout().logoutSuccessUrl("/").permitAll()
                .requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure()
                .and()
                .csrf().disable();
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

        _logger.info("Customized http security configuration");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
