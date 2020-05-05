package kg.itacademy.secondTask.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("student").password("{noop}stud123").roles("USER").and()
                .withUser("admin").password("{noop}123").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/student/add").hasRole("ADMIN")
                .antMatchers(HttpMethod. DELETE, "/student/delete/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/student").permitAll()
                .antMatchers(HttpMethod.POST, "/course/add").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/find/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable().headers().frameOptions().disable().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
