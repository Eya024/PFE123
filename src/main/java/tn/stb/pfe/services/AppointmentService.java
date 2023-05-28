package tn.stb.pfe.services;

import tn.stb.pfe.models.Appointment;
import tn.stb.pfe.models.ChatMessage;
import tn.stb.pfe.models.TimePeroid;
import tn.stb.pfe.models.Work;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    Appointment refuseAppointment(int appointmentId);
    Appointment acceptAppointment(int appointmentId);
    Appointment cancelAppointment(int appointmentId);
    Appointment bookAppointment(int workId, int customerId, LocalDateTime start) ;
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentByCustomerId(int customerId);
    List<Appointment> getAppointmentByProviderId(int providerId);
    void updateAppointment(Appointment appointment);


/* 
    void createNewAppointment(int workId, int providerId, int customerId, LocalDateTime start);


    void updateUserAppointmentsStatuses(int userId);

    void updateAllAppointmentsStatuses();

    void updateAppointmentsStatusesWithExpiredExchangeRequest();

    void deleteAppointmentById(int appointmentId);

    Appointment getAppointmentByIdWithAuthorization(int id);





    List<Appointment> getAppointmentsByProviderAtDay(int providerId, LocalDate day);

    List<Appointment> getAppointmentsByCustomerAtDay(int providerId, LocalDate day);

    List<Appointment> getConfirmedAppointmentsByCustomerId(int customerId);

    List<Appointment> getCanceledAppointmentsByCustomerIdForCurrentMonth(int userId);

    List<TimePeroid> getAvailableHours(int providerId, int customerId, int workId, LocalDate date);

    List<TimePeroid> calculateAvailableHours(List<TimePeroid> availableTimePeroids, Work work);

    List<TimePeroid> excludeAppointmentsFromTimePeroids(List<TimePeroid> peroids, List<Appointment> appointments);

    String getCancelNotAllowedReason(int userId, int appointmentId);

    void cancelUserAppointmentById(int appointmentId, int userId);

    boolean isCustomerAllowedToRejectAppointment(int customerId, int appointmentId);

    boolean requestAppointmentRejection(int appointmentId, int customerId);

    boolean requestAppointmentRejection(String token);

    boolean isProviderAllowedToAcceptRejection(int providerId, int appointmentId);

    boolean acceptRejection(int appointmentId, int providerId);

    boolean acceptRejection(String token);

    void addMessageToAppointmentChat(int appointmentId, int authorId, ChatMessage chatMessage);

    int getNumberOfCanceledAppointmentsForUser(int userId);

    int getNumberOfScheduledAppointmentsForUser(int userId);

    boolean isAvailable(int workId, int providerId, int customerId, LocalDateTime start);*/


}
