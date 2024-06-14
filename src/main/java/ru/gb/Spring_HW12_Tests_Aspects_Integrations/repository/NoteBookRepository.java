package ru.gb.Spring_HW12_Tests_Aspects_Integrations.repository;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.Task;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.model.TaskStatus;

import java.util.List;


public interface NoteBookRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus taskStatus);
}
