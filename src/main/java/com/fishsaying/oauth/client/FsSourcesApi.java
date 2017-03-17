package com.fishsaying.oauth.client;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:33:57
 * <p>
 * 鱼说开放api获取资源client
 * </p>
 */
public class FsSourcesApi {
	
	private static final String GEO_SEARCH_STORY_URL = "https://api.fishsaying.com/stories/geo-search";

	private static final String KEYWORD_SEARCH_STORY_URL = "https://api.fishsaying.com/stories/search";

	private static final String STORY_INFO_URL = "https://api.fishsaying.com/stories/";
	
	private static final String GEO_SEARCH_SCENIC_URL = "https://api.fishsaying.com/scenics/geo-search";
	
	private static final String KEYWORD_SEARCH_SCENIC_URL = "https://api.fishsaying.com/scenics/search";
	
	private static final String SCENIC_INFO_URL = "https://api.fishsaying.com/scenics/";
	
	private static final String KEYWORD_SEARCH_FIGURE_URL = "https://api.fishsaying.com/figures/search";
	
	private static final String FIGURE_INFO_URL = "https://api.fishsaying.com/figures/";
	
	private static final String SCENIC_CONTAINS_STORY_URL = "https://api.fishsaying.com/scenics/";
	
	private static final String FIGURE_CONTAINS_STORY_URL = "https://api.fishsaying.com/figures/";
	
	private static final String STORY = "stories";
	
	/**
	 * 根据地理位置查询某范围的故事
	 * 
	 * @param latitude
	 *            纬度
	 * @param longitude
	 *            经度
	 * @param radius
	 *            范围
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getStoriesByGeoSearch(double latitude,
			double longitude, int radius, int page, int limit,
			String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(GEO_SEARCH_STORY_URL).append("?").append("latitude=")
				.append(latitude).append("&longitude=").append(longitude)
				.append("&radius=").append(radius).append("&page=")
				.append(page).append("&limit=").append(limit)
				.append("&access_token=").append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

	/**
	 * 关键字查询故事列表
	 * 
	 * @param keyword
	 *            关键字
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getStoriesByKeyword(String keyword, int page,
			int limit, String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(KEYWORD_SEARCH_STORY_URL).append("?").append("keyword=")
				.append(keyword).append("&page=").append(page)
				.append("&limit=").append(limit).append("&access_token=")
				.append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 根据ID查询故事详情
	 * @param id
	 *        故事id
	 * @param access_token
	 * 		访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getStoryInfoById(String id, String access_token)
			throws IOException {
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();

		final StringBuilder content = new StringBuilder();

		content.append(STORY_INFO_URL)
		       .append(id)
		       .append("?access_token=")
			   .append(access_token);

		Request request = new Request.Builder()
				.url(content.toString())
		        .get()
				.addHeader("cache-control", "no-cache")
				.build();

		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 根据地理位置查询某范围的景区
	 * @param latitude
	 *            纬度
	 * @param longitude
	 *            经度
	 * @param radius
	 *            范围
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getScenicsGeoSearch(double latitude,
			double longitude, int radius, int page, int limit,
			String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(GEO_SEARCH_SCENIC_URL).append("?").append("latitude=")
				.append(latitude).append("&longitude=").append(longitude)
				.append("&radius=").append(radius).append("&page=")
				.append(page).append("&limit=").append(limit)
				.append("&access_token=").append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 关键字查询景区列表
	 * 
	 * @param keyword
	 *            关键字
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getScenicsByKeyword(String keyword, int page,
			int limit, String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(KEYWORD_SEARCH_SCENIC_URL).append("?").append("keyword=")
				.append(keyword).append("&page=").append(page)
				.append("&limit=").append(limit).append("&access_token=")
				.append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 根据ID查询景区详情
	 * @param id
	 *        故事id
	 * @param access_token
	 * 		访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getScenicInfoById(String id, String access_token)
			throws IOException {
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();

		final StringBuilder content = new StringBuilder();

		content.append(SCENIC_INFO_URL)
		       .append(id)
		       .append("?access_token=")
			   .append(access_token);

		Request request = new Request.Builder()
				.url(content.toString())
		        .get()
				.addHeader("cache-control", "no-cache")
				.build();

		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	
	/**
	 * 关键字查询人物列表
	 * 
	 * @param keyword
	 *            关键字
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getFiguresByKeyword(String keyword, int page,
			int limit, String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(KEYWORD_SEARCH_FIGURE_URL).append("?").append("keyword=")
				.append(keyword).append("&page=").append(page)
				.append("&limit=").append(limit).append("&access_token=")
				.append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 根据ID查询人物详情
	 * @param id
	 *        故事id
	 * @param access_token
	 * 		访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getFigureInfoById(String id, String access_token)
			throws IOException {
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();

		final StringBuilder content = new StringBuilder();

		content.append(FIGURE_INFO_URL)
		       .append(id)
		       .append("?access_token=")
			   .append(access_token);

		Request request = new Request.Builder()
				.url(content.toString())
		        .get()
				.addHeader("cache-control", "no-cache")
				.build();

		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 景区下故事列表
	 * @param scenic_id
	 * 		  景区id
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getStoriesUnderScenicSpot(String scenic_id, int page,
			int limit, String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(SCENIC_CONTAINS_STORY_URL).append(scenic_id).append("/")
				.append(STORY).append("?page=").append(page)
				.append("&limit=").append(limit).append("&access_token=")
				.append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	/**
	 * 人物下故事列表
	 * @param figure_id
	 * @param page
	 *            页码
	 * @param limit
	 *            每页个数
	 * @param access_token
	 *            访问资源授权token
	 * @return
	 * @throws IOException
	 */
	public static String getStoriesUnderFigure(String figure_id, int page,
			int limit, String access_token) throws IOException {
		// 获取httpclient
		OkHttpClient client = HttpClientFactory.INSTANCE.createClient();
		final StringBuilder content = new StringBuilder();
		content.append(FIGURE_CONTAINS_STORY_URL).append(figure_id).append("/")
				.append(STORY).append("?page=").append(page)
				.append("&limit=").append(limit).append("&access_token=")
				.append(access_token);
		Request request = new Request.Builder().url(content.toString()).get()
				.addHeader("cache-control", "no-cache").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}


}
