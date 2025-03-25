package todo.todo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.todo.dto.TodoRequestDto;
import todo.todo.dto.TodoResponseDto;
import todo.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    // 생성자 주입
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto dto){

        return new ResponseEntity<>(todoService.saveTodo(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TodoResponseDto> findAllTodos(){
        return todoService.findAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findTodoById(@PathVariable Long id){
        return new ResponseEntity<>(todoService.findTodoById(id), HttpStatus.OK);
    }





}
