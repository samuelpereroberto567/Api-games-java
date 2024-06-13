package com.example.gamelibrary.repository;

import com.example.gamelibrary.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositório que fornece métodos para realizar operações CRUD na entidade Game
public interface GameRepository extends JpaRepository<Game, Long> {
}