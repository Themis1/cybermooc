package sec.project.config;

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
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // tämä lisätty
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        
        // no real security at the moment
        http.authorizeRequests()
                .antMatchers("/h2-console/*").permitAll()
                .antMatchers("/accounts","/accounts/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().permitAll().and()
                .logout().permitAll();                
                //.anyRequest().permitAll();
        //yllä olevan voisi jättää noin? korjaus menisi esim seuraavasti:
//        http.authorizeRequests()
//                .antMatchers("/h2-console/*").permitAll()
//                .anyRequest().authenticated();
//        http.form().permitAll(); //milläs saatais form kaikille?
//        http.formLogin()
//                .permitAll();        
        
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}