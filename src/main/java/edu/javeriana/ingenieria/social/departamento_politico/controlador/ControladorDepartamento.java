package edu.javeriana.ingenieria.social.departamento_politico.controlador;

import edu.javeriana.ingenieria.social.departamento_politico.dominio.Departamento;
import edu.javeriana.ingenieria.social.departamento_politico.servicio.ServicioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentosPoliticos")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorDepartamento {

    @Autowired
    private ServicioDepartamento servicio;

    @GetMapping("listar")
    public List<Departamento> obtenerDepartamentos(){
        return servicio.obtenerDepartamentos();
    }

    @GetMapping("obtener")
    public ResponseEntity<Departamento> obtenerDepartamento(@RequestParam String iso2){
        if(iso2 == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.departamentoExiste(iso2)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDepartamento(iso2), HttpStatus.OK);
    }

    @GetMapping("obtenerPais")
    public ResponseEntity<List<Departamento>> obtenerDepartamentos(@RequestParam String pais){
        if(pais == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerDepartamentos(pais).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDepartamentos(pais), HttpStatus.OK);
    }
}
