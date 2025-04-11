package com.soccerapp.mapper;

import com.soccerapp.dto.JogadorDTO;
import com.soccerapp.model.Jogador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JogadorMapper {

    public JogadorDTO toDTO(Jogador jogador) {
        return new JogadorDTO(
                jogador.getId(),
                jogador.getNome(),
                jogador.getNumeroColete(),
                jogador.getGols(),
                jogador.getAssistencias(),
                jogador.getCartoesAmarelos(),
                jogador.getCartoesVermelhos()
        );
    }

    public Jogador toEntity(JogadorDTO dto) {
        return new Jogador(
                dto.id(),
                dto.nome(),
                dto.numeroColete(),
                dto.gols(),
                dto.assistencias(),
                dto.cartoesAmarelos(),
                dto.cartoesVermelhos()
        );
    }

    public List<JogadorDTO> toDTOList(List<Jogador> jogadores) {
        return jogadores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Jogador> toEntityList(List<JogadorDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
