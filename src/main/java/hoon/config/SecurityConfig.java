package hoon.config;

import hoon.config.handler.UserServiceHandler;
import hoon.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String homeUrl = "/main";
    private final UserServiceHandler userServiceHandler;

    @Autowired
    public SecurityConfig(UserServiceHandler userServiceHandler) {
        this.userServiceHandler = userServiceHandler;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(homeUrl).permitAll()
                .antMatchers(homeUrl + "/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers(homeUrl + "/writer/**").hasAuthority("WRITER")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl(homeUrl, true)
                .and().logout().logoutSuccessUrl(homeUrl)
                .and().csrf().disable();

        // NOTE #8 h2 web-console을 security 내에서 사용하려면 x-frame-options 허용해야 함.
        // http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("1234").authorities("ADMIN").and()
                .withUser("writer").password("1234").authorities("WRITER").and()
                .withUser("client").password("1234").authorities("CLIENT");
        auth.userDetailsService(userServiceHandler)
                .passwordEncoder(passwordEncoder());
    }
}
