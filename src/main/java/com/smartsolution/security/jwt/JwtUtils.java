package com.smartsolution.security.jwt;

import java.io.BufferedReader;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JwtUtils {

	@Inject
	JsonWebToken jwt;

	public PrivateKey generatePrivateKey(String privateKey) throws Exception {
		String pKey = privateKey;
		StringBuilder pkcs8Lines = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new StringReader(pKey));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			pkcs8Lines.append(line);
		}

		String pkcsPem = pkcs8Lines.toString();
		pkcsPem = pkcsPem.replace("-----BEGIN PRIVATE KEY-----", "");
		pkcsPem = pkcsPem.replace("-----END PRIVATE KEY-----", "");
		pkcsPem = pkcsPem.replaceAll("\\s+", "");
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pkcsPem.toString()));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(keySpec);

	}

	public PublicKey generatePublicKey(String publicKey) throws Exception {
		String publicKeyPEM = publicKey.replace("-----BEGIN PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "")
				.replace("-----END PUBLIC KEY-----", "");

		byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
		return keyFactory.generatePublic(keySpec);
	}

	public Claims getAllClaimsFromToken(String token, String pkey) {

		PublicKey gPublicKey = null;
		try {
			gPublicKey = this.generatePublicKey(pkey);

		} catch (Exception e) {

		}
		return jwt.getClaim(Claims.raw_token);
		// return
		// Jwt.parser().setSigningKey(gPublicKey).parseClaimsJws(token).getBody();
	}
}
