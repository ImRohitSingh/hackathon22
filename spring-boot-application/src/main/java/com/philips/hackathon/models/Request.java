package com.philips.hackathon.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer age;

	private Double oxyLvl;

}
