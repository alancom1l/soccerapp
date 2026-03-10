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
                jogador.getApelido(),
                jogador.getDataNascimento(),
                jogador.getTimeTorce(),
                jogador.getNumeroColete(),
                jogador.getPosicaoPreferida(),
                jogador.getFotoUrl(),
                jogador.getAtivo(),
                jogador.getDataEntradaAssociacao()
        );
    }

    public Jogador toEntity(JogadorDTO dto) {
        return new Jogador(
                dto.id(),
                dto.nome(),
                dto.apelido(),
                dto.dataNascimento(),
                dto.timeTorce(),
                dto.numeroColete(),
                dto.posicaoPreferida(),
                dto.fotoUrl(),
                dto.ativo(),
                dto.dataEntradaAssociacao()
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
