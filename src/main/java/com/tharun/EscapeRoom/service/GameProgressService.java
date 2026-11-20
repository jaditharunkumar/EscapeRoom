package com.tharun.EscapeRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.EscapeRoom.model.GameProgress;
import com.tharun.EscapeRoom.repository.GameProgressRepository;

@Service
public class GameProgressService {

    @Autowired
    private GameProgressRepository gameProgressRepository;

    public GameProgress saveGameProgress(GameProgress gameProgress) {

        if (gameProgress.getProgressId() == 0) {

            GameProgress existingProgress =
                    gameProgressRepository
                            .findByPlayerId(gameProgress.getPlayerId())
                            .orElse(null);

            if (existingProgress != null) {

                gameProgress.setProgressId(
                        existingProgress.getProgressId()
                );
            }
        }

        return gameProgressRepository.save(gameProgress);
    }
}