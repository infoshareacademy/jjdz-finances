package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.PlanCreationDto;

//@Local
public interface PlanDao {
//    int create(PlanCreationDto plan);
//    PlanViewDto read(int id);
//    void update(int id, PlanCreationDto plan);
//    void delete(int id);
    PlanCreationDto createOrUpdate (PlanCreationDto plan);
//    (ZonedDateTime actionTime, Asset asset, PlanCreationDto.PlanActionType planActionType, int quantity);
    void delete (Long id);
    PlanCreationDto find (Long id);

}
