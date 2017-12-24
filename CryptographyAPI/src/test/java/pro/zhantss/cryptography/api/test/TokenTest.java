package pro.zhantss.cryptography.api.test;

import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.TextCodec;

public class TokenTest {
	
	@Test
	public void test() {
		try {
			String token =  Jwts.builder()
				    .setSubject("zhantss")
				    .compressWith(CompressionCodecs.DEFLATE)
				    .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode("zhantss"))
				    .compact();
			System.out.println(token);
			
			Jws<Claims> claims = Jwts.parser()
				.requireSubject("zhantss")
				.setSigningKey(TextCodec.BASE64.encode("zhantss"))
				.parseClaimsJws(token);
			System.out.println(claims);
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
