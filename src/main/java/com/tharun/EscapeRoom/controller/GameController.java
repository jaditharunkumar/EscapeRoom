package com.tharun.EscapeRoom.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.EscapeRoom.model.GameProgress;
import com.tharun.EscapeRoom.model.GameResponse;
import com.tharun.EscapeRoom.model.GameResult;
import com.tharun.EscapeRoom.service.GameProgressService;
import com.tharun.EscapeRoom.service.GameResultService;
import com.tharun.EscapeRoom.service.GameService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameProgressService gameProgressService;

    @Autowired
    private GameResultService gameResultService;


    // =========================================================
    // CHECK DOOR
    // =========================================================

    @PostMapping("/check-door")
    public GameResponse checkDoor(
            @RequestBody GameProgress gameProgress) {

        String message =
                gameService.checkDoor(gameProgress);

        GameProgress savedProgress =
                gameProgressService.saveGameProgress(gameProgress);


        // GAME SUCCESS

        if (savedProgress.isEscaped()) {

            GameResult gameResult =
                    gameResultService.getGameResult(
                            savedProgress.getResultId()
                    );

            if (gameResult != null) {

                gameResult.setCompletionTime(
                        LocalDateTime.now()
                );

                gameResult.setAttempts(
                        savedProgress.getAttempts()
                );

                gameResult.setGameStatus(
                        "SUCCESS"
                );

                gameResultService.saveGameResult(
                        gameResult
                );
            }
        }


        return new GameResponse(
                message,
                savedProgress
        );
    }


    // =========================================================
    // SEARCH ROOM
    // =========================================================

    @PostMapping("/search-room")
    public GameResponse searchRoom(
            @RequestBody GameProgress gameProgress,
            @RequestParam int searchChoice) {

        String message =
                gameService.searchRoom(
                        gameProgress,
                        searchChoice
                );

        GameProgress savedProgress =
                gameProgressService.saveGameProgress(
                        gameProgress
                );


        return new GameResponse(
                message,
                savedProgress
        );
    }


    // =========================================================
    // CHECK PAINTING
    // =========================================================

    @PostMapping("/check-painting")
    public GameResponse checkPainting(
            @RequestBody GameProgress gameProgress,
            @RequestParam String buttonChoice) {

        String message =
                gameService.checkPainting(
                        gameProgress,
                        buttonChoice
                );

        GameProgress savedProgress =
                gameProgressService.saveGameProgress(
                        gameProgress
                );


        return new GameResponse(
                message,
                savedProgress
        );
    }


    // =========================================================
    // OPEN DRAWER
    // =========================================================

    @PostMapping("/open-drawer")
    public GameResponse openDrawer(
            @RequestBody GameProgress gameProgress) {

        String message =
                gameService.openDrawer(
                        gameProgress
                );

        GameProgress savedProgress =
                gameProgressService.saveGameProgress(
                        gameProgress
                );


        return new GameResponse(
                message,
                savedProgress
        );
    }


    // =========================================================
    // EXIT GAME
    // =========================================================

    @PostMapping("/exit")
    public GameResponse exitGame(
            @RequestBody GameProgress gameProgress) {


        // Save current progress

        GameProgress savedProgress =
                gameProgressService.saveGameProgress(
                        gameProgress
                );


        // Find the exact game history record

        GameResult gameResult =
                gameResultService.getGameResult(
                        savedProgress.getResultId()
                );


        // Update game history

        if (gameResult != null) {

            gameResult.setCompletionTime(
                    LocalDateTime.now()
            );

            gameResult.setAttempts(
                    savedProgress.getAttempts()
            );

            gameResult.setGameStatus(
                    "EXITED"
            );

            gameResultService.saveGameResult(
                    gameResult
            );
        }


        return new GameResponse(
                "You left the game.",
                savedProgress
        );
    }

}