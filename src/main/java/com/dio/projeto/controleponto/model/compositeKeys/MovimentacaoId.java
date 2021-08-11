package com.dio.projeto.controleponto.model.compositeKeys;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovimentacaoId implements Serializable {
    private Long movimentacaoId;
    private Long usuarioId;

    public MovimentacaoId() {
    }

    public MovimentacaoId(Long movimentacaoId, Long usuarioId) {
        this.movimentacaoId = movimentacaoId;
        this.usuarioId = usuarioId;
    }

    public Long getMovimentacaoId() {
        return movimentacaoId;
    }

    public void setMovimentacaoId(Long movimentacaoId) {
        this.movimentacaoId = movimentacaoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimentacaoId that = (MovimentacaoId) o;
        return getMovimentacaoId().equals(that.getMovimentacaoId()) && getUsuarioId().equals(that.getUsuarioId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovimentacaoId(), getUsuarioId());
    }
}
