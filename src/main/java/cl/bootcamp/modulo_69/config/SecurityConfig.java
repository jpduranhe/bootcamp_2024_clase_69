package cl.bootcamp.modulo_69.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	//@Bean
    SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		
		return http
                .authorizeHttpRequests( 
                		(authorizeHttpRequests) -> 
	                		authorizeHttpRequests
	                        //.requestMatchers("/login-propio").permitAll()
	                        .anyRequest().permitAll())
                //.formLogin(login -> login.loginPage("/login-propio").permitAll())
               // .logout(logout -> logout.permitAll())
                .build();
	}
    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
      return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
