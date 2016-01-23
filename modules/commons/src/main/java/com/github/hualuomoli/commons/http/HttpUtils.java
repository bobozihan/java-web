package com.github.hualuomoli.commons.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

public class HttpUtils {

	private static final String DEFAULT_CHARSET_NAME = "UTF-8";

	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String PUT = "PUT";
	public static final String DELETE = "DELETE";

	public static String doPayload(String urlStr, String payload) throws IOException {
		return doPayload(urlStr, payload, POST);
	}

	public static String doPayload(String urlStr, String payload, String methodName) throws IOException {
		return doPayload(urlStr, payload, methodName, DEFAULT_CHARSET_NAME);
	}

	public static String doPayload(String urlStr, String payload, String methodName, String charsetName)
			throws IOException {
		if (StringUtils.isEmpty(payload)) {
			throw new IOException("please set payload data.");
		}
		// create URL
		URL url = new URL(urlStr);
		// get connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// set in/out
		connection.setDoInput(true);
		connection.setDoOutput(true);
		// set method name
		connection.setRequestMethod(methodName);
		// set content type
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Content-Type", "application/json; charset=" + charsetName);
		// write payload
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), charsetName);
		writer.write(payload);
		writer.close();
		// read data
		String line;
		StringBuilder buffer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while ((line = br.readLine()) != null) {
			buffer.append(line);
		}
		br.close();
		connection.disconnect();
		// return data
		return buffer.toString();
	}

}
