/**
 * 
 */
package cn.edu.seu.whitemirror.api.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author snow
 *
 */
public class SectionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private List<ArticleBriefDTO> articleList;
    private Long categoryId;
    private Long priority;
	
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
    public Long getCategoryId() {
        return categoryId;
    }
    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * @return priority
     */
    public Long getPriority() {
        return priority;
    }
    /**
     * @param priority the priority to set
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
