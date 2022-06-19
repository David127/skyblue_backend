package com.backend.skyblue.services;

import com.backend.skyblue.models.Propietario;
import com.backend.skyblue.repository.PropietarioRepository;
import com.backend.skyblue.repository.generic.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropietarioService implements CrudService {

    @Autowired
    PropietarioRepository propietarioRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<?> listarEnPaginas(String estado, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Propietario> listarPorId(long id) {
        return propietarioRepository.findById(id);
    }

    @Override
    public List<Propietario> listarTodos() {
        return propietarioRepository.findAll();
    }

    public boolean existePropietario(Propietario obj){
        return propietarioRepository.existsById(obj.getId());
    }

    public Propietario insertarActualizar(Propietario obj){

        if (existePropietario(obj)){
            return actualizar(obj);
        }else {
            return insertar(obj);
        }
    }

    private Propietario insertar(Propietario obj) {
        if (obj == null)
            throw new IllegalArgumentException("El objeto Propietario no puede estar vacio");

        return propietarioRepository.save(obj);
    }

    public Propietario actualizar(Propietario obj) {

        return propietarioRepository.save(obj);
    }

    public void eliminar(Long id) {
       propietarioRepository.deleteById(id);
    }
}
