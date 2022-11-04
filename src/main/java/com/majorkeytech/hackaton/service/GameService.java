package com.majorkeytech.hackaton.service;

import com.majorkeytech.hackaton.model.Game;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.majorkeytech.hackaton.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class GameService {
	private final GameRepository gameRepository;
	
	public Game getGameById(long gameId) {
		return gameRepository.getById(gameId);
	}
}
