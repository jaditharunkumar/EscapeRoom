package com.tharun.EscapeRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.EscapeRoom.model.Room;
import com.tharun.EscapeRoom.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
}