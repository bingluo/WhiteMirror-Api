package cn.edu.seu.whitemirror.api.client;

import cn.edu.seu.whitemirror.api.dto.SectionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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

    private static Logger logger = LoggerFactory.getLogger(SectionClient.class);

    private RestTemplate restTemplate;

    private String restUrl;
    private String apiKey;

    private final static String SECTION_BY_ID_URL = "sections/%s";
    private final static String SECTION_CATEGORY_URL_BY = "sections?categoryId=%s&needArticleList=%s";
    private final static String BATCH_SECTION_BY_CATEGORY_URL = "sections/batch_by_category?needArticleList=%s";
    private final static String ADD_SECTION_URL = "sections";
    private final static String UPDATE_SECTION_URL = "sections/%s";
    private final static String DELETE_SECTION_URL = "sections/%s";

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
        queryString.append('&');
        for (Long categoryId : categoryIdList) {
            queryString.append("categoryId=").append(categoryId).append('&');
        }
        String requestUrl = restUrl + String.format(BATCH_SECTION_BY_CATEGORY_URL, needArticleList) + queryString;
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<Map<Long, List<SectionDTO>>> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Map<Long, List<SectionDTO>>>() {});
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.batchSectionsByCategoryIdList, ex: ", ex);
            return null;
        }
    }

    public SectionDTO addSection(SectionDTO sectionDTO) {
        String requestUrl = restUrl + ADD_SECTION_URL;
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(sectionDTO, apiKey);
        try {
            ResponseEntity<SectionDTO> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.POST, requestEntity, SectionDTO.class);
            URI redirectURI = responseEntity.getHeaders().getLocation();
            return restTemplate.exchange(redirectURI, HttpMethod.GET, requestEntity, SectionDTO.class).getBody();
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.addSection, ex: ", ex);
            return null;
        }
    }

    public SectionDTO updateSection(Long sectionId, SectionDTO sectionDTO) {
        String requestUrl = restUrl + String.format(UPDATE_SECTION_URL, sectionId);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(sectionDTO, apiKey);
        try {
            ResponseEntity<SectionDTO> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.PUT, requestEntity, SectionDTO.class);
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.updateSection, ex: ", ex);
            return null;
        }
    }

    public String deleteSection(Long sectionId) {
        String requestUrl = restUrl + String.format(DELETE_SECTION_URL, sectionId);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntityAcceptTextPlain(apiKey);
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.DELETE, requestEntity, String.class);
            return responseEntity.getBody();
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.deleteSection, ex: ", ex);
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
