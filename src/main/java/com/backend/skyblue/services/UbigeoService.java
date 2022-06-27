package com.backend.skyblue.services;

import com.backend.skyblue.models.Ubigeo;
import com.backend.skyblue.repository.UbigeoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UbigeoService {
	private final UbigeoRepository repository;

	public List<String> listaDepartamentos() {
		var departamentos = repository.listaDepartamentos();
		;
		return repository.listaDepartamentos();
	}

	public List<String> listaProvincias(String departamento) {
		return repository.listaProvincias(departamento);
	}

	public List<Ubigeo> listaDistritos(String departamento, String provincia) {
		return repository.listaDistritos(departamento, provincia);
	}

}
