//package com.redmath.assignment.bankingapplication.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.Date;
//
//public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    private final AuthenticationManager authenticationManager;
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//            //Validate session
//        try{
//            UsernameAndPasswordAuthenticationRequest authenticationRequest=new ObjectMapper()
//                    .readValue(request.getInputStream(),UsernameAndPasswordAuthenticationRequest.class);
//
//            Authentication authentication=new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getUsername(),
//                    authenticationRequest.getPassword()
//            );
//            Authentication authenticate =authenticationManager.authenticate(authentication);
//            return authenticate;
//        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        String key="282589933282589933282589933282589933282589933282589933282589933282589933282589933282589933282589933282589933";
//        String token= Jwts.builder()
//                .setSubject(authResult.getName())
//                .claim("authorities",authResult.getAuthorities())
//                .setIssuedAt(new Date())
//                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
//                .compact();
//        response.addHeader("Authorization","NotBasic"+token);
//    }
//
//}
