package todo.todo.repository;

import todo.todo.dto.TodoResponseDto;
import todo.todo.entity.Todo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TodoRepository {

    TodoResponseDto saveTodo(Todo todo);

    // List<TodoResponseDto> findAllTodos();

    List<TodoResponseDto> findAllTodos(String author, LocalDate modified);

    Optional<Todo> findTodoById(Long id);

    Todo findTodoByIdOrElseThrow(Long id);

    int updateTodo(Long id, String todo, String author, String pw);

    int deleteTodo(Long id, String pw);
}
