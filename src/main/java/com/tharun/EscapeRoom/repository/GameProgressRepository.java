package com.tharun.EscapeRoom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tharun.EscapeRoom.model.GameProgress;

public interface GameProgressRepository extends JpaRepository<GameProgress, Integer> {

    Optional<GameProgress> findByPlayerId(int playerId);

}