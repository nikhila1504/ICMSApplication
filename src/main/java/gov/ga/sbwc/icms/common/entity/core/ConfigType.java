package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "ICMS", name = "CONFIG_TYPE")
public class ConfigType extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String STRING = "string";
	public static final String TEXT = "text";
	public static final String BOOLEAN = "boolean";
	public static final String INTEGER = "integer";
	public static final String LONG = "long";
	public static final String FILE = "file";
	public static final String SELECT = "select";
	public static final String HIDDEN = "hidden";
	public static final String LIST = "list";

	@Id
	@Column(name = "CONFIG_TYPE_ID")
	private Long id;

	@Column(name = "KEY")
	private String key;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "IS_SYSTEM_PROPERTY")
	private int systemProperty = 1;

	@Transient
	private boolean select;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public int getSystemProperty() {
		return systemProperty;
	}

	public void setSystemProperty(int systemProperty) {
		this.systemProperty = systemProperty;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("key=");
		sb.append(key);
		sb.append(", type=");
		sb.append(type);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");
		return sb.toString();
	}
}
