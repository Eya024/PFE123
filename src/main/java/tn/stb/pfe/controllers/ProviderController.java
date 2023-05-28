package tn.stb.pfe.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.services.AppointmentService;
import tn.stb.pfe.services.UserService;
import tn.stb.pfe.services.WorkService;
import tn.stb.pfe.services.WorkingPlanService;



@RestController
@RequestMapping("/providers")
public class ProviderController {

    private final UserService userService;
    private final WorkService workService;
    private final WorkingPlanService workingPlanService;
    private final AppointmentService appointmentService;

    public ProviderController(UserService userService, WorkService workService, WorkingPlanService workingPlanService, AppointmentService appointmentService) {
        this.userService = userService;
        this.workService = workService;
        this.workingPlanService = workingPlanService;
        this.appointmentService = appointmentService;
    }


    @GetMapping("/all")
    public List<Provider> showAllProviders(Model model) {
        return userService.getAllProviders();
    }

    @GetMapping("/{id}")
    public Model showProviderDetails(@PathVariable("id") int providerId, Model model) {
            model.addAttribute("user", userService.getProviderById(providerId));
            model.addAttribute("allWorks", workService.getAllWorks());
            //model.addAttribute("numberOfScheduledAppointments", appointmentService.getNumberOfScheduledAppointmentsForUser(providerId));
            //model.addAttribute("numberOfCanceledAppointments", appointmentService.getNumberOfCanceledAppointmentsForUser(providerId));
            return model;
        }
/* 
    @PostMapping("/update/profile")
    public String processProviderUpdate(ModelAttribute("user") UserForm userUpdateData, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            redirectAttributes.addFlashAttribute("user", userUpdateData);
            return "redirect:/providers/" + userUpdateData.getId();
        }
        userService.updateProviderProfile(userUpdateData);
        return "redirect:/providers/" + userUpdateData.getId();
    }

    @GetMapping("/new")
    public String showProviderRegistrationForm(Model model) {
        if (!model.containsAttribute("user")) model.addAttribute("user", new UserForm());
        model.addAttribute("account_type", "provider");
        model.addAttribute("registerAction", "/providers/new");
        model.addAttribute("allWorks", workService.getAllWorks());
        return "users/createUserForm";
    }

    @ResponseBody
    @PostMapping("/new")
    public Provider processProviderRegistrationForm(@RequestBody Provider provider ) {
        return userService.saveNewProvider(provider);
    }

    @PostMapping("/delete")
    public String processDeleteProviderRequest(@RequestParam("providerId") int providerId) {
        userService.deleteUserById(providerId);
        return "redirect:/providers/all";
    }

    @GetMapping("/availability")
    public String showProviderAvailability(Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
        model.addAttribute("plan", workingPlanService.getWorkingPlanByProviderId(currentUser.getId()));
        model.addAttribute("breakModel", new TimePeroid());
        return "users/showOrUpdateProviderAvailability";
    }

    @PostMapping("/availability")
    public String processProviderWorkingPlanUpdate(@ModelAttribute("plan") WorkingPlan plan) {
        workingPlanService.updateWorkingPlan(plan);
        return "redirect:/providers/availability";
    }

    @PostMapping("/availability/breakes/add")
    public String processProviderAddBreak(@ModelAttribute("breakModel") TimePeroid breakToAdd, @RequestParam("planId") int planId, @RequestParam("dayOfWeek") String dayOfWeek) {
        workingPlanService.addBreakToWorkingPlan(breakToAdd, planId, dayOfWeek);
        return "redirect:/providers/availability";
    }

    @PostMapping("/availability/breakes/delete")
    public String processProviderDeleteBreak(@ModelAttribute("breakModel") TimePeroid breakToDelete, @RequestParam("planId") int planId, @RequestParam("dayOfWeek") String dayOfWeek) {
        workingPlanService.deleteBreakFromWorkingPlan(breakToDelete, planId, dayOfWeek);
        return "redirect:/providers/availability";
    }

    @PostMapping("/update/password")
    public String processProviderPasswordUpate(@Valid @ModelAttribute("passwordChange") ChangePasswordForm passwordChange, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.passwordChange", bindingResult);
            redirectAttributes.addFlashAttribute("passwordChange", passwordChange);
            return "redirect:/providers/" + passwordChange.getId();
        }
        userService.updateUserPassword(passwordChange);
        return "redirect:/providers/" + passwordChange.getId();
    }
*/

}
