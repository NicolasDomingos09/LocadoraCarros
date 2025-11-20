package br.edu.fateczl.locadoracarros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reparo")
public class Reparo {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "entrada", nullable = false)
    private LocalDate entrada;

    @Column(name = "dias_reparo", nullable = false)
    private Integer diasReparo;

    @Column(name = "diagnostico", length = 150, nullable = false)
    private String diagnostico;

    @Column(name = "valor_reparo", columnDefinition = "DECIMAL(5,2)", nullable = false)
    private BigDecimal valor_reparo;

    @ManyToOne(targetEntity = Carro.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_placa", nullable = false)
    private Carro carro;
}
