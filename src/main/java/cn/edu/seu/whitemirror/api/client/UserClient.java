package cn.edu.seu.whitemirror.api.client;

import cn.edu.seu.whitemirror.api.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-21
 * Time: 下午12:45
 * To change this template use File | Settings | File Templates.
 */
public class UserClient {

    private Logger logger = LoggerFactory.getLogger(UserClient.class);

    private static final String AUTH_URL = "auth?username=%s";

    private RestTemplate restTemplate;

    private String restUrl;
    private String apiKey;

    public UserDTO findUserByUsername(String username) {
        String requestUrl = restUrl + String.format(AUTH_URL, username);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, UserDTO.class);
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Exception in UserClient.findUserByUsername, ex: ", ex);
            return null;
        }
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }
}
