package cn.edu.seu.whitemirror.api.dto;

import cn.edu.seu.whitemirror.api.enums.ImageTypeEnum;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-20
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    private String url;
    private ImageTypeEnum type;
    private Integer position;
    private String description;
    private String extra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageTypeEnum getType() {
        return type;
    }

    public void setType(ImageTypeEnum type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
