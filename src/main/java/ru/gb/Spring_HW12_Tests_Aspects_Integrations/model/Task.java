package ru.gb.Spring_HW12_Tests_Aspects_Integrations.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.aspect.Changer;

import java.time.LocalDateTime;
//        Базовое задание:
//        Условие:
//        Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:
//        + Добавление задачи.
//        Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
//        +Просмотр всех задач.
//        Подсказка метод в контроллере: @GetMapping public List getAllTasks()
//        + Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
//        Подсказка метод в контроллере: @GetMapping("/status/{status}") public List getTasksByStatus(@PathVariable TaskStatus status)
//        Изменение статуса задачи.
//        Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
//        + Удаление задачи.
//        Подсказка метод в контроллере:
//@DeleteMapping("/{id}") public void deleteTask(@PathVariable Long id)
//        Репозиторий подсказка public interface TaskRepository extends JpaRepository<Task, Long>
//Структура задачи(класс Task):
//        ID (автоинкрементное)(тип Long)
//        Описание (не может быть пустым)(тип String)
//        Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
//        Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)
//        Подсказка понадобится энумератор:

//enum TaskStatus { NOT_STARTED, IN_PROGRESS, COMPLETED; }

@Data
@Entity(name = "notebook")
@Table(name = "notebook")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "TEXT")
    private String text;
    @Column(nullable = false,  name = "LOCALDATETIME")
    private LocalDateTime localDateTime;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(){
        this.status = TaskStatus.HAS_NOT_STARTED;
        this.localDateTime = LocalDateTime.now();
    }
}
