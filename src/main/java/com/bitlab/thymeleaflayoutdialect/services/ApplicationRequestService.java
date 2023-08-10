package com.bitlab.thymeleaflayoutdialect.services;

import com.bitlab.thymeleaflayoutdialect.models.ApplicationRequest;
import com.bitlab.thymeleaflayoutdialect.repositories.AppRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ApplicationRequestService {

    @Autowired
    private AppRepository appRepository;

    public List<ApplicationRequest> getTasks(){
        return appRepository.findAll();
    }


    public void addNewTask(ApplicationRequest task) {
        appRepository.save(task);
    }
    public  ApplicationRequest getTaskById(Long id){
        return appRepository.findById(id).orElse(null);

    }
    public void deleteTask(Long id){
        appRepository.deleteById(id);
    }
    public void markTaskAsHandled(Long id) {
        ApplicationRequest task = appRepository.findById(id).orElse(null);
        if (task != null) {
            task.setHandled(true);
            appRepository.save(task);
        }
    }

}
