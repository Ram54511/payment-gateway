package com.smartsolution.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartsolution.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "Module")
@Table(name = "sst_modules")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class Module extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_id", columnDefinition = "serial")
	private Long moduleId;

	@Column(name = "module_path")
	private String modulePath;

	@Column(name = "module_name")
	private String moduleName;

	@Column(name = "module_description")
	private String moduleDescription;

	@Column(name = "module_status")
	private Integer moduleStatus;

	@Column(name = "module_order")
	private Integer moduleOrder;
}
