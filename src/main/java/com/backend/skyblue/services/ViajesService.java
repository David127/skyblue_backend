package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.dto.request.ViajeRequestDto;
import com.backend.skyblue.dto.response.ViajeResponseDto;
import com.backend.skyblue.mapper.ViajeMapper;
import com.backend.skyblue.models.Viaje;
import com.backend.skyblue.repository.ViajesRespository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ViajesService {
	private final ViajesRespository viajesRepositoy;

	private final ViajeBuilderService viajeBuilderService;

	public PageResponseDto listarVehiculoEnPaginas(Pageable pageable){
		Page<Viaje> vehiculoFound = viajesRepositoy.findAll(pageable);
		return ViajeMapper.buildViajePageResponseDto(vehiculoFound);
	}

	public boolean existeViaje(ViajeRequestDto request) {
		return viajesRepositoy.existsById(request.getId());
	}

	public ViajeResponseDto insertarActualizar(ViajeRequestDto request) {
		if(existeViaje(request))
			return  actualizar(request);
		return  create(request);
	}

	private ViajeResponseDto create(ViajeRequestDto request) {
		ViajeResponseDto viajeResponse = CreateNewViaje(request);
		return viajeResponse;
	}

	private ViajeResponseDto actualizar(ViajeRequestDto request) {
		if(request == null)
			throw new IllegalArgumentException("El Viaje no puedo ser nulo");
		if(request.getId()== null)
			throw new IllegalArgumentException("El id no puede ser nulo");
		ViajeResponseDto viajeResponse = CreateNewViaje(request);
		return  viajeResponse;

	}
	private ViajeResponseDto CreateNewViaje(ViajeRequestDto request) {
		var viaje = viajeBuilderService.buildNewViaje(request);
		save(viaje);
		return ViajeMapper.buildResponseDto(viaje);
	}

	@Transactional
	private Viaje save(Viaje viaje) {
		var viajeSaved = viajesRepositoy.saveAndFlush(viaje);
		return viajeSaved;
	}


}
