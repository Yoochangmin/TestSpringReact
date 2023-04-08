package jpabook.springjpashop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class TokenProvider {
    //JWT 생성 및 검증 키
    private static final String SECURITY_KEY = "jwtsecket!@";


    // JWT 생성 메소드
    public String create (String userId){
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg","HS512");
        headers.put("typ", "JWT");

        //만료 날짜를 현재 날짜 + 1시간 설정
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        //JWT 생성
        return Jwts.builder()
                .setHeader(headers)
                //암호화에 사용될 알고리즘 , 키
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                // JWT 제목, 생성일, 만료일 생성
                .setSubject(userId).setIssuedAt(new Date()).setExpiration(exprTime)
                // 생성
                .compact();
    }

    //JWT 검증
    public String validate(String token){
        //매겨변수로 받은 token을 키를 사용해서 복호화
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
        //복호화된 토큰의 payload에서 제목을 가져옴
        return claims.getSubject();
    }

}
