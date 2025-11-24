/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é representar a requisição de locação.
 */
package br.edu.fateczl.locadoracarros.request;

import br.edu.fateczl.locadoracarros.model.Carro;
import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.model.Locatario;

public record LocacaoRequest(
        Locacao locacao,
        Locatario locatario,
        Carro carro
){}
