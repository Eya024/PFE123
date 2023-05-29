package tn.stb.pfe.services.impl;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.stb.pfe.models.Appointment;
import tn.stb.pfe.models.DayPlan;
import tn.stb.pfe.models.TimePeroid;
import tn.stb.pfe.models.WorkingPlan;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.repositories.AppointmentRepository;
import tn.stb.pfe.repositories.WorkingPlanRepository;
import tn.stb.pfe.repositories.user.UserRepository;
import tn.stb.pfe.services.WorkingPlanService;


@Service
public class WorkingPlanServiceImpl implements WorkingPlanService {

    private final WorkingPlanRepository workingPlanRepository;
    private final UserRepository providerRepository;
    private final AppointmentRepository appointmentRepository;

    public WorkingPlanServiceImpl(WorkingPlanRepository workingPlanRepository, UserRepository providRepository, AppointmentRepository appointmentRepository) {
        this.workingPlanRepository = workingPlanRepository;
        this.providerRepository = providRepository;
        this.appointmentRepository = appointmentRepository;
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

        // Generate appointments based on the working plan
        generateAppointments(workingPlan);

        // Save the working plan to the database using the workingPlanRepository
        workingPlanRepository.save(workingPlan);
        provider.setWorkingPlan(workingPlan);
        providerRepository.save(provider);
    }

    @Override
    public void updateWorkingPlan(Provider updateData) {

        WorkingPlan workingPlan = updateData.getWorkingPlan();
        System.out.println("*************************************");
        System.out.println(updateData);
        workingPlan.getMonday().setWorkingHours(workingPlan.getMonday().getWorkingHours());
        workingPlan.getTuesday().setWorkingHours(workingPlan.getTuesday().getWorkingHours());
        workingPlan.getWednesday().setWorkingHours(workingPlan.getWednesday().getWorkingHours());
        workingPlan.getThursday().setWorkingHours(workingPlan.getThursday().getWorkingHours());
        workingPlan.getFriday().setWorkingHours(workingPlan.getFriday().getWorkingHours());
        workingPlan.getSaturday().setWorkingHours(workingPlan.getSaturday().getWorkingHours());
        workingPlan.getSunday().setWorkingHours(workingPlan.getSunday().getWorkingHours());
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



    private List<Appointment> generateAppointments(WorkingPlan workingPlan) {
        List<Appointment> appointments = new ArrayList<>();
    
        // Get the working hours for each day of the week
        TimePeroid mondayWorkingHours = workingPlan.getMonday().getWorkingHours();
        TimePeroid tuesdayWorkingHours = workingPlan.getTuesday().getWorkingHours();
        TimePeroid wednesdayWorkingHours = workingPlan.getWednesday().getWorkingHours();
        TimePeroid thursdayWorkingHours = workingPlan.getThursday().getWorkingHours();
        TimePeroid fridayWorkingHours = workingPlan.getFriday().getWorkingHours();
        TimePeroid saturdayWorkingHours = workingPlan.getSaturday().getWorkingHours();
        TimePeroid sundayWorkingHours = workingPlan.getSunday().getWorkingHours();

        // Get the breaks for each day of the week
        List<TimePeroid> mondayBreaks = workingPlan.getMonday().getBreaks();
        List<TimePeroid> tuesdayBreaks = workingPlan.getTuesday().getBreaks();
        List<TimePeroid> wednesdayBreaks = workingPlan.getWednesday().getBreaks();
        List<TimePeroid> thursdayBreaks = workingPlan.getThursday().getBreaks();
        List<TimePeroid> fridayBreaks = workingPlan.getFriday().getBreaks();
        List<TimePeroid> saturdayBreaks = workingPlan.getSaturday().getBreaks();
        List<TimePeroid> sundayBreaks = workingPlan.getSunday().getBreaks();

        // Generate the appointments for each day of the week
        appointments.addAll(generateAppointmentsForDay(mondayWorkingHours, mondayBreaks, DayOfWeek.MONDAY));
        appointments.addAll(generateAppointmentsForDay(tuesdayWorkingHours, tuesdayBreaks, DayOfWeek.TUESDAY));
        appointments.addAll(generateAppointmentsForDay(wednesdayWorkingHours, wednesdayBreaks, DayOfWeek.WEDNESDAY));
        appointments.addAll(generateAppointmentsForDay(thursdayWorkingHours, thursdayBreaks, DayOfWeek.THURSDAY));
        appointments.addAll(generateAppointmentsForDay(fridayWorkingHours, fridayBreaks, DayOfWeek.FRIDAY));
        appointments.addAll(generateAppointmentsForDay(saturdayWorkingHours, saturdayBreaks, DayOfWeek.SATURDAY));
        appointments.addAll(generateAppointmentsForDay(sundayWorkingHours, sundayBreaks, DayOfWeek.SUNDAY));

        return appointments;
    }

    // generateAppointmentsForDay
    private List<Appointment> generateAppointmentsForDay(TimePeroid workingHours, List<TimePeroid> breaks, DayOfWeek dayOfWeek) {
        List<Appointment> appointments = new ArrayList<>();
        LocalTime startTime = workingHours.getStart();
        LocalTime endTime = workingHours.getEnd();

        // Generate the appointments for the day
        while (startTime.isBefore(endTime)) {
            // Check if the current time is in a break
            if (!isInBreak(startTime, breaks)) {
                // Create a new appointment
                Appointment appointment = new Appointment();

                // convert localtime to localdatetime
                LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now(), startTime);
                appointment.setStart(startDateTime);
                appointments.add(appointment);
                appointmentRepository.save(appointment);
            }
            startTime = startTime.plusMinutes(30);
        }
        return appointments;
    }



    private boolean isInBreak(LocalTime startTime, List<TimePeroid> breaks) {
        for (TimePeroid breakTime : breaks) {
            if (startTime.isAfter(breakTime.getStart()) && startTime.isBefore(breakTime.getEnd())) {
                return true;
            }
        }
        return false;
    }
    
    
}
