package com.backend.skyblue.mapper;

import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.models.Cargo;

public class CargoCreateBuilder {
	private Cargo cargo;
	private CargoRequestDto cargoRequest;

	public CargoCreateBuilder cargoDto(CargoRequestDto request){
		this.cargoRequest = request;
		cargo = CargoMapper.buildEntidadFromDto(request);
		return this;
	}
	public Cargo build(){
		return cargo;
	}
}
