package com.eric.common.util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public final class HttpUtil {

	public static String getRequestBody(HttpServletRequest request) throws IOException {
		StringBuilder requestBody = new StringBuilder();
		BufferedReader reader = new BufferedReader(request.getReader());
		String data = reader.readLine();
		while (data != null) {
			requestBody.append(data);
			data = reader.readLine();
		}
		return requestBody.toString();
	}

}
