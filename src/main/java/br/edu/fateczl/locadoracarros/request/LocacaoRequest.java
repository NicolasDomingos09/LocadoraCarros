package br.edu.fateczl.locadoracarros.request;

import br.edu.fateczl.locadoracarros.model.Carro;
import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.model.Locatario;

public record LocacaoRequest(
        Locacao locacao,
        Locatario locatario,
        Carro carro
){}