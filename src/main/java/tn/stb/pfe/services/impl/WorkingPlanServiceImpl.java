package tn.stb.pfe.services.impl;


import org.springframework.stereotype.Service;
import tn.stb.pfe.models.TimePeroid;
import tn.stb.pfe.models.WorkingPlan;
import tn.stb.pfe.repositories.WorkingPlanRepository;
import tn.stb.pfe.services.WorkingPlanService;


@Service
public class WorkingPlanServiceImpl implements WorkingPlanService {

    private final WorkingPlanRepository workingPlanRepository;

    public WorkingPlanServiceImpl(WorkingPlanRepository workingPlanRepository) {
        this.workingPlanRepository = workingPlanRepository;
    }

    @Override
    public void updateWorkingPlan(WorkingPlan updateData) {
        WorkingPlan workingPlan = workingPlanRepository.getOne(updateData.getId());
        workingPlan.getMonday().setWorkingHours(updateData.getMonday().getWorkingHours());
        workingPlan.getTuesday().setWorkingHours(updateData.getTuesday().getWorkingHours());
        workingPlan.getWednesday().setWorkingHours(updateData.getWednesday().getWorkingHours());
        workingPlan.getThursday().setWorkingHours(updateData.getThursday().getWorkingHours());
        workingPlan.getFriday().setWorkingHours(updateData.getFriday().getWorkingHours());
        workingPlan.getSaturday().setWorkingHours(updateData.getSaturday().getWorkingHours());
        workingPlan.getSunday().setWorkingHours(updateData.getSunday().getWorkingHours());
        workingPlanRepository.save(workingPlan);
    }


    @Override
    public void addBreakToWorkingPlan(TimePeroid breakToAdd, int planId, String dayOfWeek) {
        WorkingPlan workingPlan = workingPlanRepository.getOne(planId);
        workingPlan.getDay(dayOfWeek).getBreaks().add(breakToAdd);
        workingPlanRepository.save(workingPlan);
    }

    @Override
    public void deleteBreakFromWorkingPlan(TimePeroid breakToDelete, int planId, String dayOfWeek) {
        WorkingPlan workingPlan = workingPlanRepository.getOne(planId);
        workingPlan.getDay(dayOfWeek).getBreaks().remove(breakToDelete);
        workingPlanRepository.save(workingPlan);
    }


    @Override
    public WorkingPlan getWorkingPlanByProviderId(int providerId) {
        return workingPlanRepository.getWorkingPlanByProviderId(providerId);
    }


}
