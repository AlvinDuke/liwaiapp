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
@Table(name = "t_attachment")
public class Attachment {

	private int id;
	private String newname;
	private String oldname;
	private long size;
	private Message message;
	private Document document;
	private String type;
	private Date credate;

	public Attachment() {
		super();
	}

	public Attachment(int id, String newname, String oldname, long size,
			Message message, Document document, String type, Date credate) {
		super();
		this.id = id;
		this.newname = newname;
		this.oldname = oldname;
		this.size = size;
		this.message = message;
		this.document = document;
		this.type = type;
		this.credate = credate;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "new_name")
	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	@Column(name = "old_name")
	public String getOldname() {
		return oldname;
	}

	public void setOldname(String oldname) {
		this.oldname = oldname;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@ManyToOne
	@JoinColumn(name = "msg_id")
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@ManyToOne
	@JoinColumn(name = "doc_id")
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "cre_date")
	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

}
