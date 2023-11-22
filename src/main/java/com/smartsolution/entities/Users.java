package com.smartsolution.entities;

import java.sql.Timestamp;
import java.util.Date;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartsolution.domain.BaseEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sst_users", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Users extends PanacheEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long userId;

	@Schema(name = "Username for user ,should be valid email", example = "", required = true)
	@Column(name = "username", unique = true)
	@NotEmpty(message = "Username is required")
	@Email(message = "User name should be valid email", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	@NotEmpty(message = "First name is required")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "Last name is required")
	private String lastName;

	@Column(name = "phone_num")
	private String phoneNumber;

	@JoinColumn(name = "usergroupId", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull(message = "User group is required")
	private Usergroup usergroup;

//    @JoinColumn(name = "licenseBodyId", nullable = true)
//    @ManyToOne(fetch = FetchType.LAZY)
//    private LicenseBody licenseBody;

	@Column(name = "status")
	@NotNull(message = "Status is required")
	private Integer status;

	@Column(name = "user_verified")
	private String userVerified;

	@JsonIgnore
	@Column(name = "user_verification_code")
	private String userVerificationCode;

	@Column(name = "verification_link")
	private String verificationLink;

	@Column(name = "verification_link_ts")
	private Timestamp verificationLinkTs;

	@JsonIgnore
	@Column(name = "last_pass_chg_date")
	private Timestamp lastPassChangedDate;

	@JsonIgnore
	@Column(name = "last_pass_chg_by")
	private Integer lastPassChangedBy;

	@JsonIgnore
	@Column(name = "global_admin", updatable = false)
	private Integer globalAdmin;

	@JsonIgnore
	@Column(name = "last_login")
	private Timestamp lastLogin;

	@JsonIgnore
	@Column(name = "no_failed_logins")
	private Integer noFailedLogins;

	@JsonIgnore
	@Column(name = "password_reset_code")
	private String passwordResetCode;

	@JsonIgnore
	@Column(name = "password_reset_code_ts")
	private Timestamp passwordResetCodeTs;

	@Column(name = "profile_image")
	private String profileImage;

	@Column(name = "mfa")
	private Boolean mfa;

	@Column(name = "secret")
	private String secret;

	@Column(name = "title")
	private String title;

	@Column(name = "post_nominal")
	private String postNominal;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "council_registrant_number")
	private String councilRegistrantNumber;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<UserAssessorDetail> userAssessorDetailsList;

//    public List<UserAssessorDetail> getUserAssessorDetailsListFiltered() {
//        return userAssessorDetailsList.stream().filter(ud -> ud.getStatus() != 3).collect(Collectors.toList());
//    }

//    @OneToMany(mappedBy = "user")
//    private List<AvailTimeSlot> availTimeSlotList;
}
