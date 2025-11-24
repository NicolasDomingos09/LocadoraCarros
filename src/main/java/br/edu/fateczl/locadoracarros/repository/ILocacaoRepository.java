/*
 * Aplicacao do SOLID
 * ISP (Interface Segregation Principle) - A interface ILocacaoRepository define um contrato coeso para operações de Locacao, evitando que as classes que a implementam sejam forçadas a implementar métodos que não utilizam.
 * DIP (Dependency Inversion Principle) - A interface ILocacaoRepository é uma abstração que desacopla as classes de serviço que a utilizam das implementações concretas de acesso a dados.
 */
package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ILocacaoRepository extends JpaRepository<Locacao, Long> {

    Optional<Locacao> findByDataRetiradaAndCarroPlacaAndLocatarioCpf(LocalDate dataRetirada, String carroPlaca, String locatarioCpf);

    @Query("SELECT l FROM Locacao l WHERE l.dataDevolucao IS NULL")
    List<Locacao> findLocacoesEmAberto();

}
