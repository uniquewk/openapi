package com.fishsaying.oauth.client;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * 
 * @author wangkai
 * @2017年3月15日 下午4:48:20
 *             <p>
 *             鱼说授权服务
 *             </p>
 */
public class FsAuthorization {

	private static final String ACCESS_TOKEN_URL = "https://api.fishsaying.com/oauth/token";

	/**
	 * client_credentials 客户端模式获取accessToken
	 * 
	 * @param clientId
	 *            客户端id
	 * @param clientSecret
	 *            客户端(client)的访问密匙
	 * @return jsonString
	 * @throws Exception
	 */
	public static String getAccessToken4ClientCredentials(String clientId,
			String clientSecret) throws Exception {
		// https://api.fishsaying.com/oauth/token?client_id=fs349330887550177280&client_secret=JTbH3VYinLfvwMp8Aj88Z861bUSWYH1Y&grant_type=client_credentials&scope=read
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(ACCESS_TOKEN_URL);
		content.append("?");
		content.append("client_id=");
		content.append(clientId);
		content.append("&");
		content.append("client_secret=");
		content.append(clientSecret);
		content.append("&grant_type=client_credentials&scope=read");
		Request request = new Request.Builder().url(content.toString()).post(null)
				.addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

}
