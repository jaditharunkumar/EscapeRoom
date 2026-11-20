package com.tharun.EscapeRoom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tharun.EscapeRoom.model.GameResult;

public interface GameResultRepository extends JpaRepository<GameResult, Integer> {

    Optional<GameResult> findFirstByPlayerIdOrderByResultIdDesc(int playerId);
}