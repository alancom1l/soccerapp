package com.soccerapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "numero_colete")
    private Integer numeroColete;

    private int gols = 0;
    private int assistencias = 0;
    private int cartoesAmarelos = 0;
    private int cartoesVermelhos = 0;
}
