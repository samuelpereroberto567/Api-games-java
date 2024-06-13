package com.example.gamelibrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// A entidade que representa um jogo na biblioteca
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id;
    private String title; // Título do jogo
    private String genre; // Gênero do jogo
    private String developer; // Desenvolvedor do jogo
    private String publisher; // Publicadora do jogo

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
