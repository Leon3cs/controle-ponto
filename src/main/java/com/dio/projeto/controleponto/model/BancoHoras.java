package com.dio.projeto.controleponto.model;

import com.dio.projeto.controleponto.model.compositeKeys.BancoHorasId;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class BancoHoras {
    @EmbeddedId
    private BancoHorasId id;
    @Column
    @NonNull private LocalDateTime dataTrabalhada;
    @Column
    @NonNull private BigDecimal quantidadeHorasTrabalhadas;
    @Column
    @NonNull private BigDecimal saldoHorasTrabalhadas;
}
