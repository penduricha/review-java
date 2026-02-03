package com.example.backend_service.securities.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

//    // 1. Khóa bí mật phải dài tối thiểu 32 ký tự để đảm bảo thuật toán HS256 hoạt động
//    private static final String SECRET_KEY = "fwugsefulikgseulkdfglkesgflkhsblkjdbgjksdgshfhdfhdngsrgskehlfgshlkd&&*%&*$45456";
//
//    // Hàm lấy Key đồng nhất cho cả lúc Ký và lúc Giải mã
//    private Key getSignInKey() {
//        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//    }
//
//    // 2. Hàm tạo Token (Trả về chuỗi eyJ... có 2 dấu chấm)
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Hạn 24h
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    // 3. Hàm Validate Token (Sửa lỗi "Found: 0")
//    public boolean validateToken(String token) {
//        try {
//            // Nếu token không có 2 dấu chấm, hàm này sẽ ném ra lỗi ngay lập tức
//            Jwts.parserBuilder()
//                    .setSigningKey(getSignInKey())
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            System.out.println("Lỗi validate JWT: " + e.getMessage());
//            return false;
//        }
//    }
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = Jwts.parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//        return claimsResolver.apply(claims);
//    }
}