package ru.gb.Spring_HW12_Tests_Aspects_Integrations.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class IdView {

    private final TaskService service;

    @GetMapping("/id/{id}")
    public Optional<Task> searchById(@PathVariable Long id){
        return service.showTaskById(id);
    }

}
