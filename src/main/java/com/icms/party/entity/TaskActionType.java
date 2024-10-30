package com.icms.party.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Immutable;

/**
 * The persistent class for the TASK_ACTION_TYPE database table.
 * 
 */
@Entity
@Table(schema = "ICMS", name = "TASK_ACTION_TYPE")
public class TaskActionType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TASK_ACTION_TYPE_ID")
	private long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "Description")
	private String description;

	public TaskActionType() {
	}

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

}