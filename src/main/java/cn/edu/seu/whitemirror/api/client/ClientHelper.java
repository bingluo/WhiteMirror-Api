package cn.edu.seu.whitemirror.api.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

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

    public static <T> HttpEntity<T> getRequestEntity(T entity, String apiKey) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.add("API-Key", apiKey);
        HttpEntity<T> requestEntity = new HttpEntity<T>(entity, requestHeaders);
        return requestEntity;
    }

    public static HttpEntity<?> getRequestEntityAcceptTextPlain(String apiKey) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.setAccept(Arrays.asList(new MediaType("text", "plain")));
        requestHeaders.add("API-Key", apiKey);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        return requestEntity;
    }
}
