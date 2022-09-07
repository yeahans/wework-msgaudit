package com.php127.wework.message;


import com.google.gson.JsonElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AccessToken {
    public static final String GET_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";// 获取access
    // url
    public static final String APP_ID = "wwc92974a314c84866";
    public static final String SECRET = "2PvRo2o0V-YANbZlzncW_3syC2atfdM15_y0hK2SoKs";

    //  https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET
    // 获取token
    public  String getToken(String appId,String secret) {
        String turl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=+"+appId+"&corpsecret="+secret;
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(turl);
        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
        String result = null;
        try {
            HttpResponse res = client.execute(get);
            String responseContent = null; // 响应内容
            HttpEntity entity = res.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            JsonObject json = jsonparer.parse(responseContent)
                    .getAsJsonObject();
            System.out.println("json数据是\n" + json);

            // 将json字符串转换为json对象
            if (json.get("errcode").getAsInt()!=0) {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
                System.out.println("错误，需要重新获取Access TOKEN");
            } else {// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
                result = json.get("access_token").getAsString();
                System.out.println("================================\n" + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
            return result;
        }


    }

    // 获取外部联系人信息


}
