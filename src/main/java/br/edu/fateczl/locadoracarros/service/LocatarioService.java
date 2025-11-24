package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Locatario;
import br.edu.fateczl.locadoracarros.repository.ILocatarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatarioService {

    @Autowired
    private ILocatarioRepository repository;

    public List<Locatario> listarLocatarios(){
        return repository.findAll();
    }

    public Locatario getLocatarioCPF(String cpf){
        return repository.findById(cpf).orElseThrow( () -> new EntityNotFoundException("Locatário não encontrado"));
    }

    public void salvarLocatario(Locatario locatario){
        repository.save(locatario);
    }

    public void atualizarLocatario(Locatario locatario){
        repository.save(locatario);
    }

    public void deletarLocatario(String cpf){
        repository.deleteById(cpf);
    }
}
