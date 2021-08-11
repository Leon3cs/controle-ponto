package com.dio.projeto.controleponto.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NonNull private String descricao;
    @Column
    @NonNull private String numeroCnpj;
    @Column
    @NonNull private String endereco;
    @Column
    @NonNull private String bairro;
    @Column
    @NonNull private String cidade;
    @Column
    @NonNull private String estado;
    @Column
    @NonNull private String numeroTelefone;
}
