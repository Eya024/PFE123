package tn.stb.pfe.services.impl;


import java.time.LocalTime;

import org.springframework.stereotype.Service;

import tn.stb.pfe.models.DayPlan;
import tn.stb.pfe.models.TimePeroid;
import tn.stb.pfe.models.WorkingPlan;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.repositories.WorkingPlanRepository;
import tn.stb.pfe.repositories.user.UserRepository;
import tn.stb.pfe.services.WorkingPlanService;


@Service
public class WorkingPlanServiceImpl implements WorkingPlanService {

    private final WorkingPlanRepository workingPlanRepository;
    private final UserRepository providerRepository;

    public WorkingPlanServiceImpl(WorkingPlanRepository workingPlanRepository, UserRepository providRepository) {
        this.workingPlanRepository = workingPlanRepository;
        this.providerRepository = providRepository;
    }



    public void generateAndSaveWorkingPlanForProvider(Provider provider) {
        // Generate the working plan
        WorkingPlan workingPlan = new WorkingPlan();

        // Create DayPlan instances for each day of the week
        DayPlan mondayPlan = new DayPlan();
        DayPlan tuesdayPlan = new DayPlan();
        DayPlan wednesdayPlan = new DayPlan();
        DayPlan thursdayPlan = new DayPlan();
        DayPlan fridayPlan = new DayPlan();
        DayPlan saturdayPlan = new DayPlan();
        DayPlan sundayPlan = new DayPlan();

        // Set the working hours for each DayPlan
        mondayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("08:00"), LocalTime.parse("17:00")));
        tuesdayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("09:00"), LocalTime.parse("18:00")));
        wednesdayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("08:30"), LocalTime.parse("16:30")));
        thursdayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("09:30"), LocalTime.parse("17:30")));
        fridayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("08:00"), LocalTime.parse("16:00")));
        saturdayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("10:00"), LocalTime.parse("15:00")));
        sundayPlan.setWorkingHours(new TimePeroid(LocalTime.parse("12:00"), LocalTime.parse("18:00")));

        // Set the DayPlan instances in the WorkingPlan
        workingPlan.setMonday(mondayPlan);
        workingPlan.setTuesday(tuesdayPlan);
        workingPlan.setWednesday(wednesdayPlan);
        workingPlan.setThursday(thursdayPlan);
        workingPlan.setFriday(fridayPlan);
        workingPlan.setSaturday(saturdayPlan);
        workingPlan.setSunday(sundayPlan);

        // Save the working plan to the database using the workingPlanRepository
        workingPlanRepository.save(workingPlan);
        providerRepository.save(provider);
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
