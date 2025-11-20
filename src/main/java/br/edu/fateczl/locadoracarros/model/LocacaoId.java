package br.edu.fateczl.locadoracarros.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class LocacaoId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Carro carro;
    private Locatario locatario;
}
