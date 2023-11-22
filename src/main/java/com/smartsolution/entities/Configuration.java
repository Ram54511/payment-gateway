package com.smartsolution.entities;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartsolution.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Configuration")
@Table(name = "sst_configurations")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Configuration extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long configurationId;

	@Column(name = "configuration_key", unique = true)
	@NotEmpty(message = "key is required")
	private String configurationKey;

	@Column(name = "configuration_value")
	@NotEmpty(message = "Value is required")
	private String configurationValue;

	@Column(name = "system_defined")
	private Integer systemDefined;
}
