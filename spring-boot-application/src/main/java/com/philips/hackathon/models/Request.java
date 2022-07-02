package com.philips.hackathon.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer age;
	
	private Double oxyLvl;

}
