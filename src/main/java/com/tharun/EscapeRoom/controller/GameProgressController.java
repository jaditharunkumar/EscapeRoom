package com.tharun.EscapeRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.EscapeRoom.model.GameProgress;
import com.tharun.EscapeRoom.service.GameProgressService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/game-progress")
public class GameProgressController {

    @Autowired
    private GameProgressService gameProgressService;

    @PostMapping("/save")
    public GameProgress saveGameProgress(@RequestBody GameProgress gameProgress) {
        return gameProgressService.saveGameProgress(gameProgress);
    }
}