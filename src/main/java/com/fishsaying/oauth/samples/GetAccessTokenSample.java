package com.fishsaying.oauth.samples;

import com.fishsaying.oauth.client.FsAuthorization;

/**
 * 
 * @author wangkai
 * @2017年3月16日 上午11:21:22
 * <p>
 * 获取accessToken demo
 * </p>
 */
public class GetAccessTokenSample {
	
	private static String clientId = "<clientId>";
	private static String clientSecret = "<clientSecret>";
	/**
	 * demo
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String resJson = FsAuthorization.getAccessToken4ClientCredentials(clientId, clientSecret);
			System.out.println(resJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
