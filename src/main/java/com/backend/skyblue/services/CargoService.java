package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.CargoRequestDto;
import com.backend.skyblue.dto.response.CargoResponseDto;
import com.backend.skyblue.mapper.CargoMapper;
import com.backend.skyblue.models.Cargo;
import com.backend.skyblue.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CargoService {
	private final CargoRepository cargoRepository;
	private  final CargoBuilderService cargoBuilderService;
	public PageResponseDto listarCargoEnPaginas(Pageable pageable) {
		Page<Cargo> cargoFound = cargoRepository.findAll(pageable);
		return CargoMapper.buildCargoPageResponseDto(cargoFound);
	}

	public boolean existeCargo(CargoRequestDto request) {
		return cargoRepository.existsById(request.getId());
	}

	public CargoResponseDto insertarActualizar(CargoRequestDto request) {
		if(existeCargo(request))
			return actualizar(request);
		return create(request);
	}

	private CargoResponseDto actualizar(CargoRequestDto request) {
		if(request == null)
			throw new IllegalArgumentException("El Cargo no puedo ser nulo");
		if(request.getId() == null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		CargoResponseDto viajeResponse = CreateNewCargo(request);
		return  viajeResponse;
	}

	private CargoResponseDto CreateNewCargo(CargoRequestDto request) {
		var cargo = cargoBuilderService.buildNewCargo(request);
		save(cargo);
		return CargoMapper.buildResponseDto(cargo);
	}

	private CargoResponseDto create(CargoRequestDto request) {
		CargoResponseDto  cargoResponse = CreateNewCargo(request);
		return  cargoResponse;
	}
	@Transactional
	private Cargo save(Cargo cargo) {
		var cargoSaved = cargoRepository.saveAndFlush(cargo);
		return cargoSaved;
	}


}
