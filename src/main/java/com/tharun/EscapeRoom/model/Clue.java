package com.tharun.EscapeRoom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clueId;

    private String clueName;

    private String clueText;

    public Clue() {
    }

    public int getClueId() {
        return clueId;
    }

    public void setClueId(int clueId) {
        this.clueId = clueId;
    }

    public String getClueName() {
        return clueName;
    }

    public void setClueName(String clueName) {
        this.clueName = clueName;
    }

    public String getClueText() {
        return clueText;
    }

    public void setClueText(String clueText) {
        this.clueText = clueText;
    }
}