package com.smartsolution.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
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
public class LoginToken {
	@NotEmpty(message = "User name is required")
	private String userName;
	@NotEmpty(message = "Password is required")
	private String password;
	private String oldPassword;
	private String token;
	private Long userId;
	private String refreshToken;
	private String details;
	private String firstName;
	private String lastName;
	private String userGroupName;
	private Integer groupType;
	private Long groupId;

	private String groupCode;
	private String licenseBodyName;
	private String licenseBodyLogo;
	private Integer allowAdminLogin;
	private String userVerified;
	private Integer status;
	@JsonIgnore
	private Boolean loginStatus;
	@JsonIgnore
	private String loginStatusMessage;
	private Boolean mfa;

	private String qrImage;
}
