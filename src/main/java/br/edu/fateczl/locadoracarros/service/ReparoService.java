/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é gerenciar as regras de negócio de Reparo.
 * DIP (Dependency Inversion Principle) - A classe depende de uma abstração (IReparoRepository), e não de uma implementação concreta.
 */
package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Reparo;
import br.edu.fateczl.locadoracarros.repository.IReparoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReparoService {

    @Autowired
    private IReparoRepository reparoRepository;

    public List<Reparo> listarReparos() {
        return reparoRepository.findAll();
    }

    public Reparo buscarReparo(Long id) {
        return reparoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reparo não encontrado"));
    }

    @Transactional
    public void salvarReparo(Reparo reparo) {
        reparoRepository.save(reparo);
    }

    @Transactional
    public void atualizerReparo(Reparo reparo) {
        reparoRepository.save(reparo);
    }

    @Transactional
    public void excluirReparo(Long id) {
        reparoRepository.deleteById(id);
    }
}
