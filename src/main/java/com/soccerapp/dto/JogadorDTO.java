package com.soccerapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record JogadorDTO(
        UUID id,

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @Min(value = 0, message = "Gols não podem ser negativos")
        int gols,

        @Min(value = 0, message = "Assistências não podem ser negativas")
        int assistencias,

        @Min(value = 0, message = "Cartões amarelos não podem ser negativos")
        int cartoesAmarelos,

        @Min(value = 0, message = "Cartões vermelhos não podem ser negativos")
        int cartoesVermelhos
) {}
