## 获取access_token

access_token是鱼说开放平台的全局唯一接口调用凭据，开发者调用各接口时都需使用access_token。开发者需要进行妥善保存。  access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。

开放平台的API调用所需的access_token的使用及生成方式说明：

1. 为了保密client_secret，第三方需要一个access_token获取和刷新的中控服务器。而其他业务逻辑服务器所使用的access_token均来自于该中控服务器，不应该各自去刷新，否则会造成access_token覆盖而影响业务；
2. 目前access_token的有效期通过返回的expires_in来传达，目前是7200秒之内的值。中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，中控服务器对外输出的依然是老access_token，此时开放平台后台会保证在刷新短时间内，新老access_token都可用，这保证了第三方业务的平滑过渡；
3. access_token的有效时间可能会在未来有调整，所以中控服务器不仅需要内部定时主动刷新，还需要提供被动刷新access_token的接口，这样便于业务服务器在API调用获知access_token已超时的情况下，可以触发access_token的刷新流程。

开发者可以使用client_id和client_secret调用本接口来获取access_token。client_id和client_secret可在鱼说开放平台官网-开发页中获得（需要已经成为开发者，  且帐号没有异常状态）。内测期间， 请联系鱼说工作人员获取client_id和client_secret。

* 注意调用所有鱼说接口时均需使用https协议。如果第三方不使用中控服务器，而是选择各个业务逻辑点各自去刷新access_token，那么就可能会产生冲突，导致服务不稳定。

## 接口调用请求说明

#### 请求方式: POST
#### 请求地址：https://api.fishsaying.com/oauth/token?grant_type=client_credential&client_id=APPID&client_secret=APPSECRET&scope=read
#### 请求实例：
 ```
 curl -d "client_id=4f6a2c8006e84d2196c7d0740b8e6dbd&client_secret=4I5qyi8svdDGiJt2kLKCx5M0wPeHpB8T&grant_type=client_credentials&scope=read" "http://localhost:8080/spring-oauth-server/oauth/token"
 结果：
 {
  "access_token":"e5ea7620-56888bbb76f62",
  "token_type":"bearer",
  "expires_in":3600,
  "scope":"read"
 }      
 ```
## 参数说明

| 参数        | 是否必须 | 说明               |
| ---------- |---------|-------------------|
| grant_type | 是      | 获取access_token填写client_credential(固定值) |
| client_id      | 是      | 第三方用户唯一凭证 | 
| client_secret     | 是      | 第三方用户唯一凭证密钥 |
| scope      | 是      | read or write|
## 返回说明

正常情况下，鱼说会返回下述JSON数据包给开发者：

```
{"access_token":"ACCESS_TOKEN","expires_in":7200}
```

| 参数          | 说明                |
| ------------ |--------------------|
| access_token | 获取到的凭证          |
| expires_in   | 凭证有效时间，单位：秒 |

错误时鱼说会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:

```
{"errorCode":40013,"errorMessage":"invalid appid"}
```
           
