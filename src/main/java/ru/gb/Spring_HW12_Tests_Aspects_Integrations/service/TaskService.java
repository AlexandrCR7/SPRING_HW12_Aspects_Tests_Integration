package ru.gb.Spring_HW12_Tests_Aspects_Integrations.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.aspect.Changer;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.TaskStatus;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.repository.NoteBookRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
public class TaskService {

    private final NoteBookRepository noteBookRepository;

    //Show all tasks
    public List<Task> getAllNotes(){
        return noteBookRepository.findAll();
    }

    //Searching by ID
    public Optional<Task> showTaskById(Long id){
        return noteBookRepository.findById(id);
    }

    //Searching by Status
    public List<Task> showTaskByStatus(TaskStatus status){
        return noteBookRepository.findByStatus(status);
    }

    //SaveTask
    public void saveTask(Task task){
        noteBookRepository.save(task);
    }

    //Add new task
    @Changer
    public Task addNewTask(String text){
        Task task1 = new Task();
        task1.setText(text);
        task1.setLocalDateTime(LocalDateTime.now());
        task1.setStatus(task1.getStatus());
        noteBookRepository.save(task1);
        return task1;
    }

    //Change Status
    public void changeStatus(Long id, TaskStatus status){
        Task task = noteBookRepository.findById(id).orElseThrow(NullPointerException::new);
        task.setStatus(status);
    }

    //Delete Task
    public void deleteTask(Long id){
        noteBookRepository.deleteById(id);
    }



}
