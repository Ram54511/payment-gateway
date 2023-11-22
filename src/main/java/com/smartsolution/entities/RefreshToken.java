package com.smartsolution.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "RefreshToken")
@Table(name = "sst_refresh_tokens")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class RefreshToken extends BaseEntity {
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long Id;

	@Column(name = "token")
	private String token;

	@Column(name = "refresh_token")
	private String refreshToken;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "host_address")
	private String hostAddress;

	@Column(name = "user_agent")
	private String userAgent;

	@Column(name = "user_id")
	private Long userId;

}
