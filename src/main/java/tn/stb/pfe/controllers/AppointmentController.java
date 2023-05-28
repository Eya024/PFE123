package tn.stb.pfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.stb.pfe.models.Appointment;
import tn.stb.pfe.services.AppointmentService;
import tn.stb.pfe.services.ExchangeService;
import tn.stb.pfe.services.UserService;
import tn.stb.pfe.services.WorkService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/appointments")
public class AppointmentController {



    @Autowired
    private final AppointmentService appointmentService;
    @Autowired
    private final WorkService workService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final ExchangeService exchangeService;


    public AppointmentController(WorkService workService, UserService userService, AppointmentService appointmentService, ExchangeService exchangeService) {
        this.workService = workService;
        this.userService = userService;
        this.appointmentService = appointmentService;
        this.exchangeService = exchangeService;
    }


    /* Book appointment */
    //customer
    @ResponseBody
    @PostMapping("/book/{workId}/{customerId}/{start}")
    public void processAppointmentBookingRequest(@PathVariable("workId") int workId, @PathVariable("customerId") int customerId, @PathVariable("start") String start) {
        // convert string to localdatetime 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(start, formatter);
         appointmentService.bookAppointment(workId, customerId, time);
    }


    /* Get Appointments */
    //admin
    @ResponseBody
    @GetMapping("/all")
    public List<Appointment> showAllAppointments() {
         return appointmentService.getAllAppointments();
    }

    //provider 
    @ResponseBody
    @GetMapping("/provider/{id}")
    public List<Appointment> showProviderAppointments(@PathVariable("id") int providerId) {
         return appointmentService.getAppointmentByProviderId(providerId);
    }
    
    //customer
    @ResponseBody
    @GetMapping("/customer/{id}")
    public List<Appointment> showCustomerAppointments(@PathVariable("id") int customerId) {
         return appointmentService.getAppointmentByCustomerId(customerId);
    }


    /** Get apointment by id */
    @ResponseBody
    @GetMapping("/{id}")
    public Appointment showAppointmentDetail(@PathVariable("id") int appointmentId) {
          return appointmentService.getAppointmentById(appointmentId);
    }

    /* Refuse appointment */
    //provider
    @ResponseBody
    @PostMapping("/refuse")
    public void processAppointmentRefusalRequest(@RequestParam("appointmentId") int appointmentId) {
         appointmentService.refuseAppointment(appointmentId);
    }

    /* Accept appointment */
    //provider
    @ResponseBody
    @PostMapping("/accept")
    public void processAppointmentAcceptanceRequest(@RequestParam("appointmentId") int appointmentId) {
         appointmentService.acceptAppointment(appointmentId);
    }

    /* Cancel appointment */
    //customer
    @ResponseBody
    @PostMapping("/cancel")
    public void processAppointmentCancellationRequest(@RequestParam("appointmentId") int appointmentId) {
         appointmentService.cancelAppointment(appointmentId);
    }

    
/* 
    
    @ResponseBody
    @PostMapping("/reject")
    public void processAppointmentRejectionRequest(@RequestParam("appointmentId") int appointmentId, @RequestParam("customerId") int customerId) {
         appointmentService.requestAppointmentRejection(appointmentId, customerId);
    }

    @ResponseBody
    @PostMapping("/acceptRejection")
    public Boolean acceptAppointmentRejectionRequest(@RequestParam("appointmentId") int appointmentId, @RequestParam("appointmentId") int providerId) {
        return appointmentService.acceptRejection(appointmentId, providerId);
    }

    @ResponseBody
    @GetMapping("/new/{providerId}/{workId}/{customerId}/{dateTime}")
    public Model showNewAppointmentSummary(@PathVariable("workId") int workId, @PathVariable("providerId") int providerId, @PathVariable("dateTime") String start, @PathVariable("customerId") int customerId, Model model) {
        if (appointmentService.isAvailable(workId, providerId, customerId, LocalDateTime.parse(start))) {
            model.addAttribute("work", workService.getWorkById(workId));
            model.addAttribute("provider", userService.getProviderById(providerId).getFirstName() + " " + userService.getProviderById(providerId).getLastName());
            model.addAttribute(providerId);
            model.addAttribute("start", LocalDateTime.parse(start));
            model.addAttribute("end", LocalDateTime.parse(start).plusMinutes(workService.getWorkById(workId).getDuration()));
            return model;
        } else {
            return null;
        }
    }
    
    */
    /* 
    @GetMapping("/reject")
    public String processAppointmentRejectionRequest(@RequestParam("token") String token, Model model) {
        boolean result = appointmentService.requestAppointmentRejection(token);
        model.addAttribute(result);
        model.addAttribute("type", "request");
        return REJECTION_CONFIRMATION_VIEW;
    }*/

