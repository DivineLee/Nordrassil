package pro.zhantss.cryptography.api;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenFactory {

	public String create(String key, String subject, String issuer) throws Exception {
		try {
			return Jwts.builder().setSubject(subject).setIssuer(issuer).compressWith(CompressionCodecs.DEFLATE)
					.signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(key)).compact();
		} catch (Exception e) {
			throw e;
		}
	}

	public Boolean verify(String jwt, String key, String subject, String issuer) throws Exception {
		try {
			Jwts.parser().requireSubject(subject).requireIssuer(issuer)
					.setSigningKey(TextCodec.BASE64.encode("zhantss")).parseClaimsJws(jwt);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

}
