package com.fishsaying.oauth.client;

import java.util.concurrent.TimeUnit;

import com.squareup.okhttp.OkHttpClient;

/**
 * <p>
 * 参考<a>https://github.com/keaplogik/Java-Design-Concepts</a>
 * </p>
 * 枚举除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制
 * 防止反序列化的时候创建新的对象。
 * 因此，Effective Java推荐尽可能地使用枚举来实现单例。
 */
/**
 * 
 * @author wangkai
 * @2016年3月28日 上午12:28:50
 * @desc:单例终极写法－枚举方式
 */
public enum HttpClientFactory {

	/**
	 * 单实例
	 */
	INSTANCE;

	/**
	 * httpclient need only initialize once
	 */
	private static OkHttpClient client;

	private HttpClientFactory() {
	}

	static {
		// 创建客户端
		client = OauthHttpClient.getClient();
		client.setConnectTimeout(30, TimeUnit.SECONDS);
	}

	/**
	 * 获取Client
	 * 
	 * @return
	 */
	public OkHttpClient createClient() {
		// 认证信息
		return client;
	}

}
