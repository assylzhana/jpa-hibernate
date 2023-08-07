package com.bitlab.thymeleaflayoutdialect.db;

import com.bitlab.thymeleaflayoutdialect.models.Task;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    @Getter
    private static List<Task> tasks = new ArrayList<>();
    private static Long id = 5L;

    static {
        tasks.add(new Task(1L, "Complete task", "+", LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), true));
        tasks.add(new Task(2L, "Clear home", "+", LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), false));
        tasks.add(new Task(3L, "Develop simple project", "+", LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), true));
        tasks.add(new Task(4L, "Learn Italian", "+", LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), false));
    }

    public static void addNewTask(Task task) {
        task.setId(id);
        id++;
        tasks.add(task);
    }
    public static Task getTaskById(Long id){
        return tasks.stream()
                .filter(task -> Objects.equals(task.getId(),id))
                .findFirst().orElse(null);

    }
    public static void deleteTask(Long id){
        tasks.removeIf(item -> Objects.equals(item.getId(),id));
    }
}
