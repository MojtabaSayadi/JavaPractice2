package security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

public class JwtUtil {
    @Value("${uni.app.jwtSecret}")
    public String jwtSecret;
    @Value("${uni.app.jwtExpirationMs}")
    public String jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){


        return "aaaaa";
    }
    public String getUserFromJwtToken(String token){
        return "ali";
    }
    public boolean validatinJwtToken(String token){

        return true;
    }
}
