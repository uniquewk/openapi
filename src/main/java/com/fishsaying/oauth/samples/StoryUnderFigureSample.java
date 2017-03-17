package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:30:58
 *             <p>
 *             历史人物相关的故事
 *             </p>
 */
public class StoryUnderFigureSample {

	public static void main(String[] args) {
		String access_token = "927e0736-636b-48cd-8850-f6048dd14831";
		int limit = 20;
		int page = 1;
		String figure_id = "54cf5bc89a0b8ab174545817";
		try {
			String result = FsSourcesApi.getStoriesUnderFigure(figure_id, page, limit,access_token);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
