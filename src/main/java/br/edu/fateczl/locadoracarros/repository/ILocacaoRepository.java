package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ILocacaoRepository extends JpaRepository<Locacao, Long> {

    Optional<Locacao> findByDataRetiradaAndCarroPlacaAndLocatarioCpf(LocalDate dataRetirada, String carroPlaca, String locatarioCpf);

}
