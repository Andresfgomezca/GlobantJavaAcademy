package com.example.Thesis.Config;

import com.example.Thesis.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@AllArgsConstructor
@EnableWebSecurity //enables de security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //this is the configuration needed for security
    private static final String URLS_ACCEPTED[] = {
            "/registration/**",
            "/registration",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/login",
            "/email/**",
            "/email"

    };

    private static final String URLS_AUTHENTICATED[] = {

    };
    //With this instance with set the user details
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //this is the configuration needed for security
    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1).maxSessionsPreventsLogin(true);
        http.authorizeRequests()
                .antMatchers(URLS_ACCEPTED).permitAll()
                .antMatchers(URLS_AUTHENTICATED).authenticated()
                .antMatchers(URLS_AUTHENTICATED).rememberMe()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("http://localhost:8080/home.html", false)
                .and()
                .logout()
                .and()
                .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)
                .and().csrf().disable();

    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}