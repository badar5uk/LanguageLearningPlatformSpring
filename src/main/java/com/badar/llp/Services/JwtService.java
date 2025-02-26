package com.badar.llp.Services;

import com.badar.llp.DTOs.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secretKey = null;


  public String generateToken(UserDTO dto){
      Map<String,Object> map = new HashMap<>();
      return Jwts.builder().addClaims(map).setSubject(dto.getUserName())
              .setIssuer("LLP")
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis() + 60*10*1000))
              .signWith(SignatureAlgorithm.HS256, getSecretKey()).compact();
   }

    public String getSecretKey(){
        return System.getenv("SECRET_HIDDEN_KEY");
    }
}
