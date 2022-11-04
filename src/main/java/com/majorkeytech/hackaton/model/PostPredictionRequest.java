package com.majorkeytech.hackaton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPredictionRequest {
    private long userId;
    private long gameId;
    private GameResult predictedWinnerTeam;

}
