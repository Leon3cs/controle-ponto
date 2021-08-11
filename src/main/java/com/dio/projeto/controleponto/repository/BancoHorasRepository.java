package com.dio.projeto.controleponto.repository;

import com.dio.projeto.controleponto.model.BancoHoras;
import com.dio.projeto.controleponto.model.compositeKeys.BancoHorasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {
}
