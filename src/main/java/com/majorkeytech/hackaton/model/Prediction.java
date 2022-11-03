package com.majorkeytech.hackaton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prediction {
    @Id
    @GeneratedValue
    Long id;
    Long idUser;
    Long idMatch;
    Long idWinnerTeam;
    LocalDateTime predictionTime;
    LocalDateTime lastUpdated;
}
