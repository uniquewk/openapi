package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:07:58
 * <p>
 *  根据ID查询景区详情
 * </p>
 */
public class ScenicInfoSample {
	
	
	
	public static void main(String[] args) {
		
		String scenicId = "54cdcb029a0b8ad439d02680";
		
		String accessToken = "08c7b7ec-1ddc-4392-910a-1c4e087a2134";
		try {
			String result = FsSourcesApi.getScenicInfoById(scenicId, accessToken);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
