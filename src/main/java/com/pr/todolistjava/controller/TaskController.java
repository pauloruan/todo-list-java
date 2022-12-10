package com.pr.todolistjava.controller;

import com.pr.todolistjava.model.Task;
import com.pr.todolistjava.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {

    private TaskService taskService;

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        log.info("Criando uma nova tarefa com as informações [{}].", task);
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> findAllTasks() {
        log.info("Listando todas as tarefas cadastradas.");
        return taskService.findAllTasks();
    }

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> findTaskById(@PathVariable (value = "id") Long id) {
        log.info("Buscando tarefa com o Id [{}].", id);
        return taskService.findTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTask(@PathVariable (value = "id") Long id, @RequestBody Task task) {
        log.info("Atualizando tarefa com o Id [{}]. As informações alteradas foram: [{}].", id, task);
        return taskService.updateTask(task, id);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTask(@PathVariable (value = "id") Long id) {
        log.info("Excluindo tarefa com o Id [{}].", id);
        return taskService.deleteTask(id);
    }
}
