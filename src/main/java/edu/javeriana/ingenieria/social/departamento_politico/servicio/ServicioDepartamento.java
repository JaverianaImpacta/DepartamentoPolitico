package edu.javeriana.ingenieria.social.departamento_politico.servicio;

import edu.javeriana.ingenieria.social.departamento_politico.dominio.Departamento;
import edu.javeriana.ingenieria.social.departamento_politico.repositorio.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDepartamento {
    @Autowired
    private RepositorioDepartamento repositorio;

    public List<Departamento> obtenerDepartamentos() {
        return repositorio.findAll();
    }

    public Departamento obtenerDepartamento(String iso2){
        return repositorio.findOneByIso2(iso2);
    }

    public List<Departamento> obtenerDepartamentos(String pais){
        return repositorio.findAllByPais(pais);
    }

    public boolean departamentoExiste(String iso2){
        return repositorio.existsByIso2(iso2);
    }
}
