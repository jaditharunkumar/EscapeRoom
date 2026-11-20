package com.tharun.EscapeRoom.model;

public class GameResponse {

    private String message;
    private GameProgress gameProgress;

    public GameResponse() {
    }

    public GameResponse(String message, GameProgress gameProgress) {
        this.message = message;
        this.gameProgress = gameProgress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GameProgress getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(GameProgress gameProgress) {
        this.gameProgress = gameProgress;
    }
}