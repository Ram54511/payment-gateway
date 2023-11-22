package com.smartsolution.domain;

import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	@JsonIgnore
	@Column(name = "created_by", insertable = true, updatable = false)
	private Integer createdBy;
	@JsonIgnore
	@Column(name = "created_ts", insertable = true, updatable = false)
	private Timestamp createdTs;
	@JsonIgnore
	@Column(name = "modified_by", insertable = false, updatable = true)
	private Integer modifiedBy;
	@JsonIgnore
	@Column(name = "modified_ts", insertable = false, updatable = true)
	private Timestamp modifiedTs;

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTs() {
		return modifiedTs;
	}

	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdTs, modifiedBy, modifiedTs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTs, other.createdTs)
				&& Objects.equals(modifiedBy, other.modifiedBy) && Objects.equals(modifiedTs, other.modifiedTs);
	}

}
