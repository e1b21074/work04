package oit.is.apple.work04.security;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login.permitAll()).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"))
        .authorizeHttpRequests(
            authz -> authz
                .requestMatchers(AntPathRequestMatcher.antMatcher("/sample4/**"))
                .authenticated()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/**"))
                .permitAll());

    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user1 = User.withUsername("mato")
        .password("{bcrypt}$2y$10$lG.oXoeDmtoOVTVr6s9vfu/ipuNEbCuKWZJvK6qcRsLlynRvmuUXS").roles("doginu").build();
    UserDetails user2 = User.withUsername("naga")
        .password("{bcrypt}$2y$10$12wKFodjDgZM/V3bMbUye.ambUrCpUoANXcfAucNWUiPzwZ2YmULe").roles("catneko").build();

    return new InMemoryUserDetailsManager(user1, user2);
  }

}
