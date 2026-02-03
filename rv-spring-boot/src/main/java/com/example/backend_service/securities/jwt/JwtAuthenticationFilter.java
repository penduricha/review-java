package com.example.backend_service.securities.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }

//    private final JwtService jwtService;
//
//    public JwtAuthenticationFilter(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String servletPath = request.getServletPath();
//        String authHeader = request.getHeader("Authorization");
//
//        // 1. BỎ QUA KIỂM TRA CHO API LOGIN
//        // Nếu là API login, cho phép đi thẳng tới Controller mà không cần Header Authorization
//        if (servletPath.contains("/auth/login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // 2. DEBUG: In ra để kiểm tra (Xóa khi chạy thực tế)
//        System.out.println("Path: " + servletPath);
//        System.out.println("Auth Header nhận được: " + authHeader);
//
//        // 3. XỬ LÝ TOKEN CHO CÁC API BẢO MẬT (như /api/student/...)
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7).trim();
//
//            try {
//                // Kiểm tra cấu trúc JWT (phải có 2 dấu chấm) trước khi validate
//                if (token.chars().filter(ch -> ch == '.').count() != 2) {
//                    System.out.println("LỖI: Token không đúng định dạng JWT (thiếu dấu chấm)!");
//                } else if (jwtService.validateToken(token)) {
//                    String username = jwtService.extractUsername(token);
//
//                    UsernamePasswordAuthenticationToken authentication =
//                            new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    System.out.println("Xác thực thành công cho user: " + username);
//                }
//            } catch (Exception e) {
//                System.out.println("Lỗi khi xử lý Token: " + e.getMessage());
//            }
//        } else {
//            // Nếu API yêu cầu bảo mật mà không có Header, in ra cảnh báo
//            System.out.println("Cảnh báo: Không có Bearer Token trong Header.");
//        }
//
//        filterChain.doFilter(request, response);
//    }
}