package com.weekendproject.connectivly.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.springframework.stereotype.Service;


@Service
public class JwtDecoder {
	
	public static String decodeJwt(HttpServletRequest request) throws IOException, JSONException {
		
		String jwtToken = request.getHeader("authorization");
        
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedBody = split_string[1];

        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(base64EncodedBody));
        String split = null;
        split = body.split(",")[0].split(":")[1].replace("\"", "");
        
        return split;
	}
}
