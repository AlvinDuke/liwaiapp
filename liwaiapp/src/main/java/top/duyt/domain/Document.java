package top.duyt.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_doc")
public class Document {

	private int id;
	private String title;
	private String content;
	private Date credate;
	private User user;

	public Document() {
		super();
	}

	public Document(int id, String title, String content, Date credate,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.credate = credate;
		this.user = user;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", columnDefinition = "text")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "cre_date")
	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	@ManyToOne
	@JoinColumn(name = "u_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
