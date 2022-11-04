package com.majorkeytech.hackaton.service;

import com.majorkeytech.hackaton.model.Game;
import com.majorkeytech.hackaton.model.Prediction;
import com.majorkeytech.hackaton.model.PostPredictionRequest;
import com.majorkeytech.hackaton.model.User;
import com.majorkeytech.hackaton.repository.PredictionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PredictionService {
	private final PredictionRepository predictionRepository;
	private final GameService gameService;
	private final UserService userService;

	public List<Prediction> getPredictionsByUserId(Long userId) {
		return predictionRepository.getPredictionsByUserId(userId);
	}

	public void postPrediction(PostPredictionRequest postPredictionRequest) {
		Game game = gameService.getGameById(postPredictionRequest.getGameId());
		User user = userService.getUserById(postPredictionRequest.getUserId());
		Prediction prediction = Prediction.builder()
				.predictedWinnerTeam(postPredictionRequest.getPredictedWinnerTeam().toString())
				.game(game)
				.user(user)
				.predictionTime(LocalDateTime.now())
				.build();

		predictionRepository.save(prediction);
	}
}
