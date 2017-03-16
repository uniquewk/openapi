package com.fishsaying.oauth.samples;

import com.fishsaying.oauth.client.FsAuthorization;

/**
 * 
 * @author wangkai
 * @2017年3月16日 上午11:21:22
 * <p>
 * 根据地理位置查询某范围的故事 demo
 * </p>
 */
public class StorySearchKeywordSample {
	
	/**
	 * demo
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String resJson = FsAuthorization.getStoriesByKeyword("诸葛", 1, 20, "0d3f6768-f8a6-4f36-877d-db10de386829");
			System.out.println(resJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
