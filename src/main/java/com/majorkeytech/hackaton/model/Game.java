package com.majorkeytech.hackaton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "team_home_id")
    Team teamHome;

    @ManyToOne
    @JoinColumn(name = "team_away_id")
    Team teamAway;


    LocalDateTime gameSchedule;
    boolean finished;
}
