package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.PlanCreationDto;
import com.infoshareacademy.finances.model.PlanViewDto;
import com.sun.javafx.collections.MappingChange;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class InMemoryPlanDao implements PlanDao {

    private final Map<Integer, PlanViewDto> plansById = new HashMap<>();
    private int nextId = 0;

    @Override
    public int create(PlanCreationDto plan) {
        PlanViewDto planViewDto = new PlanViewDto(plan.getSellTime(), plan.getBuyTime(), plan.getAsset(), nextId);
        nextId++;
        plansById.put(nextId, planViewDto);
        return planViewDto.getId();
    }

    @Override
    public PlanViewDto read(int id) {
        return plansById.get(id);
    }

    @Override
    public void update(int id, PlanCreationDto plan) {
        PlanViewDto temp = plansById.get(id);
        PlanViewDto outputPlan = new PlanViewDto(temp.getSellTime(), temp.getBuyTime(), plan.getAsset(), id);
        plansById.put(id, outputPlan);
    }

    @Override
    public void delete(int id) {
        plansById.remove(id);

    }



}
