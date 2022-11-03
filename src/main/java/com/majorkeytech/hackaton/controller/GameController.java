package com.majorkeytech.hackaton.controller;

import org.springframework.web.bind.annotation.RestController;

import com.majorkeytech.hackaton.service.GameService;
import com.majorkeytech.hackaton.service.PredictionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GameController {
	private final GameService gameService;
}
