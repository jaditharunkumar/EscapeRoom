package com.tharun.EscapeRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.EscapeRoom.model.Room;
import com.tharun.EscapeRoom.service.RoomService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }
}