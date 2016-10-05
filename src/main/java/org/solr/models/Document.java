/**
 * 
 */
package org.solr.models;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 184429
 *
 */

@XmlRootElement
public class Document {

	private long id;
	private String title;
	private String content;
	private Date createdDate;
	
	public Document() {
		
	}

	public Document(long id, String content, Date createdDate) {
		this.id = id;
		this.content = content;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}