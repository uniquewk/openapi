package com.fishsaying.oauth.client;

import com.squareup.okhttp.OkHttpClient;

/**
 * 
 * @author wangkai
 * @2017年3月15日 下午5:18:53
 * <p>获取httpclient</p>
 */
public class OauthHttpClient {
	
	/**
	 * 获取httpclient
	 * @return
	 */
	public static OkHttpClient getClient(){
		OkHttpClient client = new OkHttpClient();
		return client;
	}

}
