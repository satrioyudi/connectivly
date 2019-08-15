package com.weekendproject.connectivly.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.springframework.stereotype.Service;


@Service
public class JwtDecoder {
	
	public static Map<String, String> decodeJwt(HttpServletRequest request) throws IOException, JSONException {
		
		String jwtToken = request.getHeader("authorization");
        
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedBody = split_string[1];

        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println("bodi nya : "+body);
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", body.split(",")[0].split(":")[1].replace("\"", ""));
        map.put("supplierId", body.split(",")[7].split(":")[1].replace("\"", ""));
//        String split = null;
//        split = body.split(",")[0].split(":")[1].replace("\"", "");
        
        System.out.println("userId : "+map.get("userId"));
        System.out.println("supplierId : "+map.get("supplierId"));
        
        return map;
	}
}
