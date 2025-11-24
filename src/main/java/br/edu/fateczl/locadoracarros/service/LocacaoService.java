package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.repository.ILocacaoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Locacao getLocacaoId(Long id) {
        return locacaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));
    }

    public Locacao buscarPorDataCarroELocatario(LocalDate dataRetirada, String carroPlaca, String locatarioCpf) {
        return locacaoRepository.findByDataRetiradaAndCarroPlacaAndLocatarioCpf(dataRetirada, carroPlaca, locatarioCpf)
                .orElseThrow(() -> new EntityNotFoundException("Locação não encontrada"));
    }

    public void salvarLocacao(Locacao locacao) {
        locacaoRepository.save(locacao);
    }

    public void atualizarLocacao(Locacao locacao) {
        locacaoRepository.save(locacao);
    }

    public void deletarLocacao(Long id) {
        locacaoRepository.deleteById(id);
    }

}
