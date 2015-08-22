package top.duyt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dep_scope")
public class DepScope {

	private int id;
	private int oriDepId;
	private Department scopeDep;

	public DepScope() {
		super();
	}

	public DepScope(int id, int oriDepId, Department scopeDep) {
		super();
		this.id = id;
		this.oriDepId = oriDepId;
		this.scopeDep = scopeDep;
	}

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "o_id")
	public int getOriDepId() {
		return oriDepId;
	}

	public void setOriDepId(int oriDepId) {
		this.oriDepId = oriDepId;
	}

	@ManyToOne
	@JoinColumn(name = "s_id")
	public Department getScopeDep() {
		return scopeDep;
	}

	public void setScopeDep(Department scopeDep) {
		this.scopeDep = scopeDep;
	}

}
