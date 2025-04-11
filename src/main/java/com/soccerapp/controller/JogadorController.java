package com.soccerapp.controller;

import com.soccerapp.dto.JogadorDTO;
import com.soccerapp.mapper.JogadorMapper;
import com.soccerapp.model.Jogador;
import com.soccerapp.service.JogadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;
    private final JogadorMapper jogadorMapper;

    public JogadorController(JogadorService jogadorService, JogadorMapper jogadorMapper) {
        this.jogadorService = jogadorService;
        this.jogadorMapper = jogadorMapper;
    }

    @GetMapping
    public List<JogadorDTO> listarTodos() {
        return jogadorMapper.toDTOList(jogadorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorDTO> buscarPorId(
            @PathVariable
            UUID id){

        return jogadorService.buscarPorId(id)
                .map(jogadorMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JogadorDTO> criar(

            @RequestBody
            @Valid
            JogadorDTO dto){

        Jogador jogador = jogadorMapper.toEntity(dto);
        jogador = jogadorService.salvar(jogador);
        return ResponseEntity.ok(jogadorMapper.toDTO(jogador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogadorDTO> atualizar(

            @PathVariable
            UUID id,

            @RequestBody
            @Valid
            JogadorDTO dto){

        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(id);

        if (jogadorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Jogador jogador = jogadorOptional.get();

        jogador.setNome(dto.nome());
        jogador.setNumeroColete(dto.numeroColete());
        jogador.setGols(dto.gols());
        jogador.setAssistencias(dto.assistencias());
        jogador.setCartoesAmarelos(dto.cartoesAmarelos());
        jogador.setCartoesVermelhos(dto.cartoesVermelhos());

        jogador = jogadorService.salvar(jogador);

        return ResponseEntity.ok(jogadorMapper.toDTO(jogador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(

            @PathVariable
            UUID id){
        jogadorService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
