package com.majorkeytech.hackaton.controller;

import org.springframework.web.bind.annotation.RestController;

import com.majorkeytech.hackaton.service.PredictionService;
import com.majorkeytech.hackaton.service.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TeamController {
	private final TeamService teamService;
}
