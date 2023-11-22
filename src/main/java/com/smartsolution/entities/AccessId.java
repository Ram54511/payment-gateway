package com.smartsolution.entities;

import java.io.Serializable;

public class AccessId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8157252385134924886L;
	private String task;
	private String moduleName;
	private Long userGroupId;

	public AccessId() {
	}

	public AccessId(String task, String moduleName, Long userGroupId) {
		this.task = task;
		this.moduleName = moduleName;
		this.userGroupId = userGroupId;
	}

	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		result = prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result + ((userGroupId == null) ? 0 : userGroupId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessId other = (AccessId) obj;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		if (moduleName == null) {
			if (other.moduleName != null)
				return false;
		} else if (!moduleName.equals(other.moduleName))
			return false;
		if (userGroupId == null) {
			if (other.userGroupId != null)
				return false;
		} else if (!userGroupId.equals(other.userGroupId))
			return false;
		return true;
	}
}
