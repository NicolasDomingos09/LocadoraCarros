/*
 * Aplicacao do SOLID
 * ISP (Interface Segregation Principle) - A interface ICategoriaRepository define um contrato coeso para operações de Categoria, evitando que as classes que a implementam sejam forçadas a implementar métodos que não utilizam.
 * DIP (Dependency Inversion Principle) - A interface ICategoriaRepository é uma abstração que desacopla as classes de serviço que a utilizam das implementações concretas de acesso a dados.
 */
package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
