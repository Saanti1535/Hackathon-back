package com.majorkeytech.hackaton.controller;

import org.springframework.web.bind.annotation.RestController;

import com.majorkeytech.hackaton.service.PredictionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PredictionController {
	final private PredictionService predictionService;
	
}
