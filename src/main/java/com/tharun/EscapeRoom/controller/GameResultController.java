package com.tharun.EscapeRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.EscapeRoom.model.GameResult;
import com.tharun.EscapeRoom.service.GameResultService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/game-result")
public class GameResultController {

    @Autowired
    private GameResultService gameResultService;

    // Save game result
    @PostMapping("/save")
    public GameResult saveGameResult(@RequestBody GameResult gameResult) {
        return gameResultService.saveGameResult(gameResult);
    }

    // Get all game history
    @GetMapping("/history")
    public List<GameResult> getGameHistory() {
        return gameResultService.getAllGameResults();
    }
}