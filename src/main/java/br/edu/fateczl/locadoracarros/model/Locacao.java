package br.edu.fateczl.locadoracarros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locacao")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(targetEntity = Carro.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_placa", referencedColumnName = "placa")
    private Carro carro;

    @ManyToOne(targetEntity = Locatario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "locatario_cpf", referencedColumnName = "cpf")
    private Locatario locatario;

    @Column(name = "data_retirada", nullable = false)
    private LocalDate dataRetirada;

    @Column(name = "dias_locacao", nullable = false)
    private Integer diasLocacao;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Column(name = "valor_total", columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal valorTotal;

    @Column(name = "valor_extra", columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal valorExtra;

    public String getDataRetiradaFormatada() {
        if (dataRetirada == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataRetirada.format(formatter);
    }

    public String getDataDevolucaoFormatada() {
        if (dataDevolucao == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDevolucao.format(formatter);
    }
}
