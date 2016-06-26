package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.PlanCreationDto;

//@Local
public interface PlanDao {
//    int create(PlanCreationDto plan);
//    void update(int id, PlanCreationDto plan);
//    void delete(int id);
    PlanCreationDto createOrUpdate (PlanCreationDto plan);
//    (ZonedDateTime actionTime, Asset asset, PlanCreationDto.PlanActionType planActionType, int quantity);
    void delete (Long id);
    PlanCreationDto find (Long id);

}
