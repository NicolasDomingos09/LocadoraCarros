package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarroRepository extends JpaRepository<Carro, String> {
}