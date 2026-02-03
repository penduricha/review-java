package com.example.backend_service.securities;

import com.example.backend_service.securities.jwt.JwtAuthenticationFilter;
import com.example.backend_service.securities.jwt.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class WebConfig {

//    @Bean
//    public CharacterEncodingFilter characterEncodingFilter() {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        return filter;
//    }

    // No set up JWT
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Quan trọng: POST sẽ lỗi nếu không tắt CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Cho phép tất cả các API không cần token
                );
        return http.build();
    }
//    private final JwtService jwtService;
//
//    public WebConfig(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/login").authenticated() // Login cần user/pass từ console
//                        .anyRequest().authenticated() // Các cái khác cần JWT
//                )
//                .httpBasic(org.springframework.security.config.Customizer.withDefaults()) // Kích hoạt Basic Auth cho Login
//                .addFilterBefore(new JwtAuthenticationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("1234")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable) // Rất quan trọng cho POST/PUT/DELETE
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**").permitAll() // Mở toàn bộ các API trong auth
//                        .anyRequest().authenticated() // Các API khác chỉ cần đăng nhập thành công là được
//                )
//                // Nếu dùng JWT, ta nên tắt quản lý Session để tránh lỗi 403 do Session cũ
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(new JwtAuthenticationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable) // Tắt CSRF để làm việc với Postman
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**").permitAll() // Cho phép login
//                        .requestMatchers("/api/student/**").authenticated() // CHỈ CẦN đăng nhập là được vào
//                        .anyRequest().authenticated() // Các API còn lại bắt buộc login
//                )
//                // THÊM DÒNG NÀY: Để Spring không dùng Session mặc định
//                .sessionManagement(
//
//                        session -> session.sessionCreationPolicy(
//                                SessionCreationPolicy.STATELESS))
//                // Đưa filter của bạn vào trước filter mặc định
//                .addFilterBefore(new JwtAuthenticationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
}