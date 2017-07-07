package com.pastwisko.config;

import com.pastwisko.security.JWTAuthenticationFilter;
import com.pastwisko.security.JWTLoginFilter;
import com.pastwisko.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String PASTAS_URL    = "/api/pastas";
    private final String LOGIN_URL     = "/api/auth/login";
    private final String REGISTER_URL  = "/api/auth/register";

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, PASTAS_URL).permitAll()
                .antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
                .antMatchers(HttpMethod.POST, REGISTER_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                // Filtering the api/auth/login requests
                .addFilterBefore(new JWTLoginFilter(LOGIN_URL, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                // Filter other requests to check the presence of the JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}
