package com.backend.skyblue.repository;

import com.backend.skyblue.models.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo,Long>, JpaSpecificationExecutor<Ubigeo> {
	@Query("select distinct x.departamento from Ubigeo x order by 1 asc")
	public abstract List<String> listaDepartamentos();

	@Query("select distinct x.provincia from Ubigeo x where x.departamento = :var_dep  order by 1 asc")
	public abstract List<String> listaProvincias(@Param("var_dep") String departamento);

	@Query("select x from Ubigeo x where x.departamento = :var_dep and x.provincia = :var_pro  order by x.distrito asc")
	public abstract List<Ubigeo> listaDistritos(@Param("var_dep") String departamento, @Param("var_pro") String provincia);
}
