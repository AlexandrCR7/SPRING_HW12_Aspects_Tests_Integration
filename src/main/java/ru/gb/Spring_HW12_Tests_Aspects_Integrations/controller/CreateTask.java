package ru.gb.Spring_HW12_Tests_Aspects_Integrations.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.repository.NoteBookRepository;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.service.FileGateWay;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.service.TaskService;

import java.util.List;

@Controller
@AllArgsConstructor
public class CreateTask {

    private final TaskService taskService;
    private final FileGateWay fileGateWay;
    private final NoteBookRepository repository;

    @GetMapping("/CreateTask")
    public String addTask(Model model) {
        model.addAttribute("CreateTask", repository.findAll());
        return "CreateTask";
    }

    @PostMapping("/CreateTask")
    public String addTaskAction(@RequestBody Task task, Model model) {
        taskService.saveTask(taskService.addNewTask(task.getText()));
        model.addAttribute("task", taskService.getAllNotes());
        fileGateWay.writeToFile(task.getText(), task.toString());
        return "CreateTask";
    }
}
