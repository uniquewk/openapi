package com.fishsaying.oauth.samples;

import com.fishsaying.oauth.client.FsAuthorization;

/**
 * 
 * @author wangkai
 * @2017年3月16日 上午11:21:22
 * <p>
 * 根据ID查询故事详情 demo
 * </p>
 */
public class StoryInfoSample {
	
	/**
	 * demo
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String resJson = FsAuthorization.getStoryInfoById("569e37d37f9440933c8b6446", "927e0736-636b-48cd-8850-f6048dd14831");
			System.out.println(resJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
