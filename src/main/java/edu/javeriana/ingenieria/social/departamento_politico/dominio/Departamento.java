package edu.javeriana.ingenieria.social.departamento_politico.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="departamento_politico")
public class Departamento {
    @Id
    private Integer id;
    private String nombre, pais, iso2;
}
