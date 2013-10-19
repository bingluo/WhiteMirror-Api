package cn.edu.seu.whitemirror.api.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-19
 * Time: 下午7:20
 * To change this template use File | Settings | File Templates.
 */
public class ClientHelper {
    public static HttpEntity<?> getRequestEntity(String apiKey) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.add("API-Key", apiKey);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        return requestEntity;
    }
}
