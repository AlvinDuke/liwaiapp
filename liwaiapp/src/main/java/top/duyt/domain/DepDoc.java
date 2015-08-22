package top.duyt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_dep_doc")
public class DepDoc {

	private int id;
	private Document doc;
	private Department dep;

	public DepDoc() {
		super();
	}

	public DepDoc(int id, Document doc, Department dep) {
		super();
		this.id = id;
		this.doc = doc;
		this.dep = dep;
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
	@JoinColumn(name = "dco_id")
	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	@ManyToOne
	@JoinColumn(name = "dep_id")
	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

}