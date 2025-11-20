package br.edu.fateczl.locadoracarros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;

    @Column(name = "valor_diaria", columnDefinition = "DECIMAL(5, 2)", nullable = false)
    private Double valorDiaria;

}
