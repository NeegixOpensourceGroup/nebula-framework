package com.neegix.infrastructure.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.neegix.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/29/10:50
 * @Description:
 */
@Slf4j
public class JWTUtils {
    public static String secret = "768594";

    public static String encode(Long userId){
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userid", userId)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            log.error("error message info: ", exception);
        }

        return token;
    }

    public static Long decode(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        Long accountId = null;
        try {
            accountId = verifier.verify(token).getClaim("userid").asLong();

        }catch (Exception e){
            throw new BusinessRuntimeException("凭证已过期，请重新登录");
        }
        return accountId;
    }
}
