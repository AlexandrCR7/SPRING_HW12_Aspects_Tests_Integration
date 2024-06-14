package ru.gb.Spring_HW12_Tests_Aspects_Integrations.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.TaskStatus;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.repository.NoteBookRepository;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
public class StatusView {

    private final TaskService service;

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.showTaskByStatus(status);
    }
}
