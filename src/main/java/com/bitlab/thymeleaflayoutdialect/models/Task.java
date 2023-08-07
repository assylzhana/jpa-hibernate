package com.bitlab.thymeleaflayoutdialect.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String description;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate deadlineDate;

    private boolean isCompleted;
}
