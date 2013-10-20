package cn.edu.seu.whitemirror.api.client;

import cn.edu.seu.whitemirror.api.dto.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-19
 * Time: 下午10:42
 * To change this template use File | Settings | File Templates.
 */
public class CategoryClient {

    private Logger logger = LoggerFactory.getLogger(CategoryClient.class);

    private RestTemplate restTemplate;

    private String restUrl;
    private String apiKey;

    private static final String CATEGORY_URL = "categories";
    private static final String CATEGORY_BY_ID_URL = "categories/%s";

    public List<CategoryDTO> getCategories() {
        String requestUrl = restUrl + CATEGORY_URL;
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<List<CategoryDTO>> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<CategoryDTO>>() {});
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("CategoryClient.getCategories, ex: ", ex);
            return null;
        }
    }

    public CategoryDTO findCategoryByCategoryId(Long categoryId) {
        String requestUrl = restUrl + String.format(CATEGORY_BY_ID_URL, categoryId);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<CategoryDTO> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, CategoryDTO.class);
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("CategoryClient.findCategoryByCategoryId, ex: ", ex);
            return null;
        }
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }
}
