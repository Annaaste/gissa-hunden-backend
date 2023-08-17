package com.annapanna.gissahundenbackend.controller;

import com.annapanna.gissahundenbackend.entity.Highscore;
import com.annapanna.gissahundenbackend.service.HighscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController

public class HighscoreController {

    @Autowired
    private HighscoreService highscoreService;

    @GetMapping("/highscores/top")
    public List<Highscore> getTopHighscores() {
        return highscoreService.getTopHighscores();
    }

    @GetMapping("/highscores/all")
    public List<Highscore> getAllHighscores() {
        return highscoreService.getAllHighscores();
    }

    @PostMapping("/highscores")
    public ResponseEntity<Highscore> saveHighscore(@RequestBody Highscore highscore) {
        Highscore savedHighscore = highscoreService.saveHighscore(highscore.getPlayerName(), highscore.getScore());
        return ResponseEntity.ok(savedHighscore);
    }
}
