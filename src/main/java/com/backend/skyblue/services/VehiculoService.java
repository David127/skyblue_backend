package com.backend.skyblue.services;

import com.backend.skyblue.dtos.Vehiculo;
import com.backend.skyblue.repository.VehiculoRepositoy;
import com.backend.skyblue.repository.generic.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements CrudService {
    @Autowired
    private VehiculoRepositoy vehiculoRepositoy;

    
    @Override
    public Page<Vehiculo> listarEnPaginas(String estado, Pageable pageable) {
        return  vehiculoRepositoy.listarEnPaginas(estado, pageable);
    }

    @Override
    public Optional<Vehiculo> listarPorId(long id) {
        return vehiculoRepositoy.findById(id);
    }

    @Override
    public List<?> listarTodos() {
        return vehiculoRepositoy.findAll();
    }
}
