package com.iplease.infra.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .formLogin()
            .and()

            .authorizeRequests()
            .antMatchers("/actuator/**").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()

            .cors().disable()
            .csrf().disable()
    }
}