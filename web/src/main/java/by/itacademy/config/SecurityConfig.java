package by.itacademy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"by.itacademy.service"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/createApplication")
                        .authenticated()
                    .antMatchers("/admin")
                        .hasAuthority("ADMIN")
                    .anyRequest()
                        .permitAll()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/loginUrl")
                        .defaultSuccessUrl("/home")
                        .usernameParameter("email")
                        .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")

                .and()
                .csrf().disable();

                http.userDetailsService(userDetailsService);
    }
}
