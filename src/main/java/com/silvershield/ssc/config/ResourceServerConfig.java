package com.silvershield.ssc.config;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Value("${resource.id:spring-boot-application}")
    private String resourceId;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        // @formatter:off
        resources.resourceId(resourceId);
        // @formatter:on
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
//        http.requestMatcher(new OAuthRequestedMatcher())
      http.authorizeRequests()
          .antMatchers(HttpMethod.OPTIONS).permitAll()
          .anyRequest().authenticated()
          .and()
          .requiresChannel()
          .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
          .requiresSecure();
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on

      _logger.info("Customized http security configuration");
    }

    private static class OAuthRequestedMatcher implements RequestMatcher {
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            // Determine if the client request contained an OAuth Authorization
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token") != null;
            return haveOauth2Token || haveAccessToken;
        }
    }

}
