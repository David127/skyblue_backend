package com.backend.skyblue.services;

import com.backend.skyblue.dtos.Trabajador;
import com.backend.skyblue.repository.TrabajadorRepository;
import com.backend.skyblue.repository.generic.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class TrabajadorService implements CrudService {
    @Autowired
    TrabajadorRepository trabajadorRepository;
    @Override
    public Page<Trabajador> listarEnPaginas(String estado, Pageable pageable) {
        return trabajadorRepository.searchPaginacion(estado,pageable);
    }

    @Override
    public Optional<Trabajador> listarPorId(long id) {
        return trabajadorRepository.findById(id);
    }

    @Override
    public List<?> listarTodos() {
        return trabajadorRepository.findAll();
    }

    public boolean existeTrabajador(Trabajador obj) {
        return  trabajadorRepository.existsById(obj.getId());
    }

    public Trabajador insertar(Trabajador obj){
        if(obj == null)
            throw new IllegalArgumentException ("El objeto Trabajador no puede ser nulo");
        return  trabajadorRepository.save(obj);
    }
    public Trabajador actualizar(Trabajador obj){
        return  trabajadorRepository.save(obj);
    }

    public Trabajador insertarActualizar(Trabajador obj) {

        if(existeTrabajador(obj)){
            return actualizar(obj);
        }else{
            return  insertar(obj);
        }

    }


}
