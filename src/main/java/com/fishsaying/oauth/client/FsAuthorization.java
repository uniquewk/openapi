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
	
	private static final String GEO_SEARCH_URL = "https://api.fishsaying.com/stories/geo-search";

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
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content
		.append(ACCESS_TOKEN_URL)
		.append("?")
		.append("client_id=")
		.append(clientId)
		.append("&")
		.append("client_secret=")
		.append(clientSecret)
		.append("&grant_type=client_credentials&scope=read");
		Request request = new Request.Builder().url(content.toString()).post(null)
				.addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 根据地理位置查询某范围的故事
	 * @param latitude
	 *        纬度
	 * @param longitude
	 * 		  经度
	 * @param radius
	 * 		  范围
	 * @param page
	 *        页码
	 * @param limit
	 * 		  每页个数
	 * @param access_token
	 * 		  访问资源授权token
	 * @return
	 * @throws IOException 
	 */
	public static String getStoriesByGeoSearch(double latitude,double longitude,int radius,int page ,int limit,String access_token) throws IOException{
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content
		.append(GEO_SEARCH_URL)
		.append("?")
		.append("latitude")
		.append(latitude)
		.append("&longitude=")
		.append(longitude)
		.append("&radius=")
		.append(radius)
		.append("&page=")
		.append(page)
		.append("&limit=")
		.append(limit)
		.append("&access_token=")
		.append(access_token);
		Request request = new Request.Builder()
		  .url(content.toString())
		  .get()
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "2ced3c0f-28cc-c8b4-ae30-2ced28ec065b")
		  .build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

}
