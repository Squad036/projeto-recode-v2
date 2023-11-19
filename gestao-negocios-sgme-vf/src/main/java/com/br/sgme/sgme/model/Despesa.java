    package com.br.sgme.sgme.model;

    import com.br.sgme.sgme.enums.FormasPagamento;
    import jakarta.persistence.*;
    import lombok.*;
    import org.springframework.format.annotation.DateTimeFormat;

    import java.io.Serializable;
    import java.time.LocalDate;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    @EqualsAndHashCode
    @Entity
    @Table(name="despesa")
    public class Despesa  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @ManyToOne
        @JoinColumn(name = "fornecedor_id")
        private Fornecedor fornecedor;

        @Column(nullable = false)
        private Double valor;

        @Column(name = "data_vencimento", nullable = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate dataVencimento;

        private String status;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private FormasPagamento pagamento;


    }
