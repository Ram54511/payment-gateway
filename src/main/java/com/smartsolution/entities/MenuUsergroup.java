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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "MenuUsergroup")
@Table(name = "sst_menu_usergroups")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class MenuUsergroup extends BaseEntity {
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial", name = "")
	private Long menuUsergroupId;

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	@JoinColumn(name = "usergroup_id")
	private Long usergroupId;
}
