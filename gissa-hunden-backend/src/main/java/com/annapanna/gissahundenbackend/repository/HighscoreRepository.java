package com.annapanna.gissahundenbackend.repository;

import com.annapanna.gissahundenbackend.entity.Highscore;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface HighscoreRepository extends JpaRepository<Highscore, Long> {

    List<Highscore> findTop5ByOrderByScoreDesc();
}
