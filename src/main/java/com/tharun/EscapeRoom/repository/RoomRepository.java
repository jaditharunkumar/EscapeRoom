package com.tharun.EscapeRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tharun.EscapeRoom.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}