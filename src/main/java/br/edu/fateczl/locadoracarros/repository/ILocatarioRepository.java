/*
 * Aplicacao do SOLID
 * ISP (Interface Segregation Principle) - A interface ILocatarioRepository define um contrato coeso para operações de Locatario, evitando que as classes que a implementam sejam forçadas a implementar métodos que não utilizam.
 * DIP (Dependency Inversion Principle) - A interface ILocatarioRepository é uma abstração que desacopla as classes de serviço que a utilizam das implementações concretas de acesso a dados.
 */
package br.edu.fateczl.locadoracarros.repository;

import br.edu.fateczl.locadoracarros.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocatarioRepository extends JpaRepository<Locatario, String> {
}
