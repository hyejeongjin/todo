package todo.todo.service;

import todo.todo.dto.TodoRequestDto;
import todo.todo.dto.TodoResponseDto;
import todo.todo.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    TodoResponseDto saveTodo(TodoRequestDto dto);
    List<TodoResponseDto> findAllTodos();
    TodoResponseDto findTodoById(Long id);
    int updateTodo(Long id, String todo, String author);
    int deleteTodo(Long id);


}
