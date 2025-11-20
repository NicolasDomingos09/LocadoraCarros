package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocatarioRepository extends JpaRepository<Locatario, String> {
}