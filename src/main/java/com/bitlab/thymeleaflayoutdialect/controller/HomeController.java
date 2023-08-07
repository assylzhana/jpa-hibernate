package com.bitlab.thymeleaflayoutdialect.controller;

import com.bitlab.thymeleaflayoutdialect.db.DBManager;
import com.bitlab.thymeleaflayoutdialect.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model){
        List<Task> task =  DBManager.getTasks();
        model.addAttribute("task",task);
        return "home";
    }

    @PostMapping("/add-task")
    public String addPage(Task task){
        task.setCompleted(false);
        DBManager.addNewTask(task);
        return "redirect:/";
    }
    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id,Model model){
        Task task = DBManager.getTaskById(id);
        model.addAttribute("task",task);
        return "details";
    }
    @PostMapping("/delete-task/{id}")
    public String deletePage(@PathVariable Long id){
        DBManager.deleteTask(id);
        return "redirect:/";
    }
    @PostMapping("/done/{id}")
    public String makeDone(@PathVariable Long id){
        Task task = DBManager.getTaskById(id);
        task.setCompleted(true);
        return "redirect:/";
    }
}
//  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
