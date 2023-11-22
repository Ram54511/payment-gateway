package com.smartsolution.domain;

import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorResponse {
	public ErrorResponse(String status, String message, List<String> details) {
		super();
		this.status = status;
		this.message = message;
		this.details = details;
	}

	@Schema(name = "Status of request")
	private String status;
	@Schema(name = "Status code of request")
	private Integer statusCode;
	@Schema(name = "Message returned by request")
	private String message;
	@Schema(name = "Detailed information returned by request")
	private List<String> details;
	@Schema(name = "Data returned by request")
	private Object data;
	@Schema(name = "List of access for user assigned")
	private List<String> access;
	@Schema(name = "List of dropdown key with values")
	private Map<String, List<SelectDto>> selectList;

	public String getStatus() {
		return status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<String> getAccess() {
		return access;
	}

	public void setAccess(List<String> access) {
		this.access = access;
	}

	public Map<String, List<SelectDto>> getSelectList() {
		return selectList;
	}

	public void setSelectList(Map<String, List<SelectDto>> selectList) {
		this.selectList = selectList;
	}
}