    /* 
    @GetMapping("/acceptRejection")
    public String acceptAppointmentRejectionRequest(@RequestParam("token") String token, Model model) {
        boolean result = appointmentService.acceptRejection(token);
        model.addAttribute(result);
        model.addAttribute("type", "accept");
        return REJECTION_CONFIRMATION_VIEW;
    }*/

    /* 
    @PostMapping("/messages/new")
    public String addNewChatMessage(@ModelAttribute("chatMessage") ChatMessage chatMessage, @RequestParam("appointmentId") int appointmentId, @AuthenticationPrincipal CustomUserDetails currentUser) {
        int authorId = currentUser.getId();
        appointmentService.addMessageToAppointmentChat(appointmentId, authorId, chatMessage);
        return "redirect:/appointments/" + appointmentId;
    }

    @GetMapping("/new")
    public String selectProvider(Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
        if (currentUser.hasRole("ROLE_CUSTOMER_RETAIL")) {
            model.addAttribute("providers", userService.getProvidersWithRetailWorks());
        } else if (currentUser.hasRole("ROLE_CUSTOMER_CORPORATE")) {
            model.addAttribute("providers", userService.getProvidersWithCorporateWorks());
        }
        return "appointments/selectProvider";
    }

    @GetMapping("/new/{providerId}")
    public String selectService(@PathVariable("providerId") int providerId, Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
        if (currentUser.hasRole("ROLE_CUSTOMER_RETAIL")) {
            model.addAttribute("works", workService.getWorksForRetailCustomerByProviderId(providerId));
        } else if (currentUser.hasRole("ROLE_CUSTOMER_CORPORATE")) {
            model.addAttribute("works", workService.getWorksForCorporateCustomerByProviderId(providerId));
        }
        model.addAttribute(providerId);
        return "appointments/selectService";
    }

    @GetMapping("/new/{providerId}/{workId}")
    public String selectDate(@PathVariable("workId") int workId, @PathVariable("providerId") int providerId, Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
        if (workService.isWorkForCustomer(workId, currentUser.getId())) {
            model.addAttribute(providerId);
            model.addAttribute("workId", workId);
            return "appointments/selectDate";
        } else {
            return "redirect:/appointments/new";
        }

    }

    @GetMapping("/new/{providerId}/{workId}/{dateTime}")
    public String showNewAppointmentSummary(@PathVariable("workId") int workId, @PathVariable("providerId") int providerId, @PathVariable("dateTime") String start, Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
        if (appointmentService.isAvailable(workId, providerId, currentUser.getId(), LocalDateTime.parse(start))) {
            model.addAttribute("work", workService.getWorkById(workId));
            model.addAttribute("provider", userService.getProviderById(providerId).getFirstName() + " " + userService.getProviderById(providerId).getLastName());
            model.addAttribute(providerId);
            model.addAttribute("start", LocalDateTime.parse(start));
            model.addAttribute("end", LocalDateTime.parse(start).plusMinutes(workService.getWorkById(workId).getDuration()));
            return "appointments/newAppointmentSummary";
        } else {
            return "redirect:/appointments/new";
        }
    }

    @PostMapping("/new")
    public String bookAppointment(@RequestParam("workId") int workId, @RequestParam("providerId") int providerId, @RequestParam("start") String start, @AuthenticationPrincipal CustomUserDetails currentUser) {
        appointmentService.createNewAppointment(workId, providerId, currentUser.getId(), LocalDateTime.parse(start));
        return "redirect:/appointments/all";
    }

    @PostMapping("/cancel")
    public String cancelAppointment(@RequestParam("appointmentId") int appointmentId, @AuthenticationPrincipal CustomUserDetails currentUser) {
        appointmentService.cancelUserAppointmentById(appointmentId, currentUser.getId());
        return "redirect:/appointments/all";
    }


    public static String formatDuration(Duration duration) {
        long s = duration.getSeconds();
        return String.format("%dh%02dm", s / 3600, (s % 3600) / 60);
    }
*/
}
