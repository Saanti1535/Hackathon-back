package com.majorkeytech.hackaton.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.majorkeytech.hackaton.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class GameService {
	private final GameRepository gameRepository;
	
	
}
