package com.java.restaurant_review.security;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeHttpRequests()
//                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                .requestMatchers(HttpMethod.PATCH, "/api/reviews/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//        return http.build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}admin123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withUsername("user")
//                .password("{noop}user123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
//}
//
