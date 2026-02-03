package com.example.backend_service.controllers.jwt;

import com.example.backend_service.securities.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
//        this.jwtService = jwtService;
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
//        try {
//            // 1. Lấy dữ liệu từ Body JSON gửi lên
//            String username = loginRequest.get("username");
//            String password = loginRequest.get("password");
//
//            // 2. Xác thực người dùng thông qua AuthenticationManager
//            // Nếu sai username/password, dòng này sẽ ném ra ngoại lệ (văng vào khối catch)
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//
//            // 3. Nếu xác thực thành công, lưu vào context
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            // 4. Gọi JwtService để tạo chuỗi Token (Chuỗi này BẮT BUỘC phải có 2 dấu chấm)
//            String token = jwtService.generateToken(authentication.getName());
//
//            // 5. In ra Console của IDE (IntelliJ/Eclipse) để bạn kiểm tra nhanh
//            System.out.println("\n================ JWT TOKEN GENERATED ================");
//            System.out.println(token); // Hãy kiểm tra xem chuỗi này có 2 dấu chấm không
//            System.out.println("=====================================================\n");
//
//            // 6. Trả về Response cho Postman dưới dạng JSON
//            Map<String, Object> response = new HashMap<>();
//            response.put("status", "success");
//            response.put("accessToken", token); // Đây là chuỗi bạn cần copy
//            response.put("tokenType", "Bearer");
//            response.put("username", authentication.getName());
//
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            // Log lỗi ra console để biết tại sao thất bại (sai pass, thiếu bean,...)
//            e.printStackTrace();
//            return ResponseEntity.status(401).body("Lỗi: Tài khoản hoặc mật khẩu không chính xác!");
//        }
//    }
}