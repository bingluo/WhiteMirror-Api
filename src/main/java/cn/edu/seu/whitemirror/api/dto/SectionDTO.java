/**
 * 
 */
package cn.edu.seu.whitemirror.api.dto;

import cn.edu.seu.whitemirror.api.enums.SectionTypeEnum;
import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.io.Serializable;
import java.util.List;

/**
 * @author snow
 *
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SectionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
    private SectionTypeEnum type;
	private List<ArticleBriefDTO> articleList;
    private Integer categoryId;
    private Integer priority;
	private String extra;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
     * @return the type
     */
    public SectionTypeEnum getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(SectionTypeEnum type) {
        this.type = type;
    }
	/**
	 * @return the articleList
	 */
	public List<ArticleBriefDTO> getArticleList() {
		return articleList;
	}
	/**
	 * @param articleList the articleList to set
	 */
	public void setArticleList(List<ArticleBriefDTO> articleList) {
		this.articleList = articleList;
	}
    /**
     * @return categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }
    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * @return priority
     */
    public Integer getPriority() {
        return priority;
    }
    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    /**
     * @return the extra
     */
    public String getExtra() {
        return extra;
    }
    /**
     * @param extra the extra to set
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }
}
