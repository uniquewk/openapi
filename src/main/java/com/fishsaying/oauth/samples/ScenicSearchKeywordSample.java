package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:18:11
 * <p>
 * 关键字查询景区
 * </p>
 */
public class ScenicSearchKeywordSample {

		public static void main(String[] args) {
			String access_token = "927e0736-636b-48cd-8850-f6048dd14831";
			int limit = 20;
			int page = 1;
			String keyword = "道安银花丝";
			try {
				String result = FsSourcesApi.getScenicsByKeyword(keyword, page, limit, access_token);
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
