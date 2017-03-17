package com.fishsaying.oauth.samples;

import java.io.IOException;

import com.fishsaying.oauth.client.FsSourcesApi;

/**
 * 
 * @author wangkai
 * @2017年3月17日 上午11:22:45
 * @desc:
 */
public class FigureInfoSample {
	
	public static void main(String[] args) {
		String access_token = "d5a37549-ec2e-4c9f-a090-2ba11f371cb9";
		String id = "54cf5bc89a0b8ab174545817";
		try {
			String result = FsSourcesApi.getFigureInfoById(id, access_token);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
