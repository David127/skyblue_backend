package com.backend.skyblue.services;

import com.backend.skyblue.dto.common.PageResponseDto;
import com.backend.skyblue.mapper.ViajeMapper;
import com.backend.skyblue.models.Viaje;
import com.backend.skyblue.repository.ViajesRespository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViajesService {
	private final ViajesRespository viajesRepositoy;

	public PageResponseDto listarVehiculoEnPaginas(Pageable pageable){
		Page<Viaje> vehiculoFound = viajesRepositoy.findAll(pageable);
		return ViajeMapper.buildViajePageResponseDto(vehiculoFound);
	}

}
