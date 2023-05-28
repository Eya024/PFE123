package tn.stb.pfe.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import tn.stb.pfe.models.Work;
import tn.stb.pfe.services.WorkService;


@RestController
@RequestMapping("/works")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/all")
    public List<Work> showAllWorks() {
        return workService.getAllWorks();
    }

    @GetMapping("/{workId}")
    public Work showFormForUpdateWork(@PathVariable("workId") int workId) {
         workService.getWorkById(workId);
        return workService.getWorkById(workId);
    }

    @GetMapping("/new")
    public Work showFormForAddWork(Model model) {
        return new Work();
    }

    @PostMapping("/new")
    public void saveWork(Work work) {
        if (work.getId() != null) {
             workService.updateWork(work);
        } else {
             workService.createNewWork(work);
        }
    }

    @PostMapping("/delete")
    public void deleteWork(@RequestParam("workId") int workId) {
        workService.deleteWorkById(workId);
    }
}
