package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.CarEngine;

import lombok.Getter;

@Getter
public class CarEngineDto {

	private final Long engineId;
	private final String engineName;
	private final Integer enginePrice;

	public CarEngineDto(CarEngine carEngine) {
		this.engineId = carEngine.getId();
		this.engineName = carEngine.getName();
		this.enginePrice = carEngine.getPrice();
	}
}
