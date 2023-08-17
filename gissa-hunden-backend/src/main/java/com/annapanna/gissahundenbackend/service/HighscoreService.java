package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Highscore;

import java.util.List;

public interface HighscoreService {
        List<Highscore> getTopHighscores();
        Highscore saveHighscore(String playerName, int score);

        List<Highscore> getAllHighscores();
}
