package photo_time_tracking.photo_time.configurations;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Value("${jwt.expire}")
    private int JWT_EXPIRE;

    /* Tạo token từ thông tin của user */
    public String generateToken(CustomUserDetail customUserDetail) {
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + JWT_EXPIRE);

        return Jwts.builder()
                .setSubject(customUserDetail.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET.getBytes())  // Sử dụng chuỗi bí mật
                .compact();
    }

    // Lấy tên người dùng từ JWT
    public String getUserNameFromJWT(String token) {
        if (token != null && (token.startsWith("Bearer ") || token.startsWith("bearer "))) {
            token = token.substring(7); // Loại bỏ phần 'Bearer '
        }

        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET.getBytes())  // Sử dụng chuỗi bí mật
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // Xác thực JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(JWT_SECRET.getBytes())  // Sử dụng chuỗi bí mật
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("JWT Token validation failed");
        }
        return false;
    }
}
