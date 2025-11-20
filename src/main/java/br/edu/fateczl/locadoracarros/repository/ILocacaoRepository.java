package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.model.LocacaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocacaoRepository extends JpaRepository<Locacao, LocacaoId> {
}