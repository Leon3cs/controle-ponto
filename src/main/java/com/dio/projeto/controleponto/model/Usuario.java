package com.dio.projeto.controleponto.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NonNull private CategoriaUsuario categoriaUsuario;
    @NonNull private String nome;
    @ManyToOne
    @NonNull private Empresa empresa;
    @ManyToOne
    @NonNull private NivelAcesso nivelAcesso;
    @ManyToOne
    @NonNull private JornadaTrabalho jornadaTrabalho;
    @Column
    @NonNull private BigDecimal toleranciaPorAtraso;
    @Column
    @NonNull private LocalDateTime inicioJornada;
    @Column
    @NonNull private LocalDateTime finalJornada;
}
