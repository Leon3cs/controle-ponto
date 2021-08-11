package com.dio.projeto.controleponto.model;

import com.dio.projeto.controleponto.model.compositeKeys.MovimentacaoId;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class Movimentacao {
    @EmbeddedId
    private MovimentacaoId id;
    @Column
    @NonNull private LocalDateTime dataEntrada;
    @Column
    @NonNull private LocalDateTime dataSaida;
    @Column
    @NonNull private Integer periodoPermanencia;
    @ManyToOne
    @NonNull private Ocorrencia ocorrencia;
    @ManyToOne
    @NonNull private Calendario codigoDataEspecial;
}
