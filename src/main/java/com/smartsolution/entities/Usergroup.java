package com.smartsolution.entities;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartsolution.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Usergroups")
@Table(name = "sst_users_groups")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Usergroup extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usergroup_id", columnDefinition = "serial")
	private Long usergroupId;

	@NotEmpty(message = "Group name is required")
	@Column(name = "group_name")
	private String groupName;

	@NotEmpty(message = "Group code is required")
	@Column(name = "group_code")
	private String groupCode;

	@Column(name = "group_type")
	private Integer groupType;

	@NotNull(message = "Group Status is required")
	@Column(name = "group_status")
	private Integer groupStatus;

	@JsonIgnore
	@Column(name = "allow_admin_login")
	private Integer allowAdminLogin;
}
