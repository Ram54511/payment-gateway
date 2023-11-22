package com.smartsolution.entities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartsolution.domain.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Menu")
@Table(name = "sst_menus")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Menu extends BaseEntity {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long menuId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Menu parent;

	@Schema(required = true, description = "Title for the menu")
	@Column(name = "menu_title")
	@NotEmpty(message = "Menu Title name is required")
	private String menuTitle;

	@Schema(required = true, description = "Link for the menu")
	@Column(name = "menu_link")
	@NotEmpty(message = "Menu Link is required")
	private String menuLink;

	@Column(name = "status")
	@NotNull(message = "Status is required")
	private Integer status;

	@Schema(required = false, description = "Menu class")
	@Column(name = "menu_class")
	private String menuClass;

	@Schema(required = false, description = "Ordering number for the menu")
	@Column(name = "ordering")
	private Integer ordering;

	@Schema(required = false, description = "Menu level")
	@Column(name = "menu_level")
	private Integer menuLevel;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menu")
	private List<MenuUsergroup> menuUsergroupList = new ArrayList<>();
}
