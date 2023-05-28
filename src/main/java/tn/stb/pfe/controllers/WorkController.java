package tn.stb.pfe.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import tn.stb.pfe.models.Work;
import tn.stb.pfe.models.user.User;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.repositories.WorkRepository;
import tn.stb.pfe.services.UserService;
import tn.stb.pfe.services.WorkService;


@RestController
@RequestMapping("/works")
public class WorkController {

    private final WorkService workService;
    private final UserService userService;

    public WorkController(WorkService workService, UserService userService) {
        this.workService = workService;
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/all")
    public List<Work> showAllWorks() {
        return workService.getAllWorks();
    }

    @ResponseBody
    @GetMapping("/{workId}")
    public Work showFormForUpdateWork(@PathVariable("workId") int workId) {
         workService.getWorkById(workId);
        return workService.getWorkById(workId);
    }

    @PostMapping("/new")
    public void saveWork(@RequestBody Work works, @RequestParam("providerIds") List<User> providerIds ) {
        works.setProviders(providerIds);
        workService.createNewWork(works);
    }
    

    @ResponseBody
    @PostMapping("/delete")
    public void deleteWork(@RequestParam("workId") int workId) {
        workService.deleteWorkById(workId);
    }
}
