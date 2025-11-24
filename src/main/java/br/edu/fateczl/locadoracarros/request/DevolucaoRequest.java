package br.edu.fateczl.locadoracarros.request;

import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.model.Reparo;

public record DevolucaoRequest(
        Locacao locacao,
        Reparo reparo
) {
}
