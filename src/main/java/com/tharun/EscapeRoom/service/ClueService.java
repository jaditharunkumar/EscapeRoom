package com.tharun.EscapeRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.EscapeRoom.model.Clue;
import com.tharun.EscapeRoom.repository.ClueRepository;

@Service
public class ClueService {

    @Autowired
    private ClueRepository clueRepository;

    public Clue saveClue(Clue clue) {
        return clueRepository.save(clue);
    }
}