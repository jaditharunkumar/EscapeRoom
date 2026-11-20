package com.tharun.EscapeRoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.EscapeRoom.model.GameResult;
import com.tharun.EscapeRoom.repository.GameResultRepository;

@Service
public class GameResultService {

    @Autowired
    private GameResultRepository gameResultRepository;

    // Save game result
    public GameResult saveGameResult(GameResult gameResult) {
        return gameResultRepository.save(gameResult);
    }

    // Get one game result by result ID
    public GameResult getGameResult(int resultId) {
        return gameResultRepository
                .findById(resultId)
                .orElse(null);
    }

    // Get all game history
    public List<GameResult> getAllGameResults() {
        return gameResultRepository.findAll();
    }
}