package com.example.gamelibrary.controller;

import com.example.gamelibrary.model.Game;
import com.example.gamelibrary.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador que define os endpoints da API para gerenciar jogos
@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService; // Injeção de dependência do serviço de jogos

    // Endpoint para listar todos os jogos
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.findAll();
    }

    // Endpoint para obter detalhes de um jogo específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        return gameService.findById(id)
                .map(game -> ResponseEntity.ok().body(game))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para adicionar um novo jogo
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.save(game);
    }

    // Endpoint para atualizar um jogo existente pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game gameDetails) {
        return gameService.findById(id)
                .map(game -> {
                    game.setTitle(gameDetails.getTitle());
                    game.setGenre(gameDetails.getGenre());
                    game.setDeveloper(gameDetails.getDeveloper());
                    game.setPublisher(gameDetails.getPublisher());
                    Game updatedGame = gameService.save(game);
                    return ResponseEntity.ok().body(updatedGame);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para excluir um jogo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        return gameService.findById(id)
                .map(game -> {
                    gameService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}