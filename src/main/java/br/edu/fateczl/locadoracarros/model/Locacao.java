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
@Table(name = "locacao")
@IdClass(LocacaoId.class)
public class Locacao {
    @Id
    @ManyToOne(targetEntity = Carro.class, fetch = FetchType.LAZY)
    private Carro carro;

    @Id
    @ManyToOne(targetEntity = Locatario.class, fetch = FetchType.LAZY)
    private Locatario locatario;

    @Column(name = "data_retirada", nullable = false)
    private LocalDate dataRetirada;

    @Column(name = "dias_locacao", nullable = false)
    private Integer diasLocacao;

    @Column(name = "data_devolucao", nullable = false)
    private LocalDate dataDevolucao;

    @Column(name = "valor_total", columnDefinition = "DECIMAL(5, 2)")
    private BigDecimal valorTotal;

    @Column(name = "valor_extra", columnDefinition = "DECIMAL(5, 2)")
    private BigDecimal valorExtra;

}
