package top.duyt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_msg")
public class UserMsg {

	private int id;
	private User user;
	private Message msg;
	private int isread;

	public UserMsg() {
		super();
	}

	public UserMsg(int id, User user, Message msg, int isread) {
		super();
		this.id = id;
		this.user = user;
		this.msg = msg;
		this.isread = isread;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "uid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "mid")
	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	/**
	 * ÊÇ·ñ¿É¶Á
	 * @return
	 */
	@Column(name = "is_read")
	public int getIsread() {
		return isread;
	}

	public void setIsread(int isread) {
		this.isread = isread;
	}

}
