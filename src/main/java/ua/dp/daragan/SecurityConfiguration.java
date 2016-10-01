/*package ua.dp.daragan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.dp.daragan.service.DBUserDetailsService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DBUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users").access("hasRole('ROLE_USER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

    }
}*/
/*
*
* .formLogin()
                    .usernameParameter("j_username") // default is username
                    .passwordParameter("j_password") // default is password
                    .loginPage("/authentication/login") // default is /login with an HTTP get
                    .failureUrl("/authentication/login?failed") // default is /login?error
                    .loginProcessingUrl("/authentication/login/process"); // default is /login with an HTTP post
*
* */