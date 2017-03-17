package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:12:52
 * <p>
 * 根据地理位置查询某范围的景区
 * </p>
 */
public class ScenicSearchGeoSample {
	
	private static double latitude = 30.673916d;
	private static double longitude = 120.673916d;
	private static int radius = 10000;
	private static int page = 1;
	private static int limit = 20;
	private static String access_token = "c84edcf4-0a45-4a26-b862-5a990f6f239e";
	
	
	public static void main(String[] args) {
		try {
			String result = FsSourcesApi.getScenicsGeoSearch(latitude, longitude, radius, page, limit, access_token);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
