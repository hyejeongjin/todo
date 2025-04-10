package todo.todo.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.todo.dto.TodoRequestDto;
import todo.todo.dto.TodoResponseDto;
import todo.todo.service.TodoService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    public List<TodoResponseDto> findAllTodos(@RequestParam(required=false) String author,
                                              @RequestParam(required=false) @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate modified){

        return todoService.findAllTodos(author, modified);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findTodoById(@PathVariable Long id){
        return new ResponseEntity<>(todoService.findTodoById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(
            @PathVariable Long id,
            @RequestBody TodoRequestDto dto){

        return new ResponseEntity<>(todoService.updateTodo(id, dto.getTodo(), dto.getAuthor(), dto.getPw()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable Long id,
            @RequestBody TodoRequestDto dto){

        todoService.deleteTodo(id, dto.getPw());

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
