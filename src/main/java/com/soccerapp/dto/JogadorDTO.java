package com.soccerapp.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record JogadorDTO(
        UUID id,

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        String apelido,

        LocalDate dataNascimento,

        String timeTorce,

        Integer numeroColete,

        String posicaoPreferida,

        String fotoUrl,

        Boolean ativo,

        LocalDate dataEntradaAssociacao
) {}
