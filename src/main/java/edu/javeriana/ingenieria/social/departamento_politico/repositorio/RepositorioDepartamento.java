package edu.javeriana.ingenieria.social.departamento_politico.repositorio;

import edu.javeriana.ingenieria.social.departamento_politico.dominio.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDepartamento extends JpaRepository<Departamento, Integer> {
    Departamento findOneByIso2(String iso2);

    List<Departamento> findAllByPais(String pais);

    boolean existsByIso2(String iso2);
}
