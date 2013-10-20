package cn.edu.seu.whitemirror.api.client;

import cn.edu.seu.whitemirror.api.dto.SectionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-17
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */

public class SectionClient {

    private Logger logger = LoggerFactory.getLogger(SectionClient.class);

    private RestTemplate restTemplate;

    private String restUrl;
    private String apiKey;

    private final static String SECTION_BY_ID_URL = "sections/%s";
    private final static String SECTION_CATEGORY_URL_BY = "sections?categoryId=%s&needArticleList=%s";
    private final static String BATCH_SECTION_BY_CATEGORY_URL = "sections/batch_by_category?needArticleList=%s";

    public SectionDTO findSectionBySectionId(Long sectionId) {
        String requestUrl = restUrl + String.format(SECTION_BY_ID_URL, sectionId);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<SectionDTO> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, SectionDTO.class);
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.findSectionBySectionId, ex: ", ex);
            return null;
        }
    }

    public List<SectionDTO> getSectionsByCategoryId(Long categoryId, Boolean needArticleList) {
        String requestUrl = restUrl + String.format(SECTION_CATEGORY_URL_BY, categoryId, needArticleList);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<List<SectionDTO>> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<SectionDTO>>() {
            });
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.getSectionsByCategoryId, ex: ", ex);
            return null;
        }
    }

    public Map<Long, List<SectionDTO>> batchSectionsByCategoryIdList(List<Long> categoryIdList, Boolean needArticleList) {
        StringBuilder queryString = new StringBuilder();
        queryString.append('?');
        for (Long categoryId : categoryIdList) {
            queryString.append("categoryId=").append(categoryId).append('&');
        }
        String requestUrl = restUrl + String.format(BATCH_SECTION_BY_CATEGORY_URL, needArticleList) + queryString;
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<Map<Long, List<SectionDTO>>> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Map<Long, List<SectionDTO>>>() {});
            return responseEntity.getBody();
        } catch (Exception ex) {
            return null;
        }
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
