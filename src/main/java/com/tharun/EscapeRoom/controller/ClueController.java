package com.tharun.EscapeRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.EscapeRoom.model.Clue;
import com.tharun.EscapeRoom.service.ClueService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clue")
public class ClueController {

    @Autowired
    private ClueService clueService;

    @PostMapping("/create")
    public Clue createClue(@RequestBody Clue clue) {
        return clueService.saveClue(clue);
    }
}