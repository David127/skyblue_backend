package com.backend.skyblue.repository.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface CrudService {
    public abstract Page<?> listarEnPaginas(String estado, Pageable pageable);
    public abstract Optional<?> listarPorId(long id);
    public List<?> listarTodos();


}
