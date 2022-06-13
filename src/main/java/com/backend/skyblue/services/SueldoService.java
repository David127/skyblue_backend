package com.backend.skyblue.services;

import com.backend.skyblue.dto.request.SueldoRequestDto;
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

    public double calcularSueldo(Double base, Integer horas){
        var total = 0.0;
         total = (base / 192 * horas );
         return total;
    }
    @Transactional
    public List<Sueldo> saveAll(Set<Sueldo> sueldos){
        return sueldoRepository.saveAll(sueldos);
    }
}
