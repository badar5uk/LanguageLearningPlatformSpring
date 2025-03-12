package com.badar.llp.Services;

import com.badar.llp.DTOs.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey = null;


  public String generateToken(UserDTO dto){
      Map<String,Object> map = new HashMap<>();
      return Jwts.builder().addClaims(map).setSubject(dto.getUserName())
              .setIssuer("LLP")
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis() + 60*100*1000))
              .signWith(SignatureAlgorithm.HS256, getSecretKey()).compact();
   }

    public String getSecretKey(){
        return System.getenv("SECRET_HIDDEN_KEY");
    }

    public String extractUserName(String token){

      return extractClaims(token, Claims::getSubject);
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
      final String userName = extractUserName(token);
      return userName.equals(userDetails.getUsername())  && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
      return extractExpirationDate(token).before(new Date());
    }

    public Date extractExpirationDate(String token){
      return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsTFunction){
      Claims claims = extractClaims(token);
      return claimsTFunction.apply(claims);
    }

    public Claims extractClaims(String token){
        return Jwts.parser()
                .setSigningKey(System.getenv("SECRET_HIDDEN_KEY"))
                .parseClaimsJws(token)
                .getBody();
    }
}
