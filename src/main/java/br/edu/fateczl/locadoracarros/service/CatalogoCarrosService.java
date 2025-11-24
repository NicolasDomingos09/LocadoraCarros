/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é gerenciar as regras de negócio do catálogo de carros.
 * DIP (Dependency Inversion Principle) - A classe depende de uma abstração (ICarroRepository), e não de uma implementação concreta.
 */
package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Carro;
import br.edu.fateczl.locadoracarros.repository.ICarroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoCarrosService {

    @Autowired
    private ICarroRepository carroRepository;

    public List<Carro> listarCarrosDisponiveis() {
        return carroRepository.listarCarrosDisponiveis();
    }

    public List<Carro> listarCarrosDisponiveisPorCategoria(Long categoriaID) {
        return carroRepository.listarCarrosDisponiveis(categoriaID);
    }

    public Carro getCarroPorPlaca(String placa) {
        return carroRepository.findById(placa)
                .orElseThrow( () -> new EntityNotFoundException("Carro não encontrado"));
    }
}
