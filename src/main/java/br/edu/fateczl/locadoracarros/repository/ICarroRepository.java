package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICarroRepository extends JpaRepository<Carro, String> {

    @Query(value = "SELECT * FROM listarCarrosDisponiveis(:categoriaID)", nativeQuery = true)
    List<Carro> listarCarrosDisponiveis(@Param("categoriaID") Long categoriaID);

    @Query(value = "SELECT * FROM listarCarrosDisponiveis(NULL)", nativeQuery = true)
    List<Carro> listarCarrosDisponiveis();
}
