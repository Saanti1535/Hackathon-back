package com.majorkeytech.hackaton.repository;

import com.majorkeytech.hackaton.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {
    List<Prediction> getPredictionsByUserId(long userId);
}
