package br.edu.fateczl.locadoracarros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carro")
public class Carro {
    @Id
    @Column(name="placa", length = 9, nullable = false)
    private String placa;

    @Column(name = "marca", length = 150, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 150, nullable = false)
    private String modelo;

    @Column(name = "cor", length = 150, nullable = false)
    private String cor;

    @Column(name = "ano", nullable = false)
    private LocalDate ano;

    @Column(name = "tipo_combustivel", length = 9, nullable = false)
    private String tipoCombustivel;

    @Column(name = "quilometragem", nullable = false)
    private Integer quilometragem;

    @Column(name = "tipo_cambio", length = 150, nullable = false)
    private String tipoCambio;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Categoria.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

}
