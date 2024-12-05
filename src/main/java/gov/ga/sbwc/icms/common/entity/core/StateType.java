package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.hibernate.annotations.Immutable;

@Entity
@Table(schema = "ICMS", name = "STATE_TYPE")
//@Immutable
@NamedQueries({ 
	@NamedQuery(name = "StateType.findAll", query = "select st from StateType st where st.recordStatus = 1 order by st.description asc")

})
public class StateType extends BaseEntity implements Type, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "STATE_TYPE_ID_GENERATOR", sequenceName = "STATE_TYPE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_TYPE_ID_GENERATOR")
	@Column(name = "STATE_TYPE_ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StateType))
			return false;
		StateType other = (StateType) obj;
		if (this.code.equals(other.code))
			return true;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
