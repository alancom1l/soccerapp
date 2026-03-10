package com.soccerapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 100)
    private String apelido;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "time_torce", length = 50)
    private String timeTorce;

    @Column(name = "numero_colete")
    private Integer numeroColete;

    @Column(name = "posicao_preferida", length = 50)
    private String posicaoPreferida;

    @Column(name = "foto_url", length = 255)
    private String fotoUrl;

    @Column
    private Boolean ativo = true;

    @Column(name = "data_entrada_associacao", nullable = false)
    private LocalDate dataEntradaAssociacao;
}
