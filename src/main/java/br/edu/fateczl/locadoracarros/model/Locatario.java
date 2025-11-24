/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é representar a entidade Locatario.
 */
package br.edu.fateczl.locadoracarros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locatario")
public class Locatario {

    @Id
    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "habilitacao", length = 11, nullable = false)
    private String habilitacao;

    @Column(name = "nascimento", nullable = false)
    private LocalDate nascimento;

    @Column(name = "logradouro", length = 150, nullable = false)
    private String logradouro;

    @Column(name = "CEP", length = 8, nullable = false)
    private String cep;

    @Column(name = "numero", length = 4, nullable = false)
    private String numero;

    @Column(name = "cidade", length = 150, nullable = false)
    private String cidade;

    public String getCpfFormatado() {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

}
