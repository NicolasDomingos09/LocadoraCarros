package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Reparo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReparoRepository extends JpaRepository<Reparo, Long> {
}