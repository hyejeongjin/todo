package todo.todo.service;

import todo.todo.dto.TodoRequestDto;
import todo.todo.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {

    TodoResponseDto saveTodo(TodoRequestDto dto);
    List<TodoResponseDto> findAllTodos();
    TodoResponseDto findTodoById(Long id);
    TodoResponseDto updateTodo(Long id, String todo, String author, String pw);
    void deleteTodo(Long id, String pw);


}
