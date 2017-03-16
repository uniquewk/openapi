
前言
=

SDK下载
===
maven工程
----
添加：
```
<repositories>
	<repository>
		<id>nexus-repos</id>
		<name>Team Nexus Repository</name>
		<url>http://maven.fishsaying.com/nexus/content/groups/public/</url>
	</repository>
</repositories>
```
到项目pom.xml中

gradle工程
----
添加：
```
repositories {
	// 中央仓库
	mavenCentral()
	// 本地私服
    maven {
      url "http://maven.fishsaying.com/nexus/content/groups/public/"
    }
}
```
到项目到build.gradle中 

简介
===

```
fishsaying oauth SDK适用于 JDK 6 及以上版本
本文档主要介绍 此SDK 的安装、使用及注意事项；
并且假设您已经开通了鱼说[授权]服务，并创建了 clientId和clientSecret。
```
-----

安装
=

环境准备
===
 * 适用于JDK 6及以上版本

安装方式
===
maven方式
---
将下面代码加入到maven项目的dependencies块中

```
<dependency>
  <groupId>com.fishsaying.oauth</groupId>
  <artifactId>fs-sdk-oauth</artifactId>
  <version>1.0.0</version>
</dependency>
```    

gradle方式
---
将下面代码加入到gradle项目下build.gradle的dependencies块中

```
compile com.fishsaying.oauth:fs-sdk-oauth:1.0.0
```

示例程序
===

FishSaying Oauth SDK提供示例程序，方便用户参考或直接使用。您可以通过以下方式获取示例程序：

github查看下载，参考[FishSaying Oauth SDK](https://code.aliyun.com/fs-backend/fishsaying-oauth-sdk) 下的src/samples为示例程序，
可以快速使用。

-----
示例包括以下内容：

| 示例代码       |   示例内容     | 
| ------------- |:-------------:|
| GetAccessTokenSample| 获取accessToken|
|                     |               |
|                     |               |
 



