package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}