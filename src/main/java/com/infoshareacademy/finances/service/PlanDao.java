package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.PlanCreationDto;
import com.infoshareacademy.finances.model.PlanViewDto;

public interface PlanDao {
    int create(PlanCreationDto plan);
    PlanViewDto read(int id);
    void update(int id, PlanCreationDto plan);
    void delete(int id);
}
