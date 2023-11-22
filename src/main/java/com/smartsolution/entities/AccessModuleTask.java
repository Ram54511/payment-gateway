package com.smartsolution.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessModuleTask {
	private Long moduleId;
	private String moduleName;
	private String moduleDescription;
	private Integer moduleOrder;
	private Long taskId;
	private String task;
	private Integer taskExist;
}
