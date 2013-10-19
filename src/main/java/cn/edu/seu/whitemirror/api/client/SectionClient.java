package cn.edu.seu.whitemirror.api.client;

import cn.edu.seu.whitemirror.api.dto.SectionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    private final static String SECTION_URL_BY_CATEGORY = "sections?categoryId=%s&needArticleList=%s";

    public List<SectionDTO> getSectionsByCategoryId(Long categoryId, Boolean needArticleList) {
        String requestUrl = restUrl + String.format(SECTION_URL_BY_CATEGORY, categoryId, needArticleList);
        HttpEntity<?> requestEntity = ClientHelper.getRequestEntity(apiKey);
        try {
            ResponseEntity<SectionDTO[]> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, SectionDTO[].class);
            SectionDTO[] sectionDTOs = responseEntity.getBody();
            if (sectionDTOs == null) {
                return null;
            }
            List<SectionDTO> resultList = Arrays.asList(sectionDTOs);
            return resultList;
        } catch (Exception ex) {
            logger.error("Exception in SectionClient.getSectionsByCategoryId, ex: ", ex);
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
