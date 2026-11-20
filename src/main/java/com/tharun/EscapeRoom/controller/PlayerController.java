package com.tharun.EscapeRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.EscapeRoom.model.Player;
import com.tharun.EscapeRoom.service.PlayerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/register")
    public Player registerPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }
}