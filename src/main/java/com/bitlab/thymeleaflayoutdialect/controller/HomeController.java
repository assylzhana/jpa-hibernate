package com.bitlab.thymeleaflayoutdialect.controller;

import com.bitlab.thymeleaflayoutdialect.config.DBUtil;
import com.bitlab.thymeleaflayoutdialect.services.ApplicationRequestService;
import com.bitlab.thymeleaflayoutdialect.models.ApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private ApplicationRequestService applicationRequestService;

    @Autowired
    private DBUtil dbUtil;

    @GetMapping("/")
    public String homePage(Model model){
        List<ApplicationRequest> task =  applicationRequestService.getTasks();
        model.addAttribute("task",task);
        return "ex";
    }

    @PostMapping("/add-request")
    public String addPage(ApplicationRequest task){
        task.setHandled(false);
        applicationRequestService.addNewTask(task);
        return "redirect:/";
    }
    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id,Model model){
        ApplicationRequest task = applicationRequestService.getTaskById(id);
        model.addAttribute("task",task);
        return "details";
    }
    @PostMapping("/delete-task/{id}")
    public String deletePage(@PathVariable Long id){
        applicationRequestService.deleteTask(id);
        return "redirect:/";
    }
    @PostMapping("/done/{id}")
    public String makeDone(@PathVariable Long id){
        applicationRequestService.markTaskAsHandled(id);
        return "redirect:/";
    }
}
//  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
