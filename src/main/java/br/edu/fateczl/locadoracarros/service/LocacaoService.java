/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é gerenciar as regras de negócio de Locacao.
 * DIP (Dependency Inversion Principle) - A classe depende de uma abstração (ILocacaoRepository), e não de uma implementação concreta.
 */
package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.repository.ILocacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private ILocacaoRepository locacaoRepository;

    public List<Locacao> listarLocacoes() {
        return locacaoRepository.findAll();
    }

    public List<Locacao> listarLocacoesEmAberto(){
        return locacaoRepository.findLocacoesEmAberto();
    }

    public Locacao getLocacaoId(Long id) {
        return locacaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));
    }

    public Locacao buscarPorDataCarroELocatario(LocalDate dataRetirada, String carroPlaca, String locatarioCpf) {
        return locacaoRepository.findByDataRetiradaAndCarroPlacaAndLocatarioCpf(dataRetirada, carroPlaca, locatarioCpf)
                .orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));
    }

    @Transactional
    public void salvarLocacao(Locacao locacao) {
        locacaoRepository.save(locacao);
    }

    @Transactional
    public void atualizarLocacao(Locacao locacao) {
        locacaoRepository.save(locacao);
    }

    @Transactional
    public void deletarLocacao(Long id) {
        locacaoRepository.deleteById(id);
    }

}
