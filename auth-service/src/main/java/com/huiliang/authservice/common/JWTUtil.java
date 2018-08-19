package com.huiliang.authservice.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static final long ONEDAY=24*12*60*1000;
    private static final long ONEMINIUTE=60*1000;
    public static boolean verify(String token,String username,String secret){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
    /**
     * 获取token中的username
     * @param token
     * @return
     */
    public static String getUserName(String token){
        try {
            DecodedJWT jwt= JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }

    }
    /**
     *
     */
    public static String getRole(String token){
        try {
            DecodedJWT jwt= JWT.decode(token);
            return jwt.getClaim("role").asString();
        } catch (JWTDecodeException e) {
            return null;
        }

    }

    /**
     * 生成签名 1天后过期
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username,String role,String secret){
        try {
            Date date=new Date(System.currentTimeMillis()+ONEDAY);
            Algorithm algorithm=Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("username",username)
                    .withClaim("role",role)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }

    }
}