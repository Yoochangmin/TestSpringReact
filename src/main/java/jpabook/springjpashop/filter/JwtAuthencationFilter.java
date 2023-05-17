package jpabook.springjpashop.filter;

import jpabook.springjpashop.security.TokenProvider;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthencationFilter extends OncePerRequestFilter {

    // Request가 들어왔을 때 Request Header의 Authorization 필드의 Bearer Token을 가져옴
    // 가져온 토큰을 검증하고 검증 결과를 SecurityContext에 추가
    @Autowired private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            try {
                String token = parseBearerToken(request);
                //equalsIgnoreCase : 대 소문자 관계 없이 비교
                if (token != null && !token.equalsIgnoreCase("null")) {
                    //토큰을 검증해서 payload의 userId를 가져옴
                    String userId = tokenProvider.validate(token);

                    // SecurityContext에 추가할  객체
                    AbstractAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userId, null , AuthorityUtils.NO_AUTHORITIES);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    System.out.println("스프링 세큐리티" + authentication);

                    // SecurityContext에 AbstractAuthenticationToken 객체를 추가해서
                    // 해당 Thread가 지속적으로 인증 정보를 가질 수 있도록 해줌
                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                    securityContext.setAuthentication(authentication);
                    SecurityContextHolder.setContext(securityContext);
                }
            }catch(Exception exception){
                exception.printStackTrace();
        }
            filterChain.doFilter(request, response);

    }
    // Request가 들어왔을 때 Request Header의 Authorization 필드의 Bearer Token 가져오는 메서드
    private String parseBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if ( StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
            return bearerToken.substring(7);

        return null;
    }
}
