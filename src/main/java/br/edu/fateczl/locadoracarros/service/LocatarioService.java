/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é gerenciar as regras de negócio de Locatario.
 * DIP (Dependency Inversion Principle) - A classe depende de uma abstração (ILocatarioRepository), e não de uma implementação concreta.
 */
package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Locatario;
import br.edu.fateczl.locadoracarros.repository.ILocatarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatarioService {

    @Autowired
    private ILocatarioRepository repository;

    public List<Locatario> listarLocatarios() {
        return repository.findAll();
    }

    public Locatario getLocatarioCpf(String cpf) {
        return repository.findById(cpf).orElseThrow(() -> new EntityNotFoundException("Locatário não encontrado"));
    }

    @Transactional
    public void salvarLocatario(Locatario locatario) {
        repository.save(locatario);
    }

    @Transactional
    public void atualizarLocatario(Locatario locatario) {
        repository.save(locatario);
    }

    @Transactional
    public void deletarLocatario(String cpf) {
        repository.deleteById(cpf);
    }
}
