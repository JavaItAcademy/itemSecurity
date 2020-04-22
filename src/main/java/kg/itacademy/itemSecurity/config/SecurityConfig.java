package kg.itacademy.itemSecurity.config;

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
                .withUser("admin").password("{noop}12345").roles("ADMIN").and()
                .withUser("user").password("{noop}user12345").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/items/delete/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/items/add").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/items").hasAnyRole("ADMIN", "USER")
                .and().csrf().disable().headers().frameOptions().disable().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
