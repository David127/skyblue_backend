package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.VehiculoRequestDto;
import com.backend.skyblue.dto.response.VehiculoResponseDto;
import com.backend.skyblue.mapper.VehiculoMapper;
import com.backend.skyblue.models.Vehiculo;
import com.backend.skyblue.repository.VehiculoRepositoy;
import com.backend.skyblue.repository.generic.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiculoService implements CrudService {
	@Autowired
	private VehiculoRepositoy vehiculoRepositoy;

	private final VehiculoBuilderService vehiculoBuilderService;

	@Override
	public Page<Vehiculo> listarEnPaginas(String estado, Pageable pageable) {
		return vehiculoRepositoy.listarEnPaginas(estado, pageable);
	}

	@Override
	public Optional<Vehiculo> listarPorId(long id) {
		return vehiculoRepositoy.findById(id);
	}

	@Override
	public List<?> listarTodos() {
		return vehiculoRepositoy.findAll();
	}

	public PageResponseDto listarVehiculosEnPaginas(Pageable pageable) {
		Page<Vehiculo> vehiculoFound = vehiculoRepositoy.findAll(pageable);
		return VehiculoMapper.buildVehiculoPageResponseDto(vehiculoFound);
	}

	public boolean existeVehiculo(VehiculoRequestDto request) {
		return vehiculoRepositoy.existsById(request.getId());
	}

	public VehiculoResponseDto insertarActualizar(VehiculoRequestDto request) {
		if (existeVehiculo(request)) {
			return actualizar(request);
		}
		return create(request);
	}

	private VehiculoResponseDto create(VehiculoRequestDto request) {
		VehiculoResponseDto vehiculoResponse = CreateNewVehiculo(request);
		return vehiculoResponse;
	}

	private VehiculoResponseDto actualizar(VehiculoRequestDto request) {
		if (request == null)
			throw new IllegalArgumentException("El Vehiculo no puedo ser nulo");
		if (request.getId() == null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		VehiculoResponseDto vehiculoResponse = CreateNewVehiculo(request);
		return vehiculoResponse;
	}

	private VehiculoResponseDto CreateNewVehiculo(VehiculoRequestDto request) {
		var vehiculo = vehiculoBuilderService.buildNewVehiculo(request);
		save(vehiculo);
		return VehiculoMapper.buildResponseDto(vehiculo);

	}

	@Transactional
	private Vehiculo save(Vehiculo vehiculo) {
		var vehiculoSaved = vehiculoRepositoy.saveAndFlush(vehiculo);
		return vehiculoSaved;
	}


}
