package com.majorkeytech.hackaton.controller;

import com.majorkeytech.hackaton.model.Prediction;
import com.majorkeytech.hackaton.model.PostPredictionRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.majorkeytech.hackaton.service.PredictionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PredictionController {
	final private PredictionService predictionService;

	@GetMapping("/api/1.0/predictions/user/{userId}")
	public List<Prediction> getPredictions(@PathVariable long userId) {
		return predictionService.getPredictionsByUserId(userId);
	}

	@PostMapping("/api/1.0/predictions")
	public void postPrediction(@RequestBody PostPredictionRequest postPredictionRequest) {
		predictionService.postPrediction(postPredictionRequest);
	}
}
