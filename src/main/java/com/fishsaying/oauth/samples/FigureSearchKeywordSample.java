package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:21:04
 * <p>
 * 关键字搜索历史人物
 * </p>
 */
public class FigureSearchKeywordSample {
	
	public static void main(String[] args) {
		String access_token = "927e0736-636b-48cd-8850-f6048dd14831";
		int limit = 20;
		int page = 1;
		String keyword = "诸葛";
		try {
			String result = FsSourcesApi.getFiguresByKeyword(keyword, page, limit, access_token);
			System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
