package com.smartsolution.entities;

import java.util.Objects;

import com.smartsolution.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SqlResultSetMapping(name = "AccessTaskResult", classes = {
		@ConstructorResult(targetClass = AccessModuleTask.class, columns = {
				@ColumnResult(name = "moduleId", type = Long.class),
				@ColumnResult(name = "moduleName", type = String.class),
				@ColumnResult(name = "moduleDescription", type = String.class),
				@ColumnResult(name = "moduleOrder", type = Integer.class),
				@ColumnResult(name = "taskId", type = Long.class), @ColumnResult(name = "task", type = String.class),
				@ColumnResult(name = "taskExist", type = Integer.class), }) })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(AccessId.class)
@Table(name = "sst_access")
public class Access extends BaseEntity {

	@Id
	@Column(name = "task")
	private String task;

	@Id
	@Column(name = "module_name")
	private String moduleName;

	@Id
	@Column(name = "usergroup_id")
	private Long userGroupId;

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Access))
			return false;
		Access access = (Access) o;
		return Objects.equals(task, access.task) && Objects.equals(moduleName, access.moduleName)
				&& Objects.equals(userGroupId, access.userGroupId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}