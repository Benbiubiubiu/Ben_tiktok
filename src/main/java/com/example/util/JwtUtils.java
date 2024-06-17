package com.example.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * author:Ben
 */
public class JwtUtils {
    public static final long EXPIRE = 1000000*60*60*24;
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    public static String getJwtToken(Long id,String nickname){
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")

                .setSubject("guli-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))

                .claim("id",String.valueOf(id))
                .claim("nickname",nickname)

                .signWith(SignatureAlgorithm.ES256,APP_SECRET)
                .compact();
        return JwtToken;
    }
    public static boolean checkToken(String jwtToken){
        if(StringUtils.isEmpty(jwtToken))return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean checkToken(HttpServletRequest request){
        try {
            String jwtToken = request.getHeader("token");
            if(ObjectUtils.isEmpty(jwtToken))return false;
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public static Long getUserId(HttpServletRequest request){
        String jwtToken = request.getHeader("token");
        if(ObjectUtils.isEmpty(jwtToken))return null;
        Jws<Claims>claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return Long.valueOf(claims.get("id").toString());
    }
}
