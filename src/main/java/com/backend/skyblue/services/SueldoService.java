package com.backend.skyblue.services;

import com.backend.skyblue.models.Sueldo;
import com.backend.skyblue.repository.SueldoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SueldoService {
    private  final SueldoRepository sueldoRepository;

    public Sueldo findById(long id) {
        Optional<Sueldo> sueldo = sueldoRepository.findById(id);
        if(sueldo.isEmpty()){
            throw new HttpServerErrorException(
                    HttpStatus.NOT_FOUND, "No se encontro sueldo para el Id " + id);
        }
        return sueldo.get();
    }

    @Transactional
    public Set<Sueldo> findAllByTrabajadorId(Long trabajadorId){
        Set<Sueldo> sueldo = sueldoRepository.findByFkTrabajador(trabajadorId);
        if(CollectionUtils.isEmpty(sueldo)){
            throw new HttpServerErrorException(
                    HttpStatus.NOT_FOUND,
                    "No se encontraron paquetes para el id de trabajador " + trabajadorId);
        }
        return sueldo;
    }

    @Transactional
    public List<Sueldo> saveAll(Set<Sueldo> sueldos){
        return sueldoRepository.saveAll(sueldos);
    }
}
