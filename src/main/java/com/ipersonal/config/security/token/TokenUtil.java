package com.ipersonal.config.security.token;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenUtil {
	
	private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String buildJwtToken(String username, String accessType) {
		String token = Jwts.builder()
		.setHeaderParam("typ", "JWT")
		.setSubject(username)
		.setExpiration(new Date(System.currentTimeMillis() + this.expiration))
		.claim("acc", accessType)
		.signWith(this.key).compact();
		
		return token;
	}
	
	public String tokenToJson(String token, String accessType) {
		String tokenJson = String.format("{\"token\": %s, \"exp\": %s, \"accessType\": %s}",addQuotes(token),
				addQuotes(new Date(System.currentTimeMillis() + this.expiration).toString()), addQuotes(accessType));
		return tokenJson;
	}

	private String addQuotes(String value) {
		return new StringBuilder(300).append("\"").append(value).append("\"").toString();
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(this.key).parseClaimsJws(token.replace("Bearer ", "")).getBody();
		} catch (Exception e) {
			throw new JwtException(e.getMessage());
		}
	}
	
	public boolean tokenIsValid(String token) {
		Claims claims = this.getClaims(token);
		if (claims.isEmpty()) return false;
		
		String username = claims.getSubject();
		Date exp = claims.getExpiration();
		Date now = new Date(System.currentTimeMillis());
		return (username != null && exp != null && now.before(exp));
	}

	public String getUsername(String token) {
		return this.getClaims(token).getSubject();
	}
}
