package com.soccerapp.service;

import com.soccerapp.model.Jogador;
import com.soccerapp.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId(UUID id) {
        return jogadorRepository.findById(id);
    }

    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public void deletar(UUID id) {
        jogadorRepository.deleteById(id);
    }
}
