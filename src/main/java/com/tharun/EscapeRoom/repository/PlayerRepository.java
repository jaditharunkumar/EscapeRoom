package com.tharun.EscapeRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tharun.EscapeRoom.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}