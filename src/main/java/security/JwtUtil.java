package security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
@Component
public class JwtUtil {
    @Value("${uni.app.jwtSecret}")
    public String jwtSecret;
    @Value("${uni.app.jwtExpirationMs}")
    public String jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){
        UserDetails userDetails= (User) authentication.getPrincipal(); // override with our userdetail
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() )+ jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.ES256)
                .compact();

        ///return "aaaaa";
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

    }
    public String getUserFromJwtToken(String token){
        return  Jwts.parserBuilder().setSigningKey(key())
                .build().parseClaimsJwt(token).getBody().getSubject();

    }
    public boolean validatinJwtToken(String token){

        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return  true;
        } catch (Exception e){//ExpiredJwtException e)
            return false;
        }
    }
}
