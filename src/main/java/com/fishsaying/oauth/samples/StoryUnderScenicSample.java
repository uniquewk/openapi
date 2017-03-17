package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:27:34
 * <p>
 * 景区相关的故事
 * </p>
 */
public class StoryUnderScenicSample {
	
	public static void main(String[] args) {
		
		String access_token = "927e0736-636b-48cd-8850-f6048dd14831";
		int limit = 20;
		int page = 1;
		String scenic_id = "54cdcb029a0b8ad439d02680";
		try {
			String result = FsSourcesApi.getStoriesUnderScenicSpot(scenic_id, page, limit, access_token);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
