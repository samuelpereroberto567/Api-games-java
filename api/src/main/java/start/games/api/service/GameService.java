package com.example.gamelibrary.service;

import com.example.gamelibrary.model.Game;
import com.example.gamelibrary.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço que contém a lógica de negócios para gerenciar jogos
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Injeção de dependência do repositório de jogos

    // Retorna a lista de todos os jogos
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    // Retorna um jogo pelo seu ID
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    // Salva um novo jogo ou atualiza um existente
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    // Deleta um jogo pelo seu ID
    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }
}
