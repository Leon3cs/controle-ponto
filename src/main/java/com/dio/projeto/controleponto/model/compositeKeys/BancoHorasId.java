package com.dio.projeto.controleponto.model.compositeKeys;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BancoHorasId implements Serializable {
        private Long bancoHorasId;
        private Long movimentacaoId;
        private Long usuarioId;

        public BancoHorasId() {
        }

        public BancoHorasId(Long bancoHorasId, Long movimentacaoId, Long usuarioId) {
                this.bancoHorasId = bancoHorasId;
                this.movimentacaoId = movimentacaoId;
                this.usuarioId = usuarioId;
        }

        public Long getBancoHorasId() {
                return bancoHorasId;
        }

        public void setBancoHorasId(Long bancoHorasId) {
                this.bancoHorasId = bancoHorasId;
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
                BancoHorasId that = (BancoHorasId) o;
                return getBancoHorasId().equals(that.getBancoHorasId()) && getMovimentacaoId().equals(that.getMovimentacaoId()) && getUsuarioId().equals(that.getUsuarioId());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getBancoHorasId(), getMovimentacaoId(), getUsuarioId());
        }
}
