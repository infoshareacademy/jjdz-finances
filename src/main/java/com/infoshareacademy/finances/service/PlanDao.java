package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.PlanCreationDto;
import com.infoshareacademy.finances.model.PlanViewDto;

import javax.ejb.Local;

@Local
public interface PlanDao {
//    int create(PlanCreationDto plan);
//    PlanViewDto read(int id);
//    void update(int id, PlanCreationDto plan);
//    void delete(int id);
    PlanCreationDto createOrUpdate (PlanCreationDto plan);
    void delete (Long id);
    PlanCreationDto find (Long id);

}
