package com.dio.projeto.controleponto.repository;

import com.dio.projeto.controleponto.model.Movimentacao;
import com.dio.projeto.controleponto.model.compositeKeys.MovimentacaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {
}
