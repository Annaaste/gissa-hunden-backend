package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.entity.Highscore;
import com.annapanna.gissahundenbackend.repository.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighscoreServiceImpl implements HighscoreService {
    @Autowired
    private HighscoreRepository highscoreRepository;



    @Override
    public List<Highscore> getTopHighscores() {
        return highscoreRepository.findTop5ByOrderByScoreDesc();
    }

    @Override
    public List<Highscore> getAllHighscores() {
        return highscoreRepository.findAll();
    }

    @Override
    public Highscore saveHighscore(String playerName, int score) {
        Highscore highscore = new Highscore();
        highscore.setPlayerName(playerName);
        highscore.setScore(score);
        return highscoreRepository.save(highscore);
    }
}
