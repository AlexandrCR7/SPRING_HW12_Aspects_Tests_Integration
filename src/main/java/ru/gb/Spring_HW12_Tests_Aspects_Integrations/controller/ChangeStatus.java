package ru.gb.Spring_HW12_Tests_Aspects_Integrations.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.TaskStatus;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.repository.NoteBookRepository;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.service.TaskService;

@RestController
@AllArgsConstructor
public class ChangeStatus {

    private final TaskService taskService;

    @PutMapping("/change/{id}")
    public void updateStatus(@PathVariable Long id, @RequestBody Task task){
        taskService.changeStatus(id, task.getStatus());
    }
}