package com.yubi.geographycolumns.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OldNewMap {
	@JsonProperty("oldName")
	private String oldNm;
	@JsonProperty("newName")
	private String newNm;
}
