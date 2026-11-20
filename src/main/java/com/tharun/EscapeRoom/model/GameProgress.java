package com.tharun.EscapeRoom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GameProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int progressId;

    private int playerId;

    private int roomId;
    
    private int resultId;

    private boolean hasClue;

    private boolean drawerUnlocked;

    private boolean hasKey;

    @Column(name = "game_escaped")
    private boolean escaped;

    private int attempts;

    public GameProgress() {
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isHasClue() {
        return hasClue;
    }

    public void setHasClue(boolean hasClue) {
        this.hasClue = hasClue;
    }

    public boolean isDrawerUnlocked() {
        return drawerUnlocked;
    }

    public void setDrawerUnlocked(boolean drawerUnlocked) {
        this.drawerUnlocked = drawerUnlocked;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isEscaped() {
        return escaped;
    }

    public void setEscaped(boolean escaped) {
        this.escaped = escaped;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }
}