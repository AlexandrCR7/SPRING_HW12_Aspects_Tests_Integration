package ru.gb.Spring_HW12_Tests_Aspects_Integrations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.repository.NoteBookRepository;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.service.TaskService;

import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.TaskStatus.IN_PROGRESS;

@ExtendWith(MockitoExtension.class)
public class IdViewTest {

    @InjectMocks
    private TaskService service;
    @Mock
    private NoteBookRepository repository;

    @Test
    public void idCorrectAnswerTest(){
        //Блок предусловия
        Task task = new Task();
        task.setId(1L);
        task.setText("Привет!");
        task.setStatus(IN_PROGRESS);
        task.setLocalDateTime(LocalDateTime.now());

        given(repository.findById(task.getId())).willReturn(Optional.of(task));

        //Блок действия (вызова метода)
        service.showTaskById(1L);

        //Блок проверки действия
        verify(repository).findById(anyLong());

//        Task task2 = new Task();
//        task2.setText("Привет!");
//        repository.save(task2);
//
//        Task task = new Task();
//        task.setText("Привет!");
//
//        List<Task> tryTask = new ArrayList<>();
//        tryTask.add(task);
//        when(repository.findAll()).thenReturn(tryTask);
//        List<Task> actualNotes = service.getAllNotes();
//
//        assertEquals(task, task2);
    }
}
